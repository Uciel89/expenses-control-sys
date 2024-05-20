package com.expenses.control.sys.api.service.rubro;

import com.expenses.control.sys.api.model.entities.Rubro;

import java.util.List;

public interface IRubroService {
    List<Rubro> getAllRubros();
    Rubro getRubroById(long id);

    Rubro add(Rubro rubro);

    Rubro delete(long id);

    Rubro update (Rubro rubro);
}
