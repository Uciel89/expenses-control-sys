import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const loginRequest = (user) => {
  return axios.post("/user/login", user, { signal: controller.signal });
};

export const registerRequest = async (newUser) => {
  return axios.post('/user/register/', newUser ,{ signal: controller.signal });
};
