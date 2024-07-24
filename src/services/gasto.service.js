import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const getGastosRequest = () => {
  return axios.get("/gasto", { signal: controller.signal });
};

export const getGastoRequest = async (id) => {
  return axios.get(`/gasto/${id}`, { signal: controller.signal });
};

export const postGastoRequest = async (gasto) => {
  return axios.post("/gasto/", gasto, { signal: controller.signal });
};

export const putGastoRequest = async (gasto) => {
  return axios.put("/gasto/", gasto, { signal: controller.signal });
};

export const deleteGastoRequest = async (id) => {
  return axios.delete(`/gasto/${id}`, { signal: controller.signal });
};
