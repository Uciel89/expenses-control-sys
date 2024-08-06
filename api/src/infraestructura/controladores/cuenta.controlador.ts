import { Request, Response } from "express"
import { handleHttp } from "../../utils/error.handle"
import { CuentaCasodeUso } from "../../aplicacion/casosDeUso/cuentaCasodeUso"

export class CuentaControlador {
    constructor(private cuentaCasodeUso: CuentaCasodeUso){

    }
public restarSaldo = async ({body}: Request, res: Response) => {
    try {
        const cuentaDebitada = await this.cuentaCasodeUso.restarSaldo(body)
        res.send({cuentaDebitada})
    } catch (e) {
        handleHttp(res, 'ERROR_GET_CUENTA')
    }
}

}



