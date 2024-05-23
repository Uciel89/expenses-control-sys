package com.expenses.control.sys.api.model.repository;

import com.expenses.control.sys.api.model.entities.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento,Long> {
    Establecimiento findByNombreEstablecimiento(String nombreEstablecimiento);

}
