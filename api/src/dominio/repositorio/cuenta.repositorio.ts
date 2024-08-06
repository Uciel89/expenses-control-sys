import { CuentaEntidad } from "../entidades/cuenta.entidad";



export interface CuentaRepositorio {
	crearCuenta(idCuenta: string, nombre: string, saldo: number,):
		Promise<CuentaEntidad | null>;

	restarSaldoCuenta(cuentaValue: CuentaEntidad):
		Promise<CuentaEntidad>;
}