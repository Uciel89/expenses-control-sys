package com.expenses.control.sys.api.controllers;

import com.expenses.control.sys.api.dto.cuenta.CuentaDto;
import com.expenses.control.sys.api.dto.rubro.RubroConverter;
import com.expenses.control.sys.api.dto.rubro.RubroDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.entities.Rubro;
import com.expenses.control.sys.api.service.rubro.IRubroService;
import com.expenses.control.sys.api.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class RubroController {
    @Autowired
    private IRubroService rubroService;
    @Autowired
    private RubroConverter converter;
    @GetMapping("/rubros")
    public ResponseEntity<WrapperResponse<List<RubroDto>>> getAll(){
        List<Rubro> rubroList = rubroService.getAllRubros();
        List<RubroDto> rubroDtos = converter.fromEntityList(rubroList);
        return new WrapperResponse<List<RubroDto>>(true,"Rubros encontrados con éxito",rubroDtos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/rubro/{id}")
    public ResponseEntity<WrapperResponse<RubroDto>> getById (@PathVariable long id) {
        Rubro rubro  = rubroService.getRubroById(id);
        RubroDto rubroDto = converter.fromEntity(rubro);
        return new WrapperResponse<RubroDto>(true,"Rubro encontrado con éxito",rubroDto).createResponse(HttpStatus.OK);
    }

    @PostMapping("/rubro")
    public ResponseEntity<WrapperResponse<RubroDto>> create(@RequestBody RubroDto rubroDto) {
        Rubro createRubro = rubroService.create( converter.fromDto(rubroDto));
        RubroDto createDto = converter.fromEntity(createRubro);
        return new WrapperResponse<RubroDto>(true,"Rubro creado con éxito",createDto).createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping("/rubro/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Rubro rubroDelete = rubroService.getRubroById(id);
        rubroService.delete(rubroDelete);
        return new WrapperResponse<>(true,"Rubro eliminado con éxito",null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/rubro")
    public ResponseEntity<WrapperResponse<RubroDto>> update(@RequestBody RubroDto rubroDto) {
        Rubro updateRubro = rubroService.update(converter.fromDto(rubroDto));
        RubroDto updateDto = converter.fromEntity(updateRubro);
        return new WrapperResponse<RubroDto>(true,"Rubro actualizado con éxito",updateDto).createResponse(HttpStatus.OK);
    }
}
