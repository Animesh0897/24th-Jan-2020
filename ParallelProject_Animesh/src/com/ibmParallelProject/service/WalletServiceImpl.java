
package com.ibmParallelProject.service;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibmParallelProject.beans.Customer;
import com.ibmParallelProject.beans.Wallet;
import com.ibmParallelProject.Exception.InsufficientBalanceException;
import com.ibmParallelProject.Exception.InvalidInputException;
import com.ibmParallelProject.Exception.MobileNumberNotRegistered;
import com.ibmParallelProject.Exception.ZeroBalanceException;
import com.ibmParallelProject.repo.WalletRepo;
import com.ibmParallelProject.repo.WalletRepoImpl;


public class WalletServiceImpl implements WalletService
{
 
	WalletRepo repo=new WalletRepoImpl();
	public Customer createAccount(String name, String mobileNo, BigDecimal amount) 
	{
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException("Amount cannot be negative");
			
		}
		Pattern p=Pattern.compile("[0-9]{10}");
		Matcher m=p.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{		
		Customer customer1=null;
		try {
			customer1=repo.findOne(mobileNo);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		
		if(customer1==null)
		{
		   Wallet ob=new Wallet(amount);
	     Customer customer=new Customer(name,mobileNo,ob);
			//customer1=customer;
			
			try {
				//System.out.println(customer1);
				repo.save(customer);
			} catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
		return customer1;
		}
		else
		{
			
			
			throw new MobileNumberNotRegistered("your mobile number already registered");
		}
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
		}

	public Customer showBalance(String mobileNo) 
	{
		Pattern p=Pattern.compile("[0-9]{10}");
		Matcher m=p.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{	
		       Customer customer=null;
		         try 
		       {
			         customer = repo.findOne(mobileNo);
		       }
		         catch (ClassNotFoundException | SQLException e) 
		        {
			     // TODO Auto-generated catch block
			       e.printStackTrace();
		        }
		            if(customer!=null)
			           return customer;
		                    else
		                	throw new MobileNumberNotRegistered("your mobile number already registered");
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
			
	}
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)
    {
	
		
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			
			throw new ZeroBalanceException("You cannot transfer Zero balance");
			
		}  
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException("amount cannot be negative");
			
		} 
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(sourceMobileNo);
		Matcher m1=pattern.matcher(targetMobileNo);
		if(m.find()&& m.group().equals(sourceMobileNo) &&  m1.find()&& m1.group().equals(targetMobileNo))
		{
		Customer cust1=null;
		Customer cust2=null;
		try {
			cust1=repo.findOne(sourceMobileNo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		try {
			 cust2=repo.findOne(targetMobileNo);
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.getMessage();
		}
	    if(cust1==null && cust2==null)
	    {
	    	throw new MobileNumberNotRegistered("Source mobile Number and target mobile number is not registered");
	    }
	    else if(cust2==null)
	    {
	    	throw new MobileNumberNotRegistered("Target mobile Number is not registered");
	    }
	    else if(cust1==null)
	    {
	    	throw new MobileNumberNotRegistered("Source mobile Number is not registered");
	    }
	    else
	    {
	    	if(sourceMobileNo.equals(targetMobileNo))
			{
				
				
				
				

				throw new InvalidInputException("Source mobile number and target mobile number cannot be same");
			}
		BigDecimal p=cust1.getWallet().getBalance();
		//System.out.println("before sub source"+p);
		p=p.subtract(amount);
		if(p.compareTo(new BigDecimal("0.00")) <0)
		{
			throw new InsufficientBalanceException("Insufficient balance in source registered mobile number");
		}
		//System.out.println("after sub source"+p);
		Wallet ob=new Wallet(p);
		cust1.setWallet(ob);
		//System.out.println("finally in wallet"+cust1.getWallet().getBalance());
		BigDecimal q=cust2.getWallet().getBalance();
		//System.out.println("before tar source"+q);
		q=q.add(amount);
		//System.out.println("after tar source"+q);
				Wallet ob1=new Wallet(q);
		cust2.setWallet(ob1);
		System.out.println("finally in wallet"+cust2.getWallet().getBalance());
          try {
			repo.save(cust1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			repo.save(cust2);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         return cust1;
	    }
    }
	else
	{
		throw new InvalidInputException("please correctly enter 10 digit mobile number");
	}
    }
	public Customer depositAmount(String mobileNo, BigDecimal amount)
	{
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			
			throw new ZeroBalanceException("You cannot deposit Zero balance in your account");
			
		} 
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException(" deposited amount caanot be negative or zero");
			
		} 
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{
		Customer cust1=null;
		try {
			cust1=repo.findOne(mobileNo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(cust1==null)
		    {
		    	throw new MobileNumberNotRegistered(" mobile Number is not registered");
		    }
		 else
		 {
		BigDecimal p1=cust1.getWallet().getBalance();
		p1=p1.add(amount);
		Wallet ob=new Wallet(p1);
		cust1.setWallet(ob);
		try {
		repo.save(cust1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust1;
		 }
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
	}
	public Customer withdrawAmount(String mobileNo, BigDecimal amount)
	{
		
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			
			throw new ZeroBalanceException("You cannot withdraw Zero balance in your account");
			
		} 
		if(amount.compareTo(new BigDecimal("0.00")) <=0)
		{
			
			throw new InvalidInputException("withdrawl amount caanot be negative ror zero");
			
		} 
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{
		Customer cust1=null;
		try {
			cust1=repo.findOne(mobileNo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 if(cust1==null)
		    {
		    	throw new MobileNumberNotRegistered("mobile Number is not registered");
		    }
		 else
		 {
		BigDecimal p1=cust1.getWallet().getBalance();
		p1=p1.subtract(amount);
		if(p1.compareTo(new BigDecimal("0.00")) <0)
		{
			throw new InsufficientBalanceException("Insufficient balance in source registered mobile number");
		}
		Wallet ob=new Wallet(p1);
		cust1.setWallet(ob);
		try {
		repo.save(cust1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cust1;
		 }
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
}
}