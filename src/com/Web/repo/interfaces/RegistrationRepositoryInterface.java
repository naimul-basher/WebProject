package com.Web.repo.interfaces;

import java.util.List;
import com.Web.models.User;

public interface RegistrationRepositoryInterface {

	void save(User reg);
	void update(User reg);
	void delete (int id);
	User getByUserName (String username);
	List<User> getAll();
}
