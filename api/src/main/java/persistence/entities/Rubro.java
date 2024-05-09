package persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_rubro",nullable = false)
    private Long idRubro;
    @Column
    private String nombreRubro;
    @Column
    private double total;
}
