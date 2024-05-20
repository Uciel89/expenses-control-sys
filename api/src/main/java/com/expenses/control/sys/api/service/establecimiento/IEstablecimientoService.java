package com.expenses.control.sys.api.service.establecimiento;


import com.expenses.control.sys.api.model.entities.Establecimiento;
import java.util.List;

public interface IEstablecimientoService {

    List<Establecimiento> getAllEstablecimientos();
    Establecimiento getEstablecimientoById(long id);

    Establecimiento add(Establecimiento establecimiento);

    Establecimiento delete(long id);

    Establecimiento update (Establecimiento establecimiento);
}
