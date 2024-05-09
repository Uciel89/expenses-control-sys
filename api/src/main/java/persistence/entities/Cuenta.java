package persistence.entities;

import io.micrometer.core.annotation.Counted;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cuenta",nullable = false)
    private Long idCuenta;
    @Column
    private String nombre;
    @Column
    private double saldo;
}
