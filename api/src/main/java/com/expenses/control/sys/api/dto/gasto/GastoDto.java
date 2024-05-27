package com.expenses.control.sys.api.dto.gasto;

import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GastoDto {

    private long idGasto;
    private double monto;
    private LocalDateTime fecha;
    private Establecimiento establecimiento;
    private List<Cuenta> cuentaList;
}
