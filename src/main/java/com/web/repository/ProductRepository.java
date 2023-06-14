package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.entity.EProduct;

 


public interface ProductRepository extends JpaRepository<EProduct, Long> {

}
