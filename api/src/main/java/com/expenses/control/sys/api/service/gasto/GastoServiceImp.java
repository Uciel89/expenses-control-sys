package com.expenses.control.sys.api.service.gasto;

import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.model.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImp implements IGastoService{
    @Autowired
    GastoRepository gastoRepository;

    @Override
    public List<Gasto> getAllGastos() {
        return gastoRepository.findAll();
    }

    @Override
    public Gasto getGastoById(long id) {
        return gastoRepository.findById(id).orElse(null);
    }

    @Override
    public Gasto add(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public Gasto delete(long id) {
        Gasto gasto = gastoRepository.findById(id).orElse(null);
        if(gasto != null){
            gastoRepository.delete(gasto);
        }
        return gasto;
    }

    @Override
    public Gasto update(Gasto gasto) {
        return gastoRepository.save(gasto);
    }
}
