import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

// Define a service using a base URL and expected endpoints
export const blogApi = createApi({
    reducerPath: "blogApi",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/api" }),
    endpoints: (builder) => ({
        getBlogs: builder.query({
            query: () => "blogs",
        }),
        getBlogById: builder.query({
            query: (id) => `blogs/${id}`,
        }),
        getBlogsByKeyword: builder.query({
            query: (keyword) => `blogs/search?keyword=${keyword}`,
        })
    }),
});

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const {
  useGetBlogByIdQuery, useGetBlogsByKeywordQuery, useGetBlogsQuery
} = blogApi;
