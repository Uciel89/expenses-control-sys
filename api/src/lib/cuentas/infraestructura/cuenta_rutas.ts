import { Router } from "express";
import { Cuenta } from "../dominio/cuenta_entidad";
import { CuentaControlador } from "./cuenta_controlador";

const controlador = new CuentaControlador();

const cuentaRouter = Router();


cuentaRouter.get("/cuenta/", controlador.listarTodas);

cuentaRouter.get("/cuenta/:id", controlador.listarPorId);

cuentaRouter.post("/cuenta/", controlador.crear);

cuentaRouter.put("/cuenta/", controlador.editar);

cuentaRouter.delete("/cuenta/", controlador.eliminar);

export { cuentaRouter };