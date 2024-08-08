import { Router } from "express";
import { cuentaRouter } from "../lib/cuentas/infraestructura/cuenta_rutas";



const router = Router();

router.use('/cuenta', cuentaRouter);


export { router }