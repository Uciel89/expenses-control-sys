package com.expenses.control.sys.api.controllers;


import com.expenses.control.sys.api.dto.cuenta.CuentaConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.dto.establecimiento.EstablecimientoConverter;
import com.expenses.control.sys.api.dto.establecimiento.EstablecimientoDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.service.establecimiento.IEstablecimientoService;
import com.expenses.control.sys.api.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EstablecimientoController {
    @Autowired
    private IEstablecimientoService establecimientoService;
    @Autowired
    private EstablecimientoConverter converter;
    @GetMapping("/establecimientos")
    public ResponseEntity<WrapperResponse<List<EstablecimientoDto>>> getAll(){
        List<Establecimiento> establecimientoList = establecimientoService.getAllEstablecimientos();
        List<EstablecimientoDto> establecimientoDtos = converter.fromEntityList(establecimientoList);
        return new WrapperResponse<List<EstablecimientoDto>>(true,"Establecimientos encontrados con éxito",establecimientoDtos).createResponse(HttpStatus.OK);
    }
    @GetMapping("/establecimiento/{id}")
    public ResponseEntity<WrapperResponse<EstablecimientoDto>> getById (@PathVariable long id) {
        Establecimiento establecimiento  = establecimientoService.getEstablecimientoById(id);
        EstablecimientoDto establecimientoDto = converter.fromEntity(establecimiento);
        return new WrapperResponse<EstablecimientoDto>(true,"Establecimiento encontrado con éxito",establecimientoDto).createResponse(HttpStatus.OK);
    }
    @PostMapping("/establecimiento")
    public ResponseEntity<WrapperResponse<EstablecimientoDto>> create(@RequestBody EstablecimientoDto establecimientoDto) {
        Establecimiento createEstablecimiento = establecimientoService.create(converter.fromDto(establecimientoDto));
        EstablecimientoDto createDto = converter.fromEntity(createEstablecimiento);
        return new WrapperResponse<EstablecimientoDto>(true,"Establecimiento creado con éxito",createDto).createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping("/establecimiento/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Establecimiento establecimientoDelete = establecimientoService.getEstablecimientoById(id);
        establecimientoService.delete(establecimientoDelete);
        return new WrapperResponse<>(true,"Establecimiento eliminado con éxito",null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/establecimiento")
    public ResponseEntity<WrapperResponse<EstablecimientoDto>> update(@RequestBody EstablecimientoDto establecimientoDto) {
        Establecimiento updateEstablecimiento = establecimientoService.update(converter.fromDto(establecimientoDto));
        EstablecimientoDto updateDto = converter.fromEntity(updateEstablecimiento);
        return new WrapperResponse<EstablecimientoDto>(true,"Establecimiento actualizado con éxito",updateDto).createResponse(HttpStatus.OK);
    }
}
