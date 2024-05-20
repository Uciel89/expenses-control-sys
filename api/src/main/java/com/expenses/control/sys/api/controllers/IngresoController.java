package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.model.entities.Ingreso;
import com.expenses.control.sys.api.service.ingreso.IIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingreso")
public class IngresoController {
    @Autowired
    IIngresoService ingresoService;

    @GetMapping("/todos")
    @ResponseBody
    public List<Ingreso> getAllIngresos(){
        return ingresoService.getAllIngresos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Ingreso getIngresoById (@PathVariable long id){
        return ingresoService.getIngresoById(id);
    }

    @PostMapping("/crear")
    @ResponseBody
    public Ingreso crearIngreso(@RequestBody Ingreso ingreso){
        return ingresoService.add(ingreso);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void borrarIngreso(@PathVariable long id){ingresoService.delete(id);}

    @PutMapping("update")
    @ResponseBody
    public void actualizarIngreso(@RequestBody Ingreso ingreso){ingresoService.update(ingreso);}
}
