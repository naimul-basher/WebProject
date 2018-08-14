package com.Web.ServiceInterfaces;

import java.util.List;

import com.Web.dto.LoginDTO;

public interface LoginServiceInterface {

	void save(LoginDTO logDTO);
	void update(LoginDTO logDTO);
	void delete (int id);
	LoginDTO get (int id);
	List<LoginDTO> getAll();
	boolean verify(LoginDTO loginDTO);
}
