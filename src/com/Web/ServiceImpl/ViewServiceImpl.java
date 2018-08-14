package com.Web.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.Web.ServiceInterfaces.ViewServiceInterface;
import com.Web.dto.ViewDTO;
import com.Web.models.User;
import com.Web.repo.impl.RegistrationRepoImpl;

public class ViewServiceImpl implements ViewServiceInterface {
	
	private RegistrationRepoImpl registrationRepoInterface;
	private List<User> list;
	private List<ViewDTO> viewList;
		
	public ViewServiceImpl() {
		super();
		registrationRepoInterface = new RegistrationRepoImpl();
		list = new ArrayList<User>();
		viewList = new ArrayList<ViewDTO>();
	}

	@Override
	public void save(ViewDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ViewDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ViewDTO getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewDTO> getAll() {
		
		list = registrationRepoInterface.getAll();
		viewList.clear();
		
		for(User user:list)
			viewList.add(new ViewDTO(user.getFirstName(), user.getLastName(), user.getUsername(), 
					user.getAddress(), user.getEmail(), user.getPhone(), user.getPassword() ) );
	
		return viewList;
	}

	@Override
	public ViewDTO get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
