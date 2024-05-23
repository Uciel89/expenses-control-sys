package com.expenses.control.sys.api.service.rubro;

import com.expenses.control.sys.api.exceptions.GeneralServiceException;
import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.model.entities.Rubro;
import com.expenses.control.sys.api.model.repository.RubroRepository;
import com.expenses.control.sys.api.validator.RubroValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Slf4j
@Service
public class RubroServiceImp implements IRubroService {
    @Autowired
    RubroRepository rubroRepository;
    @Override
    public List<Rubro> getAllRubros() {
        try {
            return rubroRepository.findAll();
        }catch (NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Rubro getRubroById(long id) {
        try{
            return rubroRepository.findById(id)
                    .orElseThrow(()->new NoDataFoundException("No exite un rubro con el ID: "+id));
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Rubro create(Rubro rubro) {
        try{
            RubroValidator.validate(rubro);
            if(rubroRepository.findByNombreRubro(rubro.getNombreRubro())!=null)
                throw new ValidateServiceException("Ya existe un Rubro registrado con ese nombre "+rubro.getNombreRubro());
            return rubroRepository.save(rubro);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(Rubro rubro) {
        try{
            Rubro rubroDelete = rubroRepository.findById(rubro.getIdRubro())
                    .orElseThrow(()->new NoDataFoundException("No existe el registro"));
            rubroRepository.delete(rubroDelete);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }

    @Override
    public Rubro update(Rubro rubro) {
        try{
            RubroValidator.validate(rubro);
            Rubro rubroUpdate = rubroRepository.findById(rubro.getIdRubro())
                    .orElseThrow(()->new NoDataFoundException("No existe el rubro que quiere actualizar"));
            Rubro rubroU = rubroRepository.findByNombreRubro(rubro.getNombreRubro());
            if(rubroU.getIdRubro() != rubro.getIdRubro())
                throw new ValidateServiceException("Ya existe otro rubro con el nombre: "+rubro.getNombreRubro());
            rubroUpdate.setNombreRubro(rubro.getNombreRubro());
            rubroU.setTotal(rubro.getTotal());
            return rubroRepository.save(rubroUpdate);
        }catch (ValidateServiceException | NoDataFoundException e){
            log.info(e.getMessage(),e);
            throw e;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServiceException(e.getMessage(),e);
        }
    }
}
