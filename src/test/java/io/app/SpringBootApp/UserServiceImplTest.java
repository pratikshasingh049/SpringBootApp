package io.app.SpringBootApp;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Optional;

import io.app.SpringBootApp.Entity.User;
import io.app.SpringBootApp.Exception.UserNotFoundException;
import io.app.SpringBootApp.Repository.UserRepository;
import io.app.SpringBootApp.Service.UserService;
import io.app.SpringBootApp.Service.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
	@TestConfiguration
	static class UserServiceImplTestConfiguration{
		
		@Bean
		public UserService getService(){
			return new UserServiceImpl();
		}
	}
	
	private List<User> users;
	
	@Before
	public void setup(){
		User user = new User();
		user.setfName("Aditya");
		user.setlName("Singh");
		user.setEmail("adi@gmail.com");
		user.setCity("Mau");
		
		users = Collections.singletonList(user);
		
		Mockito.when(repository.findAll()).thenReturn(users);
	//	Mockito.when(repository.findById(user.getId())).thenReturn(Optional.of(user));
	}
	
	@Autowired
	private UserServiceImpl service;
	
	@MockBean
	private UserRepository repository;

	@Test
	public void testFindAll() {
		List<User> result = service.findAll();
		Assert.assertEquals("Users should match", users, result);
	}

	@Test
	public void testFindOne() {
		
		User result = service.findOne(users.get(0).getID());
		Assert.assertEquals( "employee should match",users.get(0), result);
	}

	@Test(expected = UserNotFoundException.class)
	public void testFindOneNotFound() {
		
		User result = service.findOne("sjdvb");
	}
	
	@Test
	public void testCreate() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

}
