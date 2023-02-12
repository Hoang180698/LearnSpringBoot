import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

// Define a service using a base URL and expected endpoints
export const blogApi = createApi({
    reducerPath: "blogApi",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/api/admin" }),
    endpoints: (builder) => ({
        getBlogs: builder.query({
            query: () => "blogs",
        }),
        getBlogById: builder.query({
            query: (id) => `blogs/${id}`,
        }),
        getOwnBlogs: builder.query({
            query: () => `blogs/own-blogs`,
        }),
        createBlog: builder.mutation({
            query: (data) => ({
                url: "blogs",
                method: "POST",
                body: data,
            }),
        }),
        updateBlog: builder.mutation({
            query: ({ id, ...data }) => {
                console.log({ id, data });
                return {
                    url: `blogs/${id}`,
                    method: "PUT",
                    body: data,
                }
            },
        }),
        deleteBlog: builder.mutation({
            query: (id) => ({
                url: `blogs/${id}`,
                method: "DELETE",
            }),
        }),
    }),
});

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const {
    useGetBlogsQuery,
    useGetBlogByIdQuery,
    useGetOwnBlogsQuery,
    useCreateBlogMutation,
    useUpdateBlogMutation,
    useDeleteBlogMutation,
} = blogApi;
