import { Cuenta } from "./cuenta_entidad";
import { IdCuenta } from "./cuenta_idCuenta";

export interface CuentaRepositorio {

    crear(cuenta: Cuenta): Promise<void>;

    listarTodas(): Promise<Cuenta[]>;

    listarPorId(idCuenta: IdCuenta): Promise<Cuenta | null>;

    editar(cuenta: Cuenta): Promise<void>;

    eliminar(idCuenta: IdCuenta): Promise<void>;


}