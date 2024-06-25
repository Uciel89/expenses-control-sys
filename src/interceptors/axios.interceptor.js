import { axiosPreConf } from "../utilities/axios-pre-config";
import { getItem } from "../utilities/local-storage-utils";

const axios = axiosPreConf;

export const AxiosInterceptor = () => {
  // Actualización de los headers con las cabeceras para la autenticación
  const updateHeader = (request) => {
    const token = getItem("token");
    const newHeaders = {
      Authorization: token,
      "Content-Type": "application/json",
    };
    request.headers = newHeaders;
    return request;
  };

  // Interceptamos las consultas - requests
  axios.interceptors.request.use((request) => {
    if (request.url.includes("user")) return request;
    return updateHeader(request);
  });

  // Interceptamos las respuestas - responses
  axios.interceptors.response.use(
    // Función para la respuesta en si
    (response) => {
      return response;
    },
    // Función para el manejo de errores
    (error) => {
      console.log("error", error);
      return Promise.reject(error);
    }
  );
};
