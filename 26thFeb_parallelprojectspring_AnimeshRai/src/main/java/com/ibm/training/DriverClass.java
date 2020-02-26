package com.ibm.training;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.ibm.training.bean.Customer;
import com.ibm.training.bean.Wallet;
import com.ibm.training.service.WalletService;

@Component("Driver")
public class DriverClass {
	@Autowired
	 Customer a;
	@Autowired
	 WalletService ms;
	int loginID,fundID;
	Scanner n = new Scanner(System.in);
	Date d = new Date();
	public void menu(){
			System.out.println("********Welcome to Payments Bank*******");
    		System.out.println("1--CREATE ACCOUNT");
    		System.out.println("2--LOGIN");
    		System.out.println("3--VIEW USERS");
    		System.out.println("4--EXIT");
    		int n1 = 0;
    		while(true) {
    			System.out.print("ENTER CHOICE: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("INCORRECT! ENTER INTEGER VALUE");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("INCORRECT");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		if(n1==1) {
    			AccountCreate();
    		}
    		else if(n1==2) {
    			AccountLogin();
    		}
    		else if(n1==3) {
    			ViewUser();
    		}
    		else {
    			exit();
    		}
	}
    	public void	AccountCreate() {
    			int id=0;
    			while(true) {
        			System.out.print("ENTER UNIQUE ID! ");
        			String ids = n.nextLine();
        			id = getInt(ids);
        			if(id==-8560928) {
        				System.out.println("INCORRECT");
        			}
        			else {
        				if(id<0) {
        					System.out.println("NEGATICE VALUE! INCORRECT");
        				}
        				else {
        					a.setId(id);
        					break;
        				}
        			}
        		}
    			String name = "";
    			while(true) {
    				System.out.print("ENTER NAME");
    				name = n.nextLine();
    				if(getStr(name)==0) {
    					System.out.println("ERROR! EMPTY STRING");
    				}
    				else {
    					a.setName(name);
    					break;
    				}
    			}
    			int bal=0;
    			while(true) {
        			System.out.print("ENTER STARTING BALANCE");
        			String ids = n.nextLine();
        			bal = getInt(ids);
        			if(bal==-8560928) {
        				System.out.println("INCORRECT");
        			}
        			else {
        				if(bal<0) {
        					System.out.println("ERROR");
        				}
        				else {
        					a.setBalance(bal);
        					break;
        				}
        			}
        		}
    			String pass = "";
    			while(true) {
    				System.out.print("ENTER PASSWORD ");
    				pass = n.nextLine();
    				if(getStr(pass)==0) {
    					System.out.println("ERROR! EMPTY!");
    				}
    				else {
    					a.setPassword(pass);
    					break;
    				}
    			}
    			a.setDate_created(d.toString());
    			if(ms.addAccount(a)==0) {
    				System.out.println("ALREADY EXISTS");
    			}
    			else {
    				System.out.println("SUCCESSFULLY ACCOUNT CREATED");
    			}
    			menu();
    		}
    	public void AccountLogin() {
    		int id=0;
			while(true) {
    			System.out.print("ENTER UNIQUE ID ");
    			String ids = n.nextLine();
    			id = getInt(ids);
    			if(id==-8560928) {
    				System.out.println("ERROR");
    			}
    			else {
    				if(id<0) {
    					System.out.println("NEGATIVE VALUE ERROR");
    				}
    				else {
    					a.setId(id);
    					break;
    				}
    			}
    		}
			String pass = "";
			while(true) {
				System.out.print("ENTER PASSWORD ");
				pass = n.nextLine();
				if(getStr(pass)==0) {
					System.out.println("EMPTY");
				}
				else {
					a.setPassword(pass);
					break;
				}
			}
			int mi = ms.login(a);
			if(mi==0) {
				System.out.println("DOESNT MATCH");
				menu();
			}
			else {
				loginID = a.getId();
				firstMenu();
			}
    		
    	}
    	public void firstMenu() {
    		System.out.println("1--CREDIT AMOUNT");
    		System.out.println("2--DEBIT AMOUNT");
    		System.out.println("3--VIEW BALANCE");
    		System.out.println("4--FUND TRANSFER");
    		System.out.println("5--VIEW ALL TRANSACTIONS");
    		System.out.println("6--EXIT");
    		int n1 = 0;
    		while(true) {
    			System.out.print("ENTER CHOICE ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("ENTER INTEGER VALUE!");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("ERROR");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		if(n1==1) {
    			credit();
    		}
    		else if(n1==2) {
    			debit();
    		}
    		else if(n1==3) {
    			viewBalance();
    		}
    		else if(n1==4){
    			fundTransfer();
    		}
    		else if(n1==5) {
    			viewTransactions();
    		}
    		else {
    			menu();
    		}
    	}
    	public void credit() {
    		int n1 = 0;
    		while(true) {
    			System.out.print("ENTER AMOUNT TO CREDIT");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("ENTER INTEGER VALUE!");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("ERROR");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		a.setId(loginID);
    		a.setBalance(n1);
    		a.setDate_created(d.toString());
    		ms.credit(a);
    		System.out.println("SUCCESSFULLY CREDITED , NEW BALANCE IS: "+ms.getBalance(a));
    		firstMenu();
    	}
    	public void debit() {
    		int n1 = 0;
    		while(true) {
    			System.out.print("ENTER AMOUNT TO DEBIT: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("ERROR");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("NEGATIVE ERROR");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		a.setId(fundID);
    		if(ms.checkID(a)==0) {
    			System.out.println("ID NOT PRESENT");
    		}
    		else {
    			a.setId(loginID);
    			a.setDate_created(d.toString());
    			a.setBalance(n1);
    			if(ms.debit(a)==0) {
    				System.out.println("AMOUNT ENTERED IS MORE");
    			}
    			else {
    				System.out.println("DEBITED SUCCESSFULLY, NEW BALANCE IS "+ms.getBalance(a));
    			}
    		}
    		firstMenu();
    	}
    	public void viewBalance() {
    		a.setId(loginID);
    		System.out.println("BALANCE IS "+ms.getBalance(a));
    		firstMenu();
    	}
    	public void fundTransfer() {
    		int id=0;
			while(true) {
    			System.out.print("ENTER TARGETS UNIQUE ID ");
    			String ids = n.nextLine();
    			id = getInt(ids);
    			if(id==-8560928) {
    				System.out.println("ERROR");
    			}
    			else {
    				if(id<0) {
    					System.out.println("NEGATIVE ERROR");
    				}
    				else {
    					fundID = id;
    					break;
    				}
    			}
    		}
			int n1 = 0;
			while(true) {
    			System.out.print("ENTER AMOUNT TO BE DEBITED");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("ERROR");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("NEGATIVE ERROR");
    				}
    				else {
    					break;
    				}
    			}
    		}
			a.setId(loginID);
			a.setBalance(n1);
			a.setDate_created(d.toString());
			if(ms.debit(a)==0) {
				System.out.println("AMOUNT EXCEEDING");
			}
			else {
				a.setId(fundID);
				a.setBalance(n1);
				a.setDate_created(d.toString());
				ms.credit(a);
				a.setId(loginID);
				System.out.println("TRANSFER SUCCESSFULL , NEW BALANCE: "+ms.getBalance(a));
			}
    		firstMenu();
    	}
    	public void viewTransactions() {
    		a.setId(loginID);
    		List<Wallet> al = ms.viewAllTransactions(a);
    		for(Wallet acc:al) {
    			System.out.print(acc.getId()+ " ");
    			System.out.print(acc.getChanged()+ " ");
    			System.out.print(acc.getDate_transaction());
    			System.out.println();
    		}
    		firstMenu();
    	}
    	public void ViewUser () {
    		List<Customer> al = ms.viewUsers();
    		for(Customer acc:al) {
    			System.out.print(acc.getId() + " ");
    			System.out.print(acc.getName()+ " ");
    			System.out.print(acc.getBalance()+" ");
    			System.out.print(acc.getDate_created());
    			System.out.println();
    		}
    		menu();
    	}
    	public void exit() {
    		System.out.println("THANK YOU!");
    	}
    public static int getInt(String s) {
    	int m = 0;
    	try {
    		m = Integer.parseInt(s);
    	}catch(Exception e) {
    		return -8560928;
    	}
    	return m;
    }
    public static int getStr(String s) {
    	if(s.trim().length()==0) {
    		return 0;
    	}
    	return 1;
    }

}
