package com.ibm.training;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class UserService {
     
    @Autowired
    UserDao dao;
 
    List<User> getUsers(){
        return dao.getUsers();
    }
 
    public User getUserById(int id) {
        return dao.getUserById(id);
    }
    
    public void addUser(int userId, String userName , String userAddress)
    {
    	dao.addUser(userId,userName,userAddress);
    }

	public void deleteUser(int userId) {
		
		dao.deleteUser(userId);
		// TODO Auto-generated method stub
		
	}

	public void updateUser(int userId, User user) {
		
		dao.updateUser(userId,user);
		// TODO Auto-generated method stub
		
	}

//	public void addUser(User user) {
//		dao.addUser(user);
//		
//	}
    
    
}