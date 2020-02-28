package com.ibm.training;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
 
@Repository
public class UserDao {
     
    @Autowired
    JdbcTemplate template;
 
    public List<User> getUsers() {
         
        return template.query("select * from userdetails", new UserMapper());
    }
 
    public User getUserById(int id) {
        return template.queryForObject("select * from userdetails where userID = ?",
                new Object[] {id},
                new UserMapper());
    }
     
//    
//    public void addUser(int userId , String userName , String userAddress)
//    {
//    	template.update("insert into userdetails values (?,?,?)",new Object[] {userId,userName , userAddress});
//    }
    public void addUser(User user) {
    	template.update("insert into userdetails values (?,?,?)",new Object[] {user.getUserID(),user.getUserName() , user.getUserAddress()});

		
	}
//    
    public void updateUser(int userId, User user) {
		
		template.update("update userdetails set userName = ? , userAddress = ? where userId = ?" , new Object[] {user.getUserName(), user.getUserAddress(),userId}); 
	}
    
    public void deleteUser(int userId) {
	
		template.update("delete from userdetails where userId = ?",new Object[] {userId});
	}
     
    class UserMapper implements RowMapper<User>{
 
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setUserAddress(rs.getString("userAddress"));
            return user;
        }
         
    }

//	public void addUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}

	

	

	
 
}