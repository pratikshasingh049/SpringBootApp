package io.app.SpringBootApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.app.SpringBootApp.Entity.User;
import io.app.SpringBootApp.Exception.BadRequestException;
import io.app.SpringBootApp.Exception.UserNotFoundException;
import io.app.SpringBootApp.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(String ID) {

		return repository.findOne(ID).orElseThrow(() -> new UserNotFoundException("Employee with id="+ID+" Not Found"));
		
		/*if(user == null){
			throw new UserNotFoundException("Employee with id="+ID+" Not Found");
		}
		else{
			return user;
		}*/
	}

	@Override
	@Transactional
	public User create(User user) {
		Optional<User> mayExists = repository.findByEmail(user.getEmail());
		if (mayExists.isPresent()) {
			throw new BadRequestException("User with email " + user.getEmail() + " already exists");
		}
		return repository.save(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		repository.findOne(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
		return repository.save(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
		repository.delete(existing);
	}

}
