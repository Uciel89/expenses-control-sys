package com.expenses.control.sys.api.validator;

import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.entities.Ingreso;

public class IngresoValidator {
    public static void validate(Ingreso ingreso){
        if(ingreso.getSaldo() == 0 || ingreso.getSaldo() < 0)
            throw new ValidateServiceException("El saldo no puede ser 0 o negativo");
        if(ingreso.getCuenta() == null)
            throw new ValidateServiceException("Debe seleccionar una cuenta a la que pertence el gasto");
    }
}
