import { Cuenta } from "../dominio/cuenta_entidad";
import { IdCuenta } from "../dominio/cuenta_idCuenta";
import { CuentaNoEncontradaError } from "../dominio/errores_dominio/cuenta_noEncontrada_erro";
import { CuentaRepositorio } from "../dominio/cuenta_repositorio";

export class ListarCuentaPorID {

    constructor(private repositorio: CuentaRepositorio) { }

    async run(idCuenta: number): Promise<Cuenta | null> {

        const cuenta = await this.repositorio.listarPorId(new IdCuenta(idCuenta))

        if (!cuenta) throw new CuentaNoEncontradaError("La cuenta no se encuentra");

        return cuenta;
    }
}