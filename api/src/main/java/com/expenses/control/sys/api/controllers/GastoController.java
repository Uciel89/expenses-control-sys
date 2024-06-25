package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.dto.gasto.GastoConverter;
import com.expenses.control.sys.api.dto.gasto.GastoDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.service.gasto.IGastoService;
import com.expenses.control.sys.api.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GastoController {
    @Autowired
    private IGastoService gastoService;
    @Autowired
    private GastoConverter converter;
    @GetMapping("/gastos")
    public ResponseEntity<WrapperResponse<List<GastoDto>>> getAll(){
        List<Gasto> gastoList = gastoService.getAllGastos();
        List<GastoDto> gastoDtos = converter.fromEntityList(gastoList);
        return new WrapperResponse<List<GastoDto>>(true,"Gastos encontrados con éxito",gastoDtos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/gasto/{id}")
    public ResponseEntity<WrapperResponse<GastoDto>> getById (@PathVariable long id) {
        Gasto gasto  = gastoService.getGastoById(id);
        GastoDto gastoDto = converter.fromEntity(gasto);
        return new WrapperResponse<GastoDto>(true,"Gasto encontrado con éxito",gastoDto).createResponse(HttpStatus.OK);
    }
    @PostMapping("/gasto")
    public ResponseEntity<WrapperResponse<GastoDto>> create(@RequestBody GastoDto gastoDto) {
        Gasto createGasto = gastoService.create( converter.fromDto(gastoDto));
        GastoDto createDto = converter.fromEntity(createGasto);
        return new WrapperResponse<GastoDto>(true,"Gasto creado con éxito",createDto).createResponse(HttpStatus.CREATED);
    }
    @DeleteMapping("/gasto/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Gasto gastoDelete = gastoService.getGastoById(id);
        gastoService.delete(gastoDelete);
        return new WrapperResponse<>(true,"Gasto eliminado con éxito",null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/gasto")
    public ResponseEntity<WrapperResponse<GastoDto>> update(@RequestBody GastoDto gastoDto) {
        Gasto updateGasto = gastoService.update(converter.fromDto(gastoDto));
        GastoDto updateDto = converter.fromEntity(updateGasto);
        return new WrapperResponse<GastoDto>(true,"Gasto actualizado con éxito",updateDto).createResponse(HttpStatus.OK);
    }
}
