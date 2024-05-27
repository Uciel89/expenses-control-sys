package com.expenses.control.sys.api.service.establecimiento;


import com.expenses.control.sys.api.exceptions.GeneralServiceException;
import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Establecimiento;
import com.expenses.control.sys.api.model.repository.EstablecimientoRepository;
import com.expenses.control.sys.api.validator.EstablecimientoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EstablecimientoServiceImp implements IEstablecimientoService {
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Override
    public List<Establecimiento> getAllEstablecimientos() {
        try {
            return establecimientoRepository.findAll();
        }catch (NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
    @Override
    public Establecimiento getEstablecimientoById(long id) {
        try{
            return establecimientoRepository.findById(id)
                    .orElseThrow(()->new NoDataFoundException("No exite un establecimiento con el ID: "+id));
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
    @Override
    public Establecimiento create(Establecimiento establecimiento) {
        try{
            EstablecimientoValidator.validate(establecimiento);
            if(establecimientoRepository.findByNombreEstablecimiento(establecimiento.getNombreEstablecimiento())!=null)
                throw new ValidateServiceException("Ya existe un Establecimiento registrado con el nombre "+establecimiento.getNombreEstablecimiento());
            return establecimientoRepository.save(establecimiento);
            }catch (ValidateServiceException | NoDataFoundException e){
                log.info(e.getMessage(),e);
                throw e;
            }catch (Exception e){
                log.error(e.getMessage(),e);
                throw new GeneralServiceException(e.getMessage(),e);
        }
    }
    @Override
    public void delete(Establecimiento establecimiento) {
        try{
            Establecimiento establecimientoDelete = establecimientoRepository.findById(establecimiento.getIdEstablecimiento())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro"));
            establecimientoRepository.delete(establecimientoDelete);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
    @Override
    public Establecimiento update(Establecimiento establecimiento) {
        try{
            EstablecimientoValidator.validate(establecimiento);
            Establecimiento establecimientoUpdate = establecimientoRepository.findById(establecimiento.getIdEstablecimiento())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro que quiere actualizar"));
            Establecimiento establecimientoU = establecimientoRepository.findByNombreEstablecimiento(establecimiento.getNombreEstablecimiento());
            if(establecimientoU != null && establecimientoU.getIdEstablecimiento() != establecimiento.getIdEstablecimiento())
                throw new ValidateServiceException("Ya existe otro establecimiento con el nombre: "+establecimiento.getNombreEstablecimiento());
            establecimientoUpdate.setNombreEstablecimiento(establecimiento.getNombreEstablecimiento());
            establecimientoUpdate.setRubro(establecimiento.getRubro());
            return establecimientoRepository.save(establecimientoUpdate);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
}
