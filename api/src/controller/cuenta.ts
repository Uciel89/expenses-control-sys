import { Request, Response } from "express"
import { handleHttp } from "../utils/error.handle"

const getCuenta = (req: Request, res: Response) => {
    try {
        
    } catch (e) {
        handleHttp(res, 'ERROR_GET_CUENTA')
    }
}

const getCuentabyId = (req: Request, res: Response) => {
    try {

    } catch (e) {
        handleHttp(res, 'ERROR_GET_CUENTA_BY_ID')
    }
}

const updateCuenta = (req: Request, res: Response) => {
    try {

    } catch (e) {
        handleHttp(res, 'ERROR_UPDATE_CUENTA')
    }
}
const postCuenta = ({body}: Request, res: Response) => {
    try {
        res.send(body);
    } catch (e) {
        handleHttp(res, 'ERROR_POST_CUENTA')
    }
}

const deleteCuenta = (req: Request, res: Response) => {
    try {

    } catch (e) {
        handleHttp(res, 'ERROR_DELETE_CUENTA')
    }
}

export { getCuenta, getCuentabyId, postCuenta, deleteCuenta, updateCuenta };