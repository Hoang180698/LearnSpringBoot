import { createSlice } from '@reduxjs/toolkit'
import { todosApi} from './todosApi';

const initialState = []

const todosSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {
    addTodo : (state, action) => {
        state.push(action.payload);
    },
    deleteTodo : (state, action) => {
        const { id } = action.payload;
        const index = state.findIndex(todo => todo.id === id); // Tìm index todo cần xóa trong state
        state.splice(index, 1);
    },
    updateTodo : (state, action) => {
        const { id } = action.payload;
        const index = state.findIndex(todo => todo.id === id); // Tìm index todo cần xóa trong state
        state[index] = action.payload;
    }
  },
  extraReducers: (builder) => {
    builder.addMatcher(todosApi.endpoints.fetchTodos.matchFulfilled, (state, action) => {
      state = action.payload;
      return state;
    })
  }
});

export const {addTodo, deleteTodo, updateTodo} = todosSlice.actions

export default todosSlice.reducer