package com.expenses.control.sys.api.dto.rubro;

import com.expenses.control.sys.api.model.entities.Establecimiento;
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
public class RubroDto {

    private long idRubro;
    private String nombreRubro;
    private double total;
    private List<Establecimiento> establecimientoList;
}
