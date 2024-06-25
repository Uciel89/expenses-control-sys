package com.expenses.control.sys.api.validator;

import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;

public class EstablecimientoValidator {
    public static void validate(Establecimiento establecimiento){
        if(establecimiento.getNombreEstablecimiento() == null || establecimiento.getNombreEstablecimiento().isEmpty())
            throw new ValidateServiceException("El nombre es obligatorio");
    }
}
