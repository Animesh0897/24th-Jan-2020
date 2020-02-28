package com.ibm.training;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.ibm.training;
 
@RestController
public class UserController {
     
    @Autowired
    UserService service;
 
    @RequestMapping("/users")
    List<User> getUsers(){
        return service.getUsers();
    }
     
    @RequestMapping("/users/{id}")
    User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    
  //Add a new User
  	@RequestMapping("/users/{userId}/{userName}/{userAddress}")
   
    void addUser(@PathVariable int userId, @PathVariable String userName, @PathVariable String userAddress) {
  		
  		service.addUser(userId,userName,userAddress);
    }
//  	void addUser(@RequestBody User user , value = "users/") {
//  		
//  		service.addUser(user);
//    }
  	
  	@RequestMapping(method = RequestMethod.PUT, value = "users/{userId}")
  	void updateUser(@PathVariable int userId, @RequestBody User user)
  	{
  		service.updateUser(userId ,user);
  	}
  	
  	 @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
  	void deleteUser(@PathVariable int userId)
  	{
  		service.deleteUser(userId);
  	}
  	
}