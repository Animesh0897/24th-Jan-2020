package com.ibmParallelProject.service;
import java.math.BigDecimal;

import com.ibmParallelProject.beans.Customer;
import com.ibmParallelProject.repo.*;


public interface WalletService {
	public Customer createAccount(String name ,String mobileno, BigDecimal amount);
	public Customer showBalance (String mobileno);
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	public Customer depositAmount (String mobileNo,BigDecimal amount );
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);

}
