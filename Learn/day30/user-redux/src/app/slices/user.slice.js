import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'

const API_URL = "http://localhost:8080/api/v1/users"

export const getAllUser = createAsyncThunk(
    'user/getAllUser',
    async () => {
        const response = await axios.get(API_URL);
        return response.data;
    }
)

export const getUserByName = createAsyncThunk(
    'user/getUserByName',
    async (name) => {
        const response = await axios.get(`${API_URL}/search?name=${name}`);
        return response.data;
    }
)

export const createUser = createAsyncThunk(
    'user/createUser',
    async (user) => {
        const response = await axios.post(API_URL, user);
        return response.data;
    }
)

export const getAdress =createAsyncThunk(
    'user/createAdress',
    async () => {
        const response = await axios.get("https://provinces.open-api.vn/api/p/");
        return response.data;
    }
)

export const deleteUser = createAsyncThunk(
    'user/createAdress',
    async (id) => {
        await axios.delete(`${API_URL}/${id}`);
        return id;
    }
)

const initialState = {

}

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(getAllUser.fulfilled, (state, action) => {
        state = action.payload;
        return state;
    })
    builder.addCase(getUserByName.fulfilled, (state, action) => {
        state = action.payload;
        return state;
    })
    builder.addCase(createUser.fulfilled, (state, action) => {
        state.push(action.payload);
    })
    builder.addCase(deleteUser.fulfilled, (state, action) => {
        const  id  = action.payload;
        const index = state.findIndex(todo => todo.id === id); // Tìm index todo cần xóa trong state
        state.splice(index, 1);
    })
  }
});

export const {} = userSlice.actions

export default userSlice.reducer