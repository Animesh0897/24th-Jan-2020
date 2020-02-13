package com.ibm.ParallelProject.ui;

import java.util.Date;
import java.util.Scanner;

import com.ibm.ParallelProject.bean.Customer;
import com.ibm.ParallelProject.service.WalletService;

public class Main {
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		WalletService ws = new WalletService();
		Date d = new Date();
		while (true) {
			int n1 = 0;
			while (true) {
				System.out.println("***WELCOME TO PAYMENTS BANK***");
				System.out.println("1. Create an account");
				System.out.println("2. Log in to an existing account");
				System.out.println("3. View all users");
				System.out.println("4. To exit");
				String n12 = n.nextLine();
				try {
					n1 = Integer.parseInt(n12);
					break;
				} catch (Exception e) {
					System.out.println("Enter a number for further process");
				}
			}
			if (n1 == 1) {
				System.out.print("Enter your name: ");
				String name = n.nextLine();
				System.out.print("Enter your password: ");
				String password = n.nextLine();
				int id = 0;
				while (true) {
					System.out.print("Enter your ID: ");
					String id1 = n.nextLine();
					try {
						id = Integer.parseInt(id1);
						break;
					} catch (Exception e) {
						System.out.println("Error. ID should only be an integer value, try again");
					}
				}
				int bal = 0;
				while (true) {
					System.out.print("Enter your starting balance: ");
					String bal1 = n.nextLine();
					try {
						bal = Integer.parseInt(bal1);
						break;
					} catch (Exception e) {
						System.out.println("Balance should only be an integer value, try again");
					}
				}
				Customer c = new Customer();
				c.setId(id);
				c.setName(name);
				c.setPassword(password);
				c.setBalance(bal);
				c.setDate(d.toString());
				ws.createAccount(c);
				System.out.println("Account created successfully");
			} else if (n1 == 2) {
				int id = 0;
				while (true) {
					System.out.print("Enter your ID: ");
					String id1 = n.nextLine();
					try {
						id = Integer.parseInt(id1.trim());
						break;
					} catch (Exception e) {
						System.out.println("ID should only be an integer value, try again");
					}
				}
				System.out.print("Enter your password: ");
				String pass = n.nextLine();
				if (ws.login(id, pass)) {
					while (true) {
						int n2 = 0;
						while (true) {
							System.out.println("1. Credit balance");
							System.out.println("2. Debit balance");
							System.out.println("3. View balance");
							System.out.println("4. Fund transfer");
							System.out.println("5. View all transactions");
							System.out.println("6. Log out");
							String n21 = n.nextLine();
							try {
								n2 = Integer.parseInt(n21);
								break;
							} catch (Exception e) {
								System.out.println("Enter a number for further process");
							}
						}
						if (n2 == 1) {
							int money = 0;
							while (true) {
								System.out.print("Enter the amount that you want to credit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									break;
								} catch (Exception e) {
									System.out.println("Error... Amount should only be an integer value, try again");
								}
							}
							ws.deposit(id, money, d.toString());
						} else if (n2 == 2) {
							int money = 0;
							while (true) {
								System.out.print("Enter the amount that you want to debit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									if (money <= ws.balanceCheck(id)) {
										ws.withdraw(id, money, d.toString());
									} else {
										System.out.println("Withdrawn amount is more than the present balance");
									}
									break;
								} catch (Exception e) {
									System.out.println("Amount should only be an integer value, try again");
								}
							}
						} else if (n2 == 3) {
							System.out.println(ws.balanceCheck(id));
						} else if (n2 == 4) {
							int idp = 0;
							while (true) {
								System.out.print("Enter the ID of the person: ");
								String idp1 = n.nextLine();
								try {
									idp = Integer.parseInt(idp1);
									break;
								} catch (Exception e) {
									System.out.println("ID should only be an integer value, try again");
								}
							}
							int money = 0;
							while (true) {
								System.out.print("Enter the amount that you want to debit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									if (money <= ws.balanceCheck(id)) {
										ws.fundTransfer(id, money, idp, d.toString());
									} else {
										System.out.println("Withdrawn amount is more than the present balance");
									}
									break;
								} catch (Exception e) {
									System.out.println("Amount should only be an integer value, try again");
								}
							}
						} else if (n2 == 5) {
							ws.allTransactions(id);
						} else {
							break;
						}
					}
				} else {
					System.out.println("Wrong ID or password");
				}
			} else if (n1 == 3) {
				ws.allUsers();
			} else {
				break;
			}
		}
		System.out.println("Thank you for using PaymentsBank");
		ws.close();
	}
}