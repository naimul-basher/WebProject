package com.Web.ServiceImpl;

import java.util.List;

import com.Web.ServiceInterfaces.RegServiceInterface;
import com.Web.dto.RegDTO;
import com.Web.models.User;
import com.Web.repo.impl.RegistrationRepoImpl;

public class RegServiceImpl implements RegServiceInterface{

	private RegistrationRepoImpl registrationRepoInterface;
	private User user;
	
	public RegServiceImpl() {
		super();
		registrationRepoInterface = new RegistrationRepoImpl();
		user = null;
	}
	
	@Override
	public boolean save(RegDTO regDTO) {
		
		//	check whether user already exists
		user = registrationRepoInterface.getByUserName(regDTO.getUsername());
		if (user != null )
			return false;
		
		//	create a data model
		user = new User(regDTO.getFirstName(), regDTO.getLastName(), regDTO.getUsername(), 
				regDTO.getAddress(), regDTO.getEmail(), regDTO.getPhone(), regDTO.getPassword());

		//	invoke SAVE method from Repository/DAO class
		registrationRepoInterface.save(user);
		return true;
		
	}

	@Override
	public void update(RegDTO regDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegDTO get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
