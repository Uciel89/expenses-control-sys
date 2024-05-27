package com.expenses.control.sys.api.service.ingreso;

import com.expenses.control.sys.api.model.entities.Ingreso;

import java.util.List;

public interface IIngresoService {
    List<Ingreso> getAllIngresos();
    Ingreso getIngresoById(long id);

    Ingreso create(Ingreso ingreso);

    void delete(Ingreso ingreso);

    Ingreso update (Ingreso ingreso);
}
