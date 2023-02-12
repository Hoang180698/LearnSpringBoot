import { configureStore } from "@reduxjs/toolkit";
import todosReducer from "./slices/todos.slice"
import { todosApi } from "./slices/todosApi";

const store = configureStore({
    reducer : {
        [todosApi.reducerPath] : todosApi.reducer,

        todos : todosReducer
    },

    middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(todosApi.middleware),
})

export default store;