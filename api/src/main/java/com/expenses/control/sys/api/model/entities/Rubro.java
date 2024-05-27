package com.expenses.control.sys.api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @OneToMany(mappedBy = "rubro")
    private List<Establecimiento> establecimientoList;

}
