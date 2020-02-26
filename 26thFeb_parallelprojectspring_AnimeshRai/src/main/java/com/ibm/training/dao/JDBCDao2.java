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
public class JDBCDao2 {
	DataSource dataSource;
	JdbcTemplate temp;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		temp = new JdbcTemplate(dataSource);
	}
	public void debitTransaction(Customer a) {
		int m = (-1)*a.getBalance();
		temp.update("insert into transaction_database values(?,?,?)",new Object[] {a.getDate_created(),a.getId(),m});
	}
	public void creditTransaction(Customer a) {
		int m = a.getBalance();
		temp.update("insert into transaction_database values(?,?,?)",new Object[] {a.getDate_created(),a.getId(),m});
		
	}
	public List<Wallet> viewAll(Customer a) {
		List<Wallet> al =  temp.query("select * from transaction_database where id=?",new Object[] {a.getId()},new UserMapper());
		return al;
	}
	class UserMapper implements RowMapper<Wallet>{
		public Wallet mapRow(ResultSet rs,int rowNum)throws SQLException{
			Wallet user = new Wallet();
			user.setDate_transaction(rs.getString("date_transaction"));
			user.setId(rs.getInt("id"));
			
			user.setChanged(rs.getInt("changed"));
			return user;
		}
	}
}
