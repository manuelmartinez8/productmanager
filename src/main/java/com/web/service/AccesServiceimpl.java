package com.web.service;

import com.web.exception.ResourceNotFoundException;
import com.web.repository.AccesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.entity.EAcceso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccesServiceimpl implements  IAccesService
{
    @Autowired
    private AccesRepository repository;

    private static final Logger log = LoggerFactory.getLogger(AccesServiceimpl.class);


    @Override
    public List<EAcceso> getAllAcces() {
        List<EAcceso> la = new ArrayList<>();
        try {
            la = repository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return la;
    }

    @Override
    public void guardar(EAcceso e) {
    try {
        if(Objects.nonNull(e)){
            repository.save(e);
            log.info("PROCESO DE GUARDADO DEL NUEVO ACCESO TERMINO CON EXITO");
        }
    }catch (Exception exception){
        exception.printStackTrace();
        log.error(exception.getMessage(), "PROCESO DE GUARDADO DEL NUEVO ACCESO NO TERMINO CON EXITO");
    }
    }

    @Override
    public EAcceso buscarPorID(Long id) {
            if(id!=null){
               return  repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Datos nos encontrados","id: " + id));
            }
        return null;
    }

    @Override
    public void Eliminar(Long id) {
        try{
            if(id!=null){
                EAcceso a = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Datos nos encontrados","id: " + id));
                repository.deleteById(a.getId());
                log.info("DATOS ELIMINADOS DEL SISTEMA");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage(), "PROCESO DE BORRADO   NO TERMINO CON EXITO");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EAcceso> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
