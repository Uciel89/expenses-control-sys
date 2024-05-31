import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const getEstablecimientosRequest = () => {
  return axios.get("/establecimiento", { signal: controller.signal });
};

export const getEstablecimientoRequest = async (id) => {
  return axios.get(`/establecimiento/${id}`, { signal: controller.signal });
};

export const postEstablecimientoRequest = async (establecimiento) => {
  return axios.post("/establecimiento/", establecimiento, {
    signal: controller.signal,
  });
};

export const putEstablecimientoRequest = async (establecimiento) => {
  return axios.put("/establecimiento/", establecimiento, {
    signal: controller.signal,
  });
};

export const deleteEstablecimientoRequest = async (id) => {
  return axios.delete(`/establecimiento/${id}`, { signal: controller.signal });
};
