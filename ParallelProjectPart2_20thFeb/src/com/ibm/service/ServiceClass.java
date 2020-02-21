package com.ibm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.bean.Customer;
import com.ibm.dao.Doa1;
import com.ibm.dao.Doa2;

public class ServiceClass {

	// Data2 d2 = new Data2();

	public int login(Customer a) throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		if (d1.log(a)) {
			return 1;
		} else {
			return 0;
		}
	}

	
	public boolean checkID(Customer a) throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		return d1.check(a);
	}
	
	
	public int addAccount(Customer a) throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		if (!d1.check(a)) {
			d1.CreateAccount(a);
			return 1;
		} else {
			return 0;
		}
	}

	public int balanceCheck(Customer a) throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		return d1.balance(a);
	}

	public int deposit(Customer a) throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		Doa2 d2 = new Doa2();
		d1.addMoney(a);
		d2.creditTransaction(a);
		return 1;
	}

	public int withdraw(Customer a) throws SQLException, ClassNotFoundException {
		if (a.getBalance() < balanceCheck(a)) {
			Doa1 d1 = new Doa1();
			Doa2 d2 = new Doa2();
			d1.withdrawMoney(a);
			d2.debitTransaction(a);
			return 1;
		} else {
			return 0;
		}
	}

	

	public ArrayList<String> allUsers() throws SQLException, ClassNotFoundException {
		Doa1 d1 = new Doa1();
		return d1.showAll();
	}

	public ArrayList<String> allTransactions(Customer a) throws SQLException, ClassNotFoundException {
		Doa2 d2 = new Doa2();
		return d2.transactions(a);
	}
}
