package com.expenses.control.sys.api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta",nullable = false)
    private long idCuenta;
    @Basic
    private String nombre;
    private double saldo;
    @OneToMany(mappedBy = "idIngreso")
    private List<Ingreso> ingresoList;
    @ManyToOne
    @JoinColumn(name = "id_gasto")
    private Gasto gasto;

}
