package com.web.service;

import java.util.List;

 
import org.web.entity.EUser;

 
import com.web.model.User;

public interface IUserService {
	
	List<User> getAllUser();
	public void guardar(EUser e);
	public   User buscarPorID(Long id);
	public   EUser findPorID(Long id);
	public void Eliminar(Long id);


}
