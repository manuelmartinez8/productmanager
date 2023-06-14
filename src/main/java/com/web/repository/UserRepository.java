package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import org.web.entity.EUser;

public interface UserRepository extends JpaRepository<EUser, Long>{

}
