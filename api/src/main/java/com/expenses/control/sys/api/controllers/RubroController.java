package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.model.entities.Rubro;
import com.expenses.control.sys.api.service.rubro.IRubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rubro")
public class RubroController {
    @Autowired
    IRubroService rubroService;

    @GetMapping("/todos")
    @ResponseBody
    public List<Rubro> getAllRubros(){
        return rubroService.getAllRubros();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Rubro getRubroById (@PathVariable long id){
        return rubroService.getRubroById(id);
    }

    @PostMapping("/crear")
    @ResponseBody
    public Rubro crearRubro(@RequestBody Rubro rubro){
        return rubroService.add(rubro);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void borrarRubro(@PathVariable long id){rubroService.delete(id);}

    @PutMapping("update")
    @ResponseBody
    public void actualizarRubro(@RequestBody Rubro rubro){rubroService.update(rubro);}
}
