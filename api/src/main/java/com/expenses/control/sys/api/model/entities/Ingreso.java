package com.expenses.control.sys.api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ingresos")
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso",nullable = false)
    private long idIngreso;
    @Basic
    private double saldo;
    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
}
