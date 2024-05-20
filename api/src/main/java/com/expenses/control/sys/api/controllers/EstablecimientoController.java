package com.expenses.control.sys.api.controllers;


import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.service.establecimiento.IEstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/establecimiento")
public class EstablecimientoController {
    @Autowired
    private IEstablecimientoService establecimientoService;
    @PostMapping()
    public ResponseEntity<Establecimiento> createEstablecimiento( @RequestBody Establecimiento establecimiento)  {
        return ResponseEntity.ok(establecimientoService.add(establecimiento));
    }
    @GetMapping()
    public ResponseEntity<List<Establecimiento>> getAllEstablecimientos(){
        return ResponseEntity.ok(establecimientoService.getAllEstablecimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Establecimiento> getEstablecimientosById (@PathVariable long id){
        Establecimiento establecimiento = establecimientoService.getEstablecimientoById(id);
        return ResponseEntity.ok(establecimiento);
    }

    @PutMapping()
    public ResponseEntity<Establecimiento> updateEstablecimiento(@RequestBody Establecimiento establecimiento){
        Establecimiento update = establecimientoService.update(establecimiento);
        if(update == null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstablecimiento(@PathVariable long id) {
        establecimientoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Establecimiento eliminado con exito");
    }
}
