package com.ibm.ParallelProject.service;

import com.ibm.ParallelProject.bean.Customer;
import com.ibm.ParallelProject.doa.Doa1;
import com.ibm.ParallelProject.doa.Doa2;

public class WalletService implements WalletServiceImpl{
	Customer c = new Customer();
	Doa1 d1 = new Doa1();
	Doa2 d2 = new Doa2();
	int v = 0;
	public void deposit(int id,int m,String d) {
		d1.addMoney(id,m);
		d2.creditTransaction(id,m,d);
	}
	public void withdraw(int id,int m,String d) {
		d1.withdrawMoney(id,m);
	}
	public int balanceCheck(int id) {
		return d1.balance(id);
	}
	public void allTransactions(int id) {
			d2.transactions(id);
	}
	public void createAccount(Customer c) {
		d1.createAcc(c);
		v++;
	}
	public void fundTransfer(int id,int m,int idp,String d) {
		if(checkID(idp)) {	
			d1.transfer(id,m,idp);
			d1.withdrawMoney(id,m);
			d2.debitTransaction(id,m,d);
			d2.creditTransaction(idp, m, d);
		}
		else {
			System.out.println("ID is not present in the database");
		}
	}
	public void allUsers() {
		d1.showAll();
	}
	public boolean login(int id,String p) {
		return d1.log(id,p);
	}
	public boolean checkID(int id) {
		return d1.checkid(id);
	}
	public void close() {
		d1.closeDB();
	}
}