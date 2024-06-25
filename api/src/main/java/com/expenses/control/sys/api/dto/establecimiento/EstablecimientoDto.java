package com.expenses.control.sys.api.dto.establecimiento;

import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.model.entities.Rubro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstablecimientoDto {

    private long idEstablecimiento;
    private String nombreEstablecimiento;
    private Rubro rubro;
    private List<Gasto> gastoList;
}
