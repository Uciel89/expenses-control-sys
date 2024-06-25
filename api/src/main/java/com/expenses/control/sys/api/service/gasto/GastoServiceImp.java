package com.expenses.control.sys.api.service.gasto;

import com.expenses.control.sys.api.exceptions.GeneralServiceException;
import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.entities.Gasto;
import com.expenses.control.sys.api.model.repository.GastoRepository;
import com.expenses.control.sys.api.validator.EstablecimientoValidator;
import com.expenses.control.sys.api.validator.GastoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class GastoServiceImp implements IGastoService{
    @Autowired
    GastoRepository gastoRepository;

    @Override
    public List<Gasto> getAllGastos() {
        try {
            return gastoRepository.findAll();
        }catch (NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Gasto getGastoById(long id) {
        try{
            return gastoRepository.findById(id)
                    .orElseThrow(()->new NoDataFoundException("No exite el gasto: "+id));
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Gasto create(Gasto gasto) {
        try{
            GastoValidator.validate(gasto);
            return gastoRepository.save(gasto);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(Gasto gasto) {
        try{
            Gasto gastoDelete = gastoRepository.findById(gasto.getIdGasto())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro"));
            gastoRepository.delete(gastoDelete);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Gasto update(Gasto gasto) {
        try{
            GastoValidator.validate(gasto);
            Gasto gastoUpdate = gastoRepository.findById(gasto.getIdGasto())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro que quiere actualizar"));
            if(gastoUpdate.getIdGasto() != gasto.getIdGasto())
                throw new ValidateServiceException("Ya existe otro con ese ID: "+gasto.getIdGasto());
            gastoUpdate.setMonto(gasto.getMonto());
            gastoUpdate.setEstablecimiento(gasto.getEstablecimiento());
            return gastoRepository.save(gastoUpdate);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
}
