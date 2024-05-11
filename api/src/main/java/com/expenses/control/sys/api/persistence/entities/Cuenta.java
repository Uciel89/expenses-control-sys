package com.expenses.control.sys.api.persistence.entities;

import io.micrometer.core.annotation.Counted;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cuenta",nullable = false)
    private Long idCuenta;
    @Basic
    private String nombre;
    private double saldo;
    @OneToMany(mappedBy = "idIngreso")
    private List<Ingreso> ingresoList;
    @ManyToOne
    @JoinColumn(name = "id_gasto")
    private Gasto gasto;
}
