package com.Web.ServiceInterfaces;

import java.util.List;

import com.Web.dto.RegDTO;

public interface RegServiceInterface {

	boolean save(RegDTO regDTO);
	void update(RegDTO regDTO);
	void delete (int id);
	RegDTO get (int id);
	List<RegDTO> getAll();
}
