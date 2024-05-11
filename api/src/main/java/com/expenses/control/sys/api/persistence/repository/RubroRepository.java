package com.expenses.control.sys.api.persistence.repository;

import com.expenses.control.sys.api.persistence.entities.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro,Long> {
}
