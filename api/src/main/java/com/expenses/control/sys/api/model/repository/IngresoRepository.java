package com.expenses.control.sys.api.model.repository;

import com.expenses.control.sys.api.model.entities.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso,Long> {
}
