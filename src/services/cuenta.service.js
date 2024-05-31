import {
  axiosPreConf,
  loadAbortController,
} from "../utilities/axios-pre-config";

const axios = axiosPreConf;
const controller = loadAbortController();

export const getCuentasRequest = () => {
  return axios.get('/cuentas', {signal: controller.signal});
}

export const getCuentaRequest = async (id) => {
  return axios.get(`/cuenta/${id}`, {signal: controller.signal});
}

export const postCuentaRequest = async (cuenta) => {
  return axios.post('/cuenta/', cuenta ,{signal: controller.signal});
}

export const putCuentaRequest = async (cuenta) => {
  return axios.put('/cuenta/', cuenta ,{signal: controller.signal});
}

export const deleteCuentaRequest = async (id) => {
  return axios.delete(`/cuenta/${id}`,{signal: controller.signal});
}
