package com.expenses.control.sys.api.dto;

import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.model.entities.Ingreso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CuentaDto {

    private long idCuenta;
    private String nombre;
    private double saldo;
    private List<Ingreso> ingresoList;
    private Gasto gasto;
}
