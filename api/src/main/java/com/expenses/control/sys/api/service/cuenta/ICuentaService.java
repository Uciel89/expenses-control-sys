package com.expenses.control.sys.api.service.cuenta;

import com.expenses.control.sys.api.dto.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<Cuenta> getAllCuentas();
    Cuenta getCuentaById(long id);

    Cuenta add(Cuenta cuenta);

    void delete(Cuenta cuenta);

    Cuenta update (Cuenta cuenta);
}
