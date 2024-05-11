package com.expenses.control.sys.api.persistence.repository;

import com.expenses.control.sys.api.persistence.entities.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso,Long> {
}
