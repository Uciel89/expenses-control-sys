package com.expenses.control.sys.api.persistence.repository;

import com.expenses.control.sys.api.persistence.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
