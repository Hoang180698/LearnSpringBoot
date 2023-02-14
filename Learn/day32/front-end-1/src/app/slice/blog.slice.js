import { createSlice } from '@reduxjs/toolkit';

const initialState = {};

const blogSlice = createSlice({
    name: 'blog',
    initialState,
    reducers: {},
});

// eslint-disable-next-line no-empty-pattern
export const {} = blogSlice.actions;

export default blogSlice.reducer;
