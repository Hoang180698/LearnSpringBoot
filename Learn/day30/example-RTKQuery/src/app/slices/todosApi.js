import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const todosApi = createApi({
  // Tương tự tên Slice khi tạo Slice thông thường
  reducerPath: 'todosApi',

  // Cấu hình chung cho tất cả request
  baseQuery: fetchBaseQuery({
    baseUrl: 'http://localhost:8080/api/v1/todos',
  }),

  // Các endpoints (lệnh gọi request)
  endpoints: (builder) => ({
    fetchTodos : builder.query({
        query: () => "",
    }),

    addTodo : builder.mutation({
        query : (title) => ({
            url : "",
            method : 'POST',
            body : {title : title}
        })
    })
  }),
});
export const { useFetchTodosQuery, useAddTodoMutation } = todosApi;