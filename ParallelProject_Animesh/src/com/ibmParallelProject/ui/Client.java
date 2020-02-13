package com.ibmParallelProject.ui;

import java.math.BigDecimal;
import java.util.Scanner;

import com.ibmParallelProject.beans.Customer;
import com.ibmParallelProject.service.*;

public class Client {
	public static void main(String[] args) {
		
		WalletService pk = new WalletServiceImpl();
		
		while(true)
		{
			
		System.out.println("###WELCOME TO PAYMENTS BANK###\nENTER YOUR CHOICE");
	
		System.out.println("1.Create An Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Fund transfer");
		System.out.println("4.Amount to be Deposited");
		System.out.println("5.Amount to be Withdrawl");
		Scanner sc = new Scanner(System.in);
		int m = 0;
		while(true) {
		String option = sc.nextLine();
		try {
			m = Integer.parseInt(option);
			break;
		}catch(Exception e) {
			System.out.println("Error");
			continue;
		}
		}
		switch (m) {
//		case 0:
//			System.out.println("Enter pin");
//			int pin = sc.nextInt();
			

		case 1:
			
			
			System.out.println("Enter Your Name");
			String name = sc.next();
			System.out.println("Enter Your mobile no");
			String mob = sc.next();
			System.out.println("Enter Amount ");
			BigDecimal bigdecimal = sc.nextBigDecimal();
	
			try {
				Customer cust = pk.createAccount(name, mob, bigdecimal);
				//System.out.println(cust);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			

			break;
		case 2:
			System.out.println("Enter your mobile no");
			String mob1 = sc.next();
			try {
				Customer cust1 = pk.showBalance(mob1);
				System.out.println("Balance in account is:" + cust1.getWallet().getBalance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			break;
		default:
			System.out.println("WRONG CHOICE!!!");
		case 3:
			System.out.println("Enter your source mobile no");
			String smob = sc.next();
			System.out.println("Enter your target mobile no");
			String tmob = sc.next();
			System.out.println("Enter amount to be transferred");
			BigDecimal amount = sc.nextBigDecimal();
			try {
				Customer cust = pk.fundTransfer(smob, tmob, amount);
				System.out.println("Balance successfully transfered\nBalance after transaction is"
						+ cust.getWallet().getBalance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Enter your mobile no");
			String dmob = sc.next();
			System.out.println("Enter amount to be deposited");
			BigDecimal damount = sc.nextBigDecimal();
			try {
				Customer cust = pk.depositAmount(dmob, damount);
				System.out.println("Balance after depositing is" + cust.getWallet().getBalance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Enter your mobile no");
			String wmob = sc.next();
			System.out.println("Enter amount to be withdrawm");
			BigDecimal wamount = sc.nextBigDecimal();
			try {
				Customer cust = pk.withdrawAmount(wmob, wamount);
				System.out.println("Balance after withdrawal is" + cust.getWallet().getBalance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}
	}
}
