import { CuentaEntidad } from "../entidades/cuenta.entidad";

export class CuentaValue implements CuentaEntidad {

    idCuenta: string;
    nombre!: string;
    saldo: number;
    gasto: number;
    constructor(idCuenta: string,nombre:string, saldo: number, gasto: number) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.gasto = gasto
    }

}