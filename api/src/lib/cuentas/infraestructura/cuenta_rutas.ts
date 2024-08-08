import { Router } from "express";
import { Cuenta } from "../dominio/cuenta_entidad";
import { CuentaControlador } from "./cuenta_controlador";

const controlador = new CuentaControlador();

const cuentaRouter = Router();


cuentaRouter.get("/", controlador.listarTodas);

cuentaRouter.get("/:id", controlador.listarPorId);

cuentaRouter.post("/", controlador.crear);

cuentaRouter.put("/", controlador.editar);

cuentaRouter.delete("/:id", controlador.eliminar);

export { cuentaRouter };