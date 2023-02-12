import { createSlice } from '@reduxjs/toolkit'
import { blogApi } from '../services/blogs.service';

const initialState = [];

const blogsSlice = createSlice({
  name: 'blogs',
  initialState,
  reducers: {},
});

export const {} = blogsSlice.actions

export default blogsSlice.reducer