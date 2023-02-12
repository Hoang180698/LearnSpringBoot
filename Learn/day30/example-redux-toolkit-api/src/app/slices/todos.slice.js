import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'

const API_URL = "http://localhost:8080/api/v1/todos"

// fetchTodos : Thunk action creator
// Thunk action trả về 1 promise
// todos/fetchTodos : action type

export const fetchTodos = createAsyncThunk(
    'todos/fetchTodos',
    async () => {
        const response = await axios.get(API_URL);
        return response.data;
    }
)

export const addTodo = createAsyncThunk(
    'todos/addTodo',
    async (title) => {
        const response = await axios.post(API_URL, { title });
        return response.data;
    }
)

// updatedTodo : id, {title, status}
// updatedTodo : {id, title, status}
export const updateTodo = createAsyncThunk(
    'todos/addTodos',
    async (updatedTodo) => {
        const {id, ...data} = updatedTodo;
        const response = await axios.put(`${API_URL}/${id}`, data);
        return response.data;
    }
)

export const deleteTodo = createAsyncThunk(
    'todos/deleteTodo',
    async (id) => {
        await axios.delete(`${API_URL}/${id}`);
        return id;
    }
)

const initialState = []

const todosSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(fetchTodos.fulfilled, (state, action) => {
        state = action.payload;
        return state;
    })
    builder.addCase(addTodo.fulfilled, (state, action) => {
        state.push(action.payload);
    })
    builder.addCase(updateTodo.fulfilled, (state, action) => {
        const { id } = action.payload;
        const index = state.findIndex(todo => todo.id === id); // Tìm index todo cần xóa trong state
        state[index] = action.payload;
    })
    builder.addCase(deleteTodo.fulfilled, (state, action) => {
        const  id  = action.payload;
        const index = state.findIndex(todo => todo.id === id); // Tìm index todo cần xóa trong state
        state.splice(index, 1);
    })
  }
});

export const {} = todosSlice.actions

export default todosSlice.reducer