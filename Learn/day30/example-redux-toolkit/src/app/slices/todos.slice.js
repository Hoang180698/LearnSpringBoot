import { createSlice } from '@reduxjs/toolkit'

const initialState = [
    { id : 1, title: "Đá bóng", status: false},
    { id : 2, title: "Làm bài tập", status: false},
    { id : 3, title: "Chơi game", status: false}
]

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
  }
});

export const {addTodo, deleteTodo, updateTodo} = todosSlice.actions

export default todosSlice.reducer