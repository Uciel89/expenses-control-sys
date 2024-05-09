package persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;
@Data
@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_gasto",nullable = false)
    private Long idCuenta;
    @Column
    private double monto;
    @Column
    private Categoria categoria;
    @Column
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
}
