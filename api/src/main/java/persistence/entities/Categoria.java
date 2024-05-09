package persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_categoria",nullable = false)
    private Long idCategoria;
    @Column
    private String nombreCategoria;
    @Column
    private Rubro rubro;
}
