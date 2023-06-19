package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.entity.EGastos;
@Repository
public interface GastosRepository extends JpaRepository<EGastos, Long> {

}
