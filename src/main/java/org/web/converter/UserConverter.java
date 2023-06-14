package org.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.web.entity.EUser;

import com.web.model.User;

@Component
public class UserConverter {

	public List<User> convertirUser(List<EUser> usuarios){
		List<User> modelUser=new ArrayList<>();
		
		for(EUser u: usuarios) {
			modelUser.add(new User(u));
		}
		return modelUser;		
	}
	
}
