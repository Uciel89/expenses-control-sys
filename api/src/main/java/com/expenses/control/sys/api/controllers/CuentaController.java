package com.expenses.control.sys.api.controllers;
import com.expenses.control.sys.api.dto.cuenta.CuentaConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.service.cuenta.ICuentaService;
import com.expenses.control.sys.api.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/v1")
public class CuentaController {
    @Autowired
    private ICuentaService cuentaService;
    @Autowired
    private CuentaConverter converter;
    @GetMapping("/cuentas")
    public ResponseEntity<WrapperResponse<List<CuentaDto>>> getAll(){
        List<Cuenta> cuentaList = cuentaService.getAllCuentas();
        List<CuentaDto> cuentaDtos = converter.fromEntityList(cuentaList);
        return new WrapperResponse<List<CuentaDto>>(true,"Cuentas encontradas con éxito",cuentaDtos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/cuenta/{id}")
    public ResponseEntity<WrapperResponse<CuentaDto>> getById (@PathVariable long id) {
        Cuenta cuenta  = cuentaService.getCuentaById(id);
        CuentaDto cuentaDto = converter.fromEntity(cuenta);
        return new WrapperResponse<CuentaDto>(true,"Cuenta encontrada con éxito",cuentaDto).createResponse(HttpStatus.OK);
    }

    @PostMapping("/cuenta")
    public ResponseEntity<WrapperResponse<CuentaDto>> create(@RequestBody CuentaDto cuentaDto) {
        Cuenta createCuenta = cuentaService.create( converter.fromDto(cuentaDto));
        CuentaDto createDto = converter.fromEntity(createCuenta);
        return new WrapperResponse<CuentaDto>(true,"Cuenta creada con éxito",createDto).createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping("/cuenta/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Cuenta cuentaDelete = cuentaService.getCuentaById(id);
        cuentaService.delete(cuentaDelete);
        return new WrapperResponse<>(true,"Cuenta eliminada con éxito",null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/cuenta")
    public ResponseEntity<WrapperResponse<CuentaDto>> update(@RequestBody CuentaDto cuentaDto) {
        Cuenta updateCuenta = cuentaService.update(converter.fromDto(cuentaDto));
        CuentaDto updateDto = converter.fromEntity(updateCuenta);
        return new WrapperResponse<CuentaDto>(true,"Cuenta actualizada con éxito",updateDto).createResponse(HttpStatus.OK);
    }
}
