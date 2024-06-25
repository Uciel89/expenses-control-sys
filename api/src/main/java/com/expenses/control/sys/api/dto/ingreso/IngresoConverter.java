package com.expenses.control.sys.api.dto.ingreso;

import com.expenses.control.sys.api.dto.converter.AbstractConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Ingreso;
import org.springframework.stereotype.Component;

@Component
public class IngresoConverter extends AbstractConverter<Ingreso,IngresoDto> {
    @Override
    public IngresoDto fromEntity(Ingreso entity) {
        if (entity==null) return null;
        return IngresoDto.builder()
                .idIngreso(entity.getIdIngreso())
                .saldo(entity.getSaldo())
                .cuenta(entity.getCuenta())
                .build();
    }

    @Override
    public Ingreso fromDto(IngresoDto dto) {
        if (dto ==null) return null;
        return  Ingreso.builder()
                .idIngreso(dto.getIdIngreso())
                .saldo(dto.getSaldo())
                .cuenta(dto.getCuenta())
                .build();
    }
}
