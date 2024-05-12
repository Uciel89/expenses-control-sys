package com.expenses.control.sys.api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria",nullable = false)
    private long idCategoria;
    @Basic
    private String nombreCategoria;
    @OneToMany(mappedBy = "idRubro")
    private List<Rubro> rubroList;
    @OneToMany(mappedBy = "idGasto")
    private List<Gasto> gastoList;
}
