package com.expenses.control.sys.api.dto.ingreso;

import com.expenses.control.sys.api.model.entities.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngresoDto {

    private long idIngreso;
    private double saldo;
    private Cuenta cuenta;
}
