package com.Web.ServiceInterfaces;

import java.util.List;
import com.Web.dto.ViewDTO;


public interface ViewServiceInterface {

	void save(ViewDTO user);
	void update(ViewDTO user);
	void delete (int id);
	ViewDTO get(int id);
	ViewDTO getByUserName (String username);
	List<ViewDTO> getAll();
}
