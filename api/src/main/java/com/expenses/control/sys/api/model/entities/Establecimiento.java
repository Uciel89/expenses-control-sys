package com.expenses.control.sys.api.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "establecimientos")
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento",nullable = false)
    private long idEstablecimiento;
    @Basic
    private String nombreEstablecimiento;
    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;
    @OneToMany(mappedBy = "idGasto")
    private List<Gasto> gastoList;
}