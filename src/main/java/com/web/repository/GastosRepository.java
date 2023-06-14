package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.entity.EGastos;

public interface GastosRepository extends JpaRepository<EGastos, Long> {

}
