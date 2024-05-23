package com.expenses.control.sys.api.model.repository;

import com.expenses.control.sys.api.model.entities.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro,Long> {
    Rubro findByNombreRubro(String nombreRubro);
}
