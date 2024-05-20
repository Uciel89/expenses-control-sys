package com.expenses.control.sys.api.service.ingreso;

import com.expenses.control.sys.api.model.entities.Ingreso;
import com.expenses.control.sys.api.model.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoServiceImp implements IIngresoService {
    @Autowired
    IngresoRepository ingresoRepository;
    @Override
    public List<Ingreso> getAllIngresos() {
        return ingresoRepository.findAll();
    }

    @Override
    public Ingreso getIngresoById(long id) {
        return ingresoRepository.findById(id).orElse(null);
    }

    @Override
    public Ingreso add(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    @Override
    public Ingreso delete(long id) {
        Ingreso ingreso = ingresoRepository.findById(id).orElse(null);
        if(ingreso != null){
            ingresoRepository.delete(ingreso);
        }
        return ingreso;
    }

    @Override
    public Ingreso update(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }
}
