import { Request, Response } from "express";
import { ServiciodeRepositorios } from "../../../shared/ServiciodeRepositorios";

export class CuentaControlador {
    
    async crear(req: Request, res: Response): Promise<void> {
        try {
            const {idCuenta,nombre,saldo} = req.body as  {
                idCuenta:number;
                nombre:string;
                saldo:number;
            }
            await ServiciodeRepositorios.cuenta.crear.run(idCuenta,nombre,saldo);
            res.status(201).json({ message: 'Cuenta creada con éxito' });
        } catch (error) {
            res.status(500).json({ error: `Error al crear la cuenta: ${error}` });
        }
    }

    async listarTodas(req: Request, res: Response): Promise<void> {
        try {
            const cuentas = await ServiciodeRepositorios.cuenta.listasTodas.run();
            res.json(cuentas).status(200);
        } catch (error) {
            res.status(500).json({ error: `Error al listar todas las cuentas: ${error}` });
        }
    }

    async listarPorId(req: Request, res: Response): Promise<void> {
        try {
            const cuenta = await ServiciodeRepositorios.cuenta.listarPorId.run(parseInt(req.params.idCuenta));
            if (cuenta) {
                res.json(cuenta).status(200);
            } else {
                res.status(404).json({ error: 'Cuenta no encontrada' });
            }
        } catch (error) {
            res.status(500).json({ error: `Error al listar la cuenta por ID: ${error}` });
        }
    }

    

    async editar(req: Request, res: Response): Promise<void> {
        try {
            const { idCuenta, nombre, saldo } = req.body;
            
            await ServiciodeRepositorios.cuenta.editar.run(idCuenta,nombre,saldo);
            res.status(200).json({ message: 'Cuenta editada con éxito' });
        } catch (error) {
            res.status(500).json({ error: `Error al editar la cuenta: ${error}` });
        }
    }

    async eliminar(req: Request, res: Response): Promise<void> {
        try {
            await ServiciodeRepositorios.cuenta.eliminar.run((parseInt(req.params.idCuenta)));
            res.status(200).json({ message: 'Cuenta eliminada con éxito' });
        } catch (error) {
            res.status(500).json({ error: `Error al eliminar la cuenta: ${error}` });
        }
    }
}