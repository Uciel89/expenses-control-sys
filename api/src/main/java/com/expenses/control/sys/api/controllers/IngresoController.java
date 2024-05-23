package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.dto.ingreso.IngresoConverter;
import com.expenses.control.sys.api.dto.ingreso.IngresoDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Ingreso;
import com.expenses.control.sys.api.service.ingreso.IIngresoService;
import com.expenses.control.sys.api.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class IngresoController {
    @Autowired
    private IIngresoService ingresoService;
    @Autowired
    private IngresoConverter converter;
    @GetMapping("/ingresos")
    public ResponseEntity<WrapperResponse<List<IngresoDto>>> getAll(){
        List<Ingreso> ingresoList = ingresoService.getAllIngresos();
        List<IngresoDto> ingresoDtos = converter.fromEntityList(ingresoList);
        return new WrapperResponse<List<IngresoDto>>(true,"Ingresos encontrados con éxito",ingresoDtos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/ingreso/{id}")
    public ResponseEntity<WrapperResponse<IngresoDto>> getById (@PathVariable long id) {
        Ingreso ingreso  = ingresoService.getIngresoById(id);
        IngresoDto ingresoDto = converter.fromEntity(ingreso);
        return new WrapperResponse<IngresoDto>(true,"Ingreso encontrado con éxito",ingresoDto).createResponse(HttpStatus.OK);
    }

    @PostMapping("/ingreso")
    public ResponseEntity<WrapperResponse<IngresoDto>> create(@RequestBody IngresoDto ingresoDto) {
        Ingreso createIngreso = ingresoService.create( converter.fromDto(ingresoDto));
        IngresoDto createDto = converter.fromEntity(createIngreso);
        return new WrapperResponse<IngresoDto>(true,"Ingreso creado con éxito",createDto).createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping("/ingreso/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Ingreso ingresoDelete = ingresoService.getIngresoById(id);
        ingresoService.delete(ingresoDelete);
        return new WrapperResponse<>(true,"Ingreso eliminado con éxito",null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/ingreso")
    public ResponseEntity<WrapperResponse<IngresoDto>> update(@RequestBody IngresoDto ingresoDto) {
        Ingreso updateIngreso = ingresoService.update(converter.fromDto(ingresoDto));
        IngresoDto updateDto = converter.fromEntity(updateIngreso);
        return new WrapperResponse<IngresoDto>(true,"Ingreso actualizado con éxito",updateDto).createResponse(HttpStatus.OK);
    }
}
