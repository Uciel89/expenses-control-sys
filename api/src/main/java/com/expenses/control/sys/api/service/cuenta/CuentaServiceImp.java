package com.expenses.control.sys.api.service.cuenta;

import com.expenses.control.sys.api.exceptions.GeneralServiceException;
import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Cuenta;
import com.expenses.control.sys.api.model.repository.CuentaRepository;
import com.expenses.control.sys.api.validator.CuentaValidator;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CuentaServiceImp implements ICuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getAllCuentas() {
        try{
            return cuentaRepository.findAll();
        }catch (NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Cuenta getCuentaById(long id) {
        try{
            return cuentaRepository.findById(id).
                    orElseThrow(()->new NoDataFoundException("No existe la cuenta con el ID: "+id));
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Cuenta create(Cuenta cuenta) {
        try{
            CuentaValidator.validate(cuenta);
            if(cuentaRepository.findByNombre(cuenta.getNombre())!=null)
                throw new ValidateServiceException("Ya existe una cuenta con el nombre: "+cuenta.getNombre());
            return cuentaRepository.save(cuenta);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void delete (Cuenta cuenta) {
        try{
            Cuenta cuentaDelete = cuentaRepository.findById(cuenta.getIdCuenta())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro"));
            cuentaRepository.delete(cuentaDelete);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
    @Override
    public Cuenta update(Cuenta cuenta) {
        try{
            CuentaValidator.validate(cuenta);
            Cuenta cuentaUpdate = cuentaRepository.findById(cuenta.getIdCuenta())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro que quiere actualizar"));
            Cuenta cuentaU = cuentaRepository.findByNombre(cuenta.getNombre());
            if(cuentaU != null && cuentaU.getIdCuenta()!= cuenta.getIdCuenta())
                throw new ValidateServiceException("Ya existe otra cuenta con el nombre: "+cuenta.getNombre());
            cuentaUpdate.setSaldo(cuenta.getSaldo());
            cuentaUpdate.setNombre(cuenta.getNombre());
            cuentaRepository.save(cuentaUpdate);
            return cuentaUpdate;
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }

    }
}
