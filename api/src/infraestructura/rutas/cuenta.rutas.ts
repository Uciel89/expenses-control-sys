import { Router } from "express";
import { CuentaCasodeUso } from "../../aplicacion/casosDeUso/cuentaCasodeUso";
import { CuentaControlador } from "../controladores/cuenta.controlador";
import { PosgresRepositorio } from "../repositorio/posgres.repositorio";


const router = Router();

const cuentaRepositorio = new PosgresRepositorio();

const cuentaCasodeUso = new CuentaCasodeUso(cuentaRepositorio);

const cuentaController = new CuentaControlador(cuentaCasodeUso);

router.get("cuenta/restar/:id", cuentaController.restarSaldo);

export {router};