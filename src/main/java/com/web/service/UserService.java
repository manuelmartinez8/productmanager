package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.converter.UserConverter;
import org.web.entity.EUser;

import com.web.model.User;

import com.web.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	private UserRepository repository;
	private UserConverter converter= new UserConverter();
	
	@Autowired	
	public void setUserRepository(UserRepository repository) {
		this.repository=repository;
	}
	
	

	@Transactional
	@Override
	public List<User> getAllUser() {
		List<User> lu = new ArrayList<User>();
		
		try {
			lu=this.converter.convertirUser(repository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lu;
	}

	@Override
	public void guardar(EUser e) {
		try {
			repository.save(e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	@Override
	public User buscarPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EUser findPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub

	}

}
