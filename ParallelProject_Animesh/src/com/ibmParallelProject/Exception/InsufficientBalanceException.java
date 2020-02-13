package com.ibmParallelProject.Exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException{

	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
