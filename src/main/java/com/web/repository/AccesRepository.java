package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.entity.EAcceso;

public interface AccesRepository extends JpaRepository<EAcceso, Long> {
}
