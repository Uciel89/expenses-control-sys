import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const getIngresosRequest = () => {
  return axios.get("/ingreso", { signal: controller.signal });
};

export const getIngresoRequest = async (id) => {
  return axios.get(`/ingreso/${id}`, { signal: controller.signal });
};

export const postIngresoRequest = async (ingreso) => {
  return axios.post("/ingreso/", ingreso, { signal: controller.signal });
};

export const putIngresoRequest = async (ingreso) => {
  return axios.put("/ingreso/", ingreso, { signal: controller.signal });
};

export const deleteIngresoRequest = async (id) => {
  return axios.delete(`/ingreso/${id}`, { signal: controller.signal });
};
