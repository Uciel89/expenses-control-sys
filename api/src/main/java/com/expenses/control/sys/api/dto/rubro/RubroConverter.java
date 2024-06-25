package com.expenses.control.sys.api.dto.rubro;

import com.expenses.control.sys.api.dto.converter.AbstractConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Rubro;
import org.springframework.stereotype.Component;

@Component
public class RubroConverter extends AbstractConverter<Rubro, RubroDto> {
    @Override
    public RubroDto fromEntity(Rubro entity) {
        if (entity==null) return null;
        return RubroDto.builder()
                .idRubro(entity.getIdRubro())
                .nombreRubro(entity.getNombreRubro())
                .total(entity.getTotal())
                .establecimientoList(entity.getEstablecimientoList())
                .build();
    }

    @Override
    public Rubro fromDto(RubroDto dto) {
        if (dto ==null) return null;
        return  Rubro.builder()
                .idRubro(dto.getIdRubro())
                .nombreRubro(dto.getNombreRubro())
                .total(dto.getTotal())
                .establecimientoList(dto.getEstablecimientoList())
                .build();
    }
}
