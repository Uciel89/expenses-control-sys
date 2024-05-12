package com.expenses.control.sys.api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
