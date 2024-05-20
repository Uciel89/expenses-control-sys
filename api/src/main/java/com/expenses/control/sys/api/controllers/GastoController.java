package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.service.gasto.IGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gasto")
public class GastoController {
    @Autowired
    IGastoService gastoService;

    @GetMapping("/todos")
    @ResponseBody
    public List<Gasto> getAllGastos(){
        return gastoService.getAllGastos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Gasto getGastoById (@PathVariable long id){
        return gastoService.getGastoById(id);
    }

    @PostMapping("/crear")
    @ResponseBody
    public Gasto crearGasto(@RequestBody Gasto gasto){
        return gastoService.add(gasto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void borrarGasto(@PathVariable long id){gastoService.delete(id);}

    @PutMapping("update")
    @ResponseBody
    public void actualizarGasto(@RequestBody Gasto gasto){gastoService.update(gasto);}
}
