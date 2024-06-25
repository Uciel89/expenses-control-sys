package com.expenses.control.sys.api.validator;

import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Ingreso;
import com.expenses.control.sys.api.model.entities.Rubro;

public class RubroValidator {
    public static void validate(Rubro rubro){
        if(rubro.getNombreRubro()== null || rubro.getNombreRubro().isEmpty())
            throw new ValidateServiceException("El nombre del rubro no puede ser nulo o estar vacío");
    }
}
