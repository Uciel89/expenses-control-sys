package com.expenses.control.sys.api.dto.cuenta;

import com.expenses.control.sys.api.dto.converter.AbstractConverter;
import com.expenses.control.sys.api.model.entities.Cuenta;
import org.springframework.stereotype.Component;

@Component
public class CuentaConverter extends AbstractConverter<Cuenta,CuentaDto> {
    @Override
    public CuentaDto fromEntity(Cuenta entity) {
        if (entity==null) return null;
        return CuentaDto.builder()
                .idCuenta(entity.getIdCuenta())
                .nombre(entity.getNombre())
                .saldo(entity.getSaldo())
                .ingresoList(entity.getIngresoList())
                .gasto(entity.getGasto())
                .build();
    }

    @Override
    public Cuenta fromDto(CuentaDto dto) {
        if (dto ==null) return null;
        return  Cuenta.builder()
                .idCuenta(dto.getIdCuenta())
                .nombre(dto.getNombre())
                .saldo(dto.getSaldo())
                .ingresoList(dto.getIngresoList())
                .gasto(dto.getGasto())
                .build();
    }
}
