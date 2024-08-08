import { IdCuenta } from "./cuenta_idCuenta";
import { Nombre } from "./cuenta_nombre";
import { Saldo } from "./cuenta_saldo";

export class Cuenta {
    idCuenta?: IdCuenta;
    nombre: Nombre;
    saldo: Saldo;

    constructor(idCuenta: IdCuenta, nombre: Nombre, saldo: Saldo) {
        this.idCuenta = idCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }
}