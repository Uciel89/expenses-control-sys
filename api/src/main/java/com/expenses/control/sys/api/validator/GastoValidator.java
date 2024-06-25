package com.expenses.control.sys.api.validator;

import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.entities.Gasto;

public class GastoValidator {
    public static void validate(Gasto gasto){
        if(gasto.getMonto() == 0 || gasto.getMonto() < 0 )
            throw new ValidateServiceException("El monto no puede ser 0 o negativo");
    }
}
