import prisma from "../../../shared/Prisma";
import { Cuenta } from "../dominio/cuenta_entidad";
import { IdCuenta } from "../dominio/cuenta_idCuenta";
import { Nombre } from "../dominio/cuenta_nombre";
import { CuentaRepositorio } from "../dominio/cuenta_repositorio";
import { Saldo } from "../dominio/cuenta_saldo";


export class PosgresCuentaRepositorio implements CuentaRepositorio {

    async crear(cuenta: Cuenta): Promise<void> {
        try {
            await prisma.cuenta.create({
                data: {
                    nombre: cuenta.nombre.value,
                    saldo: cuenta.saldo.value,

                },
            });
        } catch (error) {
            throw new Error(`Error al crear la cuenta: ${error}`);
        }
    }

    async listarTodas(): Promise<Cuenta[]> {
        try {
            const result = await prisma.cuenta.findMany();

            return result.map(
                (row) =>
                    new Cuenta(
                        new IdCuenta(row.idCuenta),
                        new Nombre(row.nombre),
                        new Saldo(row.saldo)
                    )
            );
        } catch (error) {
            throw new Error(`Error al listar todas las cuentas: ${error}`);
        }
    }

    async listarPorId(idCuenta: IdCuenta): Promise<Cuenta | null> {
        try {
            const result = await prisma.cuenta.findUnique({
                where: { idCuenta: idCuenta.value },
            });

            if (!result) {
                return null;
            }

            return new Cuenta(
                new IdCuenta(result.idCuenta),
                new Nombre(result.nombre),
                new Saldo(result.saldo)
            );
        } catch (error) {
            throw new Error(`Error al listar la cuenta por ID: ${error}`);
        }
    }

    async editar(cuenta: Cuenta): Promise<void> {
        try {
            await prisma.cuenta.update({
                where: { idCuenta: cuenta.idCuenta?.value },
                data: {
                    nombre: cuenta.nombre.value,
                    saldo: cuenta.saldo.value,
                },
            });
        } catch (error) {
            throw new Error(`Error al editar la cuenta: ${error}`);
        }
    }

    async eliminar(idCuenta: IdCuenta): Promise<void> {
        try {
            await prisma.cuenta.delete({
                where: { idCuenta: idCuenta.value },
            });
        } catch (error) {
            throw new Error(`Error al eliminar la cuenta: ${error}`);
        }
    }


}