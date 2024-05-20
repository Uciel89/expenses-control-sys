package com.expenses.control.sys.api.service.establecimiento;


import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.repository.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstablecimientoServiceImp implements IEstablecimientoService {
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Establecimiento> getAllEstablecimientos() {
            return establecimientoRepository.findAll();
    }
    @Override
    public Establecimiento getEstablecimientoById(long id) {
            return establecimientoRepository.findById(id).orElse(null);
    }
    @Override
    public Establecimiento add(Establecimiento establecimiento) {
        return establecimientoRepository.save(establecimiento);
    }
    @Override
    public Establecimiento delete(long id) {
        Establecimiento establecimiento = establecimientoRepository.findById(id).orElse(null);
        if(establecimiento != null){
            establecimientoRepository.delete(establecimiento);
        }
        return establecimiento;
    }
    @Override
    public Establecimiento update(Establecimiento establecimiento) {
        return establecimientoRepository.save(establecimiento);
    }
}
