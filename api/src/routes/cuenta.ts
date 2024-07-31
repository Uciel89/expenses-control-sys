import { Request, Response, Router } from "express";
import { deleteCuenta, getCuenta, getCuentabyId, postCuenta, updateCuenta } from "../controller/cuenta";

const router = Router();

router.get("/", getCuenta);

router.get("/:id", getCuentabyId);

router.post("/", postCuenta);

router.put("/:id", updateCuenta);

router.delete("/:id", deleteCuenta);

export { router };