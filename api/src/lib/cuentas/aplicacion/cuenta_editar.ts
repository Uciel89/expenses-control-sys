import { Cuenta } from "../dominio/cuenta_entidad";
import { IdCuenta } from "../dominio/cuenta_idCuenta";
import { Nombre } from "../dominio/cuenta_nombre";
import { CuentaRepositorio } from "../dominio/cuenta_repositorio";
import { Saldo } from "../dominio/cuenta_saldo";

export class EditarCuenta {

    constructor(private repositorio: CuentaRepositorio) { }

    async run(idCuenta: number, nombre: string, saldo: number): Promise<void> {

        const cuenta = new Cuenta(
            new IdCuenta(idCuenta),
            new Nombre(nombre),
            new Saldo(saldo)
        )

        return this.repositorio.editar(cuenta);
    }
}