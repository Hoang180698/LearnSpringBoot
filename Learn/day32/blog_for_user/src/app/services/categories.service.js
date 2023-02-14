import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

// Define a service using a base URL and expected endpoints
export const categoriesApi = createApi({
    reducerPath: "categoriesApi",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/api" }),
    endpoints: (builder) => ({
        getCategories: builder.query({
            query: () => "categories",
        }), 
    }),
});

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const {
    useGetCategoriesQuery,
} = categoriesApi;
