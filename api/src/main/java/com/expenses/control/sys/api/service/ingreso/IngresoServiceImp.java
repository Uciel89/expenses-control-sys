package com.expenses.control.sys.api.service.ingreso;

import com.expenses.control.sys.api.exceptions.GeneralServiceException;
import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.entities.Ingreso;
import com.expenses.control.sys.api.model.repository.IngresoRepository;
import com.expenses.control.sys.api.validator.EstablecimientoValidator;
import com.expenses.control.sys.api.validator.IngresoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class IngresoServiceImp implements IIngresoService {
    @Autowired
    IngresoRepository ingresoRepository;
    @Override
    public List<Ingreso> getAllIngresos() {
        try {
            return ingresoRepository.findAll();
        }catch (NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Ingreso getIngresoById(long id) {
        try{
            return ingresoRepository.findById(id)
                    .orElseThrow(()->new NoDataFoundException("No exite un ingreso con el ID: "+id));
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Ingreso create(Ingreso ingreso) {
        try{
            IngresoValidator.validate(ingreso);
            return ingresoRepository.save(ingreso);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(Ingreso ingreso) {
        try{
            Ingreso ingresoDelete = ingresoRepository.findById(ingreso.getIdIngreso())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro"));
            ingresoRepository.delete(ingresoDelete);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Ingreso update(Ingreso ingreso) {
        try{
            IngresoValidator.validate(ingreso);
            Ingreso ingresoUpdate = ingresoRepository.findById(ingreso.getIdIngreso())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro que quiere actualizar"));
            if(ingresoUpdate.getIdIngreso() != ingreso.getIdIngreso())
                throw new ValidateServiceException("Ya existe otro ingreso con ese ID: "+ingreso.getIdIngreso());
            ingresoUpdate.setSaldo(ingreso.getSaldo());
            ingresoUpdate.setCuenta(ingreso.getCuenta());
            return ingresoRepository.save(ingresoUpdate);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
}
