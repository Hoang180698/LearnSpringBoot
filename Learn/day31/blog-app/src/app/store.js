import { configureStore } from "@reduxjs/toolkit";
import { blogApi } from "./services/blogs.service";
import { categoryApi } from "./services/categories.service";
import { imagesApi } from "./services/images.service";
import blogsReducer from "./slices/blogs.slices";

const store = configureStore({
  reducer: {
    [blogApi.reducerPath]: blogApi.reducer,
    [categoryApi.reducerPath]: categoryApi.reducer,
    [imagesApi.reducerPath]: imagesApi.reducer,
    blogs: blogsReducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(
      blogApi.middleware,
      categoryApi.middleware,
      imagesApi.middleware
    ),
});

export default store;

