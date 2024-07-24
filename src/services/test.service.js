import axios from "axios"

export const TestingServices = () => {
    return axios.get('https://rickandmortyapi.com/api/character/2')
}