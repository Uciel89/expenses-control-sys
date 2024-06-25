package com.expenses.control.sys.api.validator;

import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Cuenta;

public class CuentaValidator {
    public static void validate(Cuenta cuenta) {
        if (cuenta.getNombre() == null || cuenta.getNombre().isEmpty())
            throw new ValidateServiceException("El nombre es obligatorio");
        if (cuenta.getSaldo() == 0 || cuenta.getSaldo() < 0)
            throw new ValidateServiceException("El saldo NO puede ser 0 o negativo");
        if (cuenta.getNombre().length() > 100)
            throw new ValidateServiceException("El nombre es muy largo");

    }
}
