package com.expenses.control.sys.api.controllers;
import com.expenses.control.sys.api.dto.cuenta.CuentaConverter;
import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.service.cuenta.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class CuentaController {
    @Autowired
    private ICuentaService cuentaService;
    @Autowired
    private CuentaConverter converter;
    @GetMapping("/cuentas")
    public ResponseEntity<List<CuentaDto>> getAll(){
        List<Cuenta> cuentaList = cuentaService.getAllCuentas();
        if(cuentaList.isEmpty())return ResponseEntity.noContent().build();
        List<CuentaDto> cuentaDtos = converter.fromEntityList(cuentaList);
        return ResponseEntity.ok(cuentaDtos);
    }

    @GetMapping("/cuenta/{id}")
    public ResponseEntity<CuentaDto> getById (@PathVariable long id) {
        Cuenta cuenta  = cuentaService.getCuentaById(id);
        if(cuenta == null) return ResponseEntity.notFound().build();
        CuentaDto cuentaDto = converter.fromEntity(cuenta);
        return ResponseEntity.ok(cuentaDto);
    }

    @PostMapping("/cuenta")
    public ResponseEntity<CuentaDto> create(@RequestBody CuentaDto cuentaDto) {
        Cuenta createCuenta = cuentaService.update(converter.fromDto(cuentaDto));
        CuentaDto createDto = converter.fromEntity(createCuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDto);
    }

    @DeleteMapping("/cuenta/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try{
            Cuenta cuentaDelete = cuentaService.getCuentaById(id);
            cuentaService.delete(cuentaDelete);
            return new ResponseEntity<>(cuentaDelete,HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exDt.getMessage());
        }
    }

    @PutMapping("/cuenta")
    public ResponseEntity<CuentaDto> updateCuenta(@RequestBody CuentaDto cuentaDto) {
        Cuenta updateCuenta = cuentaService.update(converter.fromDto(cuentaDto));
        if (updateCuenta == null) return ResponseEntity.notFound().build();
        CuentaDto updateDto = converter.fromEntity(updateCuenta);
        return ResponseEntity.ok(updateDto);
    }
}
