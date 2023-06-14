package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.entity.EContent;
import org.web.entity.EProduct;

public interface ContenRepository extends JpaRepository<EContent, Long> {

}
