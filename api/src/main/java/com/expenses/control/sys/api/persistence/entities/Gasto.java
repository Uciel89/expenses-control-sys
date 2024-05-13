package com.expenses.control.sys.api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto",nullable = false)
    private long idGasto;
    @Basic
    private double monto;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @OneToMany(mappedBy = "idCuenta")
    private List<Cuenta> cuentaList;
}
