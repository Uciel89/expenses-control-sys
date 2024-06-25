package com.expenses.control.sys.api.dto.establecimiento;

import com.expenses.control.sys.api.dto.converter.AbstractConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import org.springframework.stereotype.Component;

@Component
public class EstablecimientoConverter extends AbstractConverter<Establecimiento,EstablecimientoDto> {
    @Override
    public EstablecimientoDto fromEntity(Establecimiento entity) {
        if (entity==null) return null;
        return EstablecimientoDto.builder()
                .idEstablecimiento(entity.getIdEstablecimiento())
                .nombreEstablecimiento(entity.getNombreEstablecimiento())
                .rubro(entity.getRubro())
                .gastoList(entity.getGastoList())
                .build();
    }

    @Override
    public Establecimiento fromDto (EstablecimientoDto dto) {
        if (dto ==null) return null;
        return  Establecimiento.builder()
                .idEstablecimiento(dto.getIdEstablecimiento())
                .nombreEstablecimiento(dto.getNombreEstablecimiento())
                .rubro(dto.getRubro())
                .gastoList(dto.getGastoList())
                .build();
    }
}
