package com.expenses.control.sys.api.model.repository;

import com.expenses.control.sys.api.model.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
    Cuenta findByNombre(String nombre);
}
