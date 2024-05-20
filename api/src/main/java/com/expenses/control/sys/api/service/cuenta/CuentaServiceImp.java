package com.expenses.control.sys.api.service.cuenta;

import com.expenses.control.sys.api.dto.CuentaDto;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImp implements ICuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta getCuentaById(long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public Cuenta add(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void delete (Cuenta cuenta) {
        cuentaRepository.delete(cuenta);
    }
    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
}
