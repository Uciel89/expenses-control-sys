package com.expenses.control.sys.api.service.rubro;

import com.expenses.control.sys.api.model.entities.Rubro;
import com.expenses.control.sys.api.model.repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RubroServiceImp implements IRubroService {
    @Autowired
    RubroRepository rubroRepository;
    @Override
    public List<Rubro> getAllRubros() {
        return rubroRepository.findAll();
    }

    @Override
    public Rubro getRubroById(long id) {
        return rubroRepository.findById(id).orElse(null);
    }

    @Override
    public Rubro add(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    public Rubro delete(long id) {
        Rubro rubro = rubroRepository.findById(id).orElse(null);
        if(rubro != null){
            rubroRepository.delete(rubro);
        }
        return rubro;
    }

    @Override
    public Rubro update(Rubro rubro) {
        return rubroRepository.save(rubro);
    }
}
