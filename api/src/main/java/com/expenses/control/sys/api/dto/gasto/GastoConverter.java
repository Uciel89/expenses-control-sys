package com.expenses.control.sys.api.dto.gasto;

import com.expenses.control.sys.api.dto.converter.AbstractConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Gasto;
import org.springframework.stereotype.Component;

@Component
public class GastoConverter extends AbstractConverter<Gasto,GastoDto>{
    @Override
    public GastoDto fromEntity(Gasto entity) {
        if (entity==null) return null;
        return GastoDto.builder()
                .idGasto(entity.getIdGasto())
                .monto(entity.getMonto())
                .fecha(entity.getFecha())
                .establecimiento(entity.getEstablecimiento())
                .cuentaList(entity.getCuentaList())
                .build();
    }

    @Override
    public Gasto fromDto(GastoDto dto) {
        if (dto ==null) return null;
        return  Gasto.builder()
                .idGasto(dto.getIdGasto())
                .monto(dto.getMonto())
                .fecha(dto.getFecha())
                .establecimiento(dto.getEstablecimiento())
                .cuentaList(dto.getCuentaList())
                .build();
    }
}
