import { CuentaEntidad } from "../../dominio/entidades/cuenta.entidad";
import { CuentaRepositorio } from "../../dominio/repositorio/cuenta.repositorio";
import { CuentaValue } from "../../dominio/values/cuenta.value";
import prisma from "../db/prisma";

export class PosgresRepositorio implements CuentaRepositorio{
    async crearCuenta(idCuenta: string, nombre: string, saldo: number): Promise<CuentaEntidad | null> {
        throw new Error("Method not implemented.");
    }
    async restarSaldoCuenta(cuentaValue: CuentaEntidad): Promise<CuentaEntidad> {
        const { idCuenta, saldo } = cuentaValue;

        const cuentaDebitar = await prisma.cuenta.findUnique({
            where: { idCuenta }
        });
        return cuentaDebitar;
    }
    
}