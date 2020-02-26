package com.ibm.training.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.bean.Customer;
import com.ibm.training.bean.Wallet;
import com.ibm.training.dao.JDBCDao1;
import com.ibm.training.dao.JDBCDao2;


@Service
public class WalletService {
	@Autowired
	JDBCDao1 d1;
	@Autowired
	JDBCDao2 d2;
	public int addAccount(Customer a){
		if(!d1.check(a)) {
			d1.addNewAccount(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public int login(Customer a) {
		if(d1.log(a)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getBalance(Customer a){
		return d1.balance(a);
	}
	public int debit(Customer a){
		if(a.getBalance()<=getBalance(a)) {
			d1.withdrawMoney(a);
			d2.debitTransaction(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public int credit(Customer a){
		d1.addMoney(a);
		d2.creditTransaction(a);
		return 1;
	}
	public int checkID(Customer a) {
		if(d1.checkid(a)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public List<Wallet> viewAllTransactions(Customer a) {
		return d2.viewAll(a);
		
	}
	public List<Customer> viewUsers() {
		return d1.viewAll();
		
	}
}
