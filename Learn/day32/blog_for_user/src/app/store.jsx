import { configureStore } from "@reduxjs/toolkit";
import {blogApi} from "./services/blogs.service"
import { categoriesApi } from "./services/categories.service";

const store = configureStore({
  reducer: {
    [blogApi.reducerPath]: blogApi.reducer,
    [categoriesApi.reducerPath]: categoriesApi.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(
        blogApi.middleware,
        categoriesApi.middleware
    ),
});

export default store;