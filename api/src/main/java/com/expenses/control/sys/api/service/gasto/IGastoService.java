package com.expenses.control.sys.api.service.gasto;

import com.expenses.control.sys.api.model.entities.Gasto;

import java.util.List;

public interface IGastoService {
    List<Gasto> getAllGastos();
    Gasto getGastoById(long id);

    Gasto add(Gasto gasto);

    Gasto delete(long id);

    Gasto update (Gasto gasto);
}
