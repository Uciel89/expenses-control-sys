package com.expenses.control.sys.api.persistence.repository;

import com.expenses.control.sys.api.persistence.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto,Long> {
}
