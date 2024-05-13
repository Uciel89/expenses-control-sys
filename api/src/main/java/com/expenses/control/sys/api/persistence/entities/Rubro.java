package com.expenses.control.sys.api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rubros")
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro",nullable = false)
    private long idRubro;
    @Basic
    private String nombreRubro;
    private double total;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
