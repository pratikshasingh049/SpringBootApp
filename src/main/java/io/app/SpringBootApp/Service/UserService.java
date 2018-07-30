package io.app.SpringBootApp.Service;

import java.util.List;
import java.util.Optional;

import io.app.SpringBootApp.Entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String id);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);

}
