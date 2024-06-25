import { getItem } from '@/utilities/localStorage';
import { createSlice } from '@reduxjs/toolkit';

export const UserEmptyState = {
  id_vivero: 0,
  username: '',
  token: ''
};

// Valor inicial
const initialState = getItem('user') || UserEmptyState;

// Construcción del slice
export const userSlice = createSlice({
  name: 'user',
  initialState: initialState,
  reducers: {
    createUser: (state, action) => {
      const { username, token, id_vivero } = action.payload;      
      state.username = username
      state.token = token
      state.id_vivero = id_vivero
    },
    modifyUser: (state, action) => {
      state.id_vivero = action.payload;
    },
    resetUser: () => UserEmptyState
  }
});

export const { createUser, modifyUser, resetUser } = userSlice.actions;

export default userSlice.reducer;