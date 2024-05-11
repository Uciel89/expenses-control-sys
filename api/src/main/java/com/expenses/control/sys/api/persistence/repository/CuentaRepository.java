package com.expenses.control.sys.api.persistence.repository;

import com.expenses.control.sys.api.persistence.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
}
