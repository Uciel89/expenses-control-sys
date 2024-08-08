import { CrearCuenta } from "../lib/cuentas/aplicacion/cuenta_crear";
import { EditarCuenta } from "../lib/cuentas/aplicacion/cuenta_editar";
import { EliminarCuenta } from "../lib/cuentas/aplicacion/cuenta_eliminar";
import { ListarCuentaPorID } from "../lib/cuentas/aplicacion/cuenta_listarPorId";
import { ListarTodas } from "../lib/cuentas/aplicacion/cuenta_listarTodas";
import { PosgresCuentaRepositorio } from "../lib/cuentas/infraestructura/cuenta_posgres_repositorio";

const cuentaRepositorio = new PosgresCuentaRepositorio();

export const ServiciodeRepositorios = {

    cuenta: {
        listasTodas: new ListarTodas(cuentaRepositorio),

        listarPorId: new ListarCuentaPorID(cuentaRepositorio),

        crear: new CrearCuenta(cuentaRepositorio),

        editar: new EditarCuenta(cuentaRepositorio),

        eliminar: new EliminarCuenta(cuentaRepositorio)

    }
}