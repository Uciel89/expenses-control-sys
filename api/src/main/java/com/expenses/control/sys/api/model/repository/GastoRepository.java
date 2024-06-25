package com.expenses.control.sys.api.model.repository;

import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto,Long> {

}
