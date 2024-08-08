import { Cuenta } from "../dominio/cuenta_entidad";
import { IdCuenta } from "../dominio/cuenta_idCuenta";
import { CuentaRepositorio } from "../dominio/cuenta_repositorio";

export class EliminarCuenta {

    constructor(private repositorio: CuentaRepositorio) { }

    async run(idCuenta: number): Promise<void> {

        await this.repositorio.eliminar(new IdCuenta(idCuenta));
    }
}