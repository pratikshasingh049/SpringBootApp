package io.app.SpringBootApp.UserController;
//handle all endpoints related to user
//what are the endpoints, what requests are required
//what are the urls

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.app.SpringBootApp.Entity.User;
import io.app.SpringBootApp.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*@Component
@ResponseBody  ---Combining both with RestController*/
@RestController
@Api(tags = "users")
//instead of writing before every function 	
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
//	@RequestMapping(method=RequestMethod.GET, value="/user")
	@RequestMapping(method=RequestMethod.GET)
//	@ResponseBody
	@ApiOperation(value = "Find All Users", notes = "Returns a list of users in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	
	public List<User> findAll(){
				return service.findAll();
	}
	
//	@RequestMapping(method=RequestMethod.GET, value="/user/{id}")
	@RequestMapping(method=RequestMethod.GET, value="{id}")
//	@ResponseBody
	@ApiOperation(value = "Find User by Id", notes = "Returns a user by id if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	
	public User findOne(@PathVariable("id") String userid){
		return service.findOne(userid);
	}
	
	@RequestMapping(method=RequestMethod.POST)
//	@ResponseBody
	@ApiOperation(value = "Create User", notes = "Creates a user in the app with unique email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	
	public User create(@RequestBody User user){
		return service.create(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	//@ResponseBody
	@ApiOperation(value = "Update User", notes = "Updates an existing user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	
	public User update(@PathVariable("id") String userid, @RequestBody User user){
		return service.update(userid, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	//@ResponseBody
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@ApiOperation(value = "Delete User", notes = "Deletes an existing user")
	
	public void delete(@PathVariable("id")String userid){
		service.delete(userid);
	}
}
