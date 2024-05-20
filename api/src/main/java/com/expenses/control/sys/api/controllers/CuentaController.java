package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.dto.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.service.cuenta.ICuentaService;
import org.apache.coyote.Response;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/cuentas")
public class CuentaController {
    @Autowired
    private ICuentaService cuentaService;

    @GetMapping()
    public ResponseEntity<List<Cuenta>> getAll(){
        List<Cuenta> cuentaList = cuentaService.getAllCuentas();
        if(cuentaList.isEmpty())return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(cuentaService.getAllCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getById (@PathVariable long id) {
        Cuenta cuenta  = cuentaService.getCuentaById(id);
        if(cuenta == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(cuenta);
    }

    @PostMapping()
    public ResponseEntity<Cuenta> create(@RequestBody Cuenta cuenta) {
        Cuenta createCuenta = cuentaService.update(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try{
            Cuenta cuentaDelete = cuentaService.getCuentaById(id);
            cuentaService.delete(cuentaDelete);
            return new ResponseEntity<>(cuentaDelete,HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exDt.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<Cuenta> updateCuenta(@RequestBody Cuenta cuenta) {
        Cuenta updateCuenta = cuentaService.update(cuenta);
        if (updateCuenta == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updateCuenta);
    }
}
