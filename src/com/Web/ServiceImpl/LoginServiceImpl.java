package com.Web.ServiceImpl;

import java.util.List;

import com.Web.ServiceInterfaces.LoginServiceInterface;
import com.Web.dto.LoginDTO;
import com.Web.models.User;
import com.Web.repo.impl.RegistrationRepoImpl;

public class LoginServiceImpl implements LoginServiceInterface {
	
	private RegistrationRepoImpl registrationRepoInterface;
	private User user;

	public LoginServiceImpl() {
		super();
		registrationRepoInterface = new RegistrationRepoImpl();
	}

	@Override
	public void save(LoginDTO logDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LoginDTO logDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginDTO get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(LoginDTO loginDTO) {
		
		user = registrationRepoInterface.getByUserName(loginDTO.getUsername());
		
		if(user != null && user.getPassword().matches(loginDTO.getPassword())) {
			return true;
		}
		
		return false;
	}

}
