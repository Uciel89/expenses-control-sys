import { CuentaRepositorio } from "../../dominio/repositorio/cuenta.repositorio";
import { CuentaValue } from "../../dominio/values/cuenta.value";

export class CuentaCasodeUso {
    

    constructor(private readonly cuentaRepositorio:CuentaRepositorio){
    }

    public restarSaldo = async (cuentaValue: CuentaValue) => {
        const cuentaDescontada = await this.cuentaRepositorio.restarSaldoCuenta(cuentaValue)
        return cuentaDescontada;
    }
}