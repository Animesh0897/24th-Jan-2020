package com.ibm.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ibm.training.bean.Customer;
import com.ibm.training.bean.Wallet;

@Repository
public class JDBCDao1 {
	
	DataSource dataSource;
	JdbcTemplate temp;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		temp = new JdbcTemplate(dataSource);
	}

	public boolean check(Customer a) {
		int c = temp.queryForObject("select count(*) from wallet_database where id=?",new Object[] {a.getId()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void addNewAccount(Customer a) {
		// TODO Auto-generated method stub
		temp.update("insert into wallet_database values(?,?,?,?,?)",new Object[] {a.getId(),a.getName(),a.getBalance(),a.getPassword(),a.getDate_created()});
	}

	public boolean log(Customer a) {
		int c = temp.queryForObject("select count(*) from wallet_database where id=? and password=?",new Object[] {a.getId(),a.getPassword()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public int balance(Customer a) {
		return temp.queryForObject("select balance from wallet_database where id=?",new Object[] {a.getId()},Integer.class);
	}

	public void withdrawMoney(Customer a) {
		int m = balance(a) - a.getBalance();
		temp.update("update wallet_database set balance=? where id=?",new Object[] {m,a.getId()});
	}

	public void addMoney(Customer a) {
		int m = balance(a) + a.getBalance();
		temp.update("update wallet_database set balance=? where id=?",new Object[] {m,a.getId()});
	}

	public boolean checkid(Customer a) {
		int c = temp.queryForObject("select count(*) from wallet_database where id=?",new Object[] {a.getId()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public List<Customer> viewAll() {
			List<Customer> al =  temp.query("select * from wallet_database",new UserMapper());
			return al;
	}
	class UserMapper implements RowMapper<Customer>{
		public Customer mapRow(ResultSet rs,int rowNum)throws SQLException{
			Customer user = new Customer();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setBalance(rs.getInt("balance"));
			user.setPassword(rs.getString("password"));
			user.setDate_created(rs.getString("date_created"));
			
			
			return user;
		}
	}

}
