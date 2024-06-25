import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const getRubrosRequest = () => {
  return axios.get("/rubro", { signal: controller.signal });
};

export const getRubroRequest = async (id) => {
  return axios.get(`/rubro/${id}`, { signal: controller.signal });
};

export const postRubroRequest = async (rubro) => {
  return axios.post("/rubro/", rubro, { signal: controller.signal });
};

export const putRubroRequest = async (rubro) => {
  return axios.put("/rubro/", rubro, { signal: controller.signal });
};

export const deleteRubroRequest = async (id) => {
  return axios.delete(`/rubro/${id}`, { signal: controller.signal });
};
