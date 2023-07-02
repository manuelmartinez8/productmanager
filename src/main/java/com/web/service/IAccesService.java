package com.web.service;

import com.web.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.web.entity.EAcceso;


import java.util.List;

public interface IAccesService {

    List<EAcceso> getAllAcces();
    public void guardar(EAcceso e);
    public   EAcceso buscarPorID(Long id);
    public void Eliminar(Long id);
    public Page<EAcceso> findAll(Pageable pageable);

}
