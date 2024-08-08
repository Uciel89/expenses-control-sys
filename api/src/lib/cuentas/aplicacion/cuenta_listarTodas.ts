import { Cuenta } from "../dominio/cuenta_entidad";
import { CuentaRepositorio } from "../dominio/cuenta_repositorio";

export class ListarTodas {

    constructor(private repositorio: CuentaRepositorio) { }

    async run(): Promise<Cuenta[]> {

        return this.repositorio.listarTodas();
    }
}