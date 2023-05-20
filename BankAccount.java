package com.app.banking;

import java.time.LocalDate;

import com.bankingApp.utils.InvalidInputException;
import com.bankingApp.utils.ValidationRule;

public class BankAccount implements Comparable<BankAccount>{

	private int accountNumber;
	private String customerName;
	private AccountType accountType;
	private double accountBalance;
	private LocalDate openingDate;
	
	//	CONSTRUCTOR
	public BankAccount(int accNo) {
		accountNumber = accNo;
	}
	
	public BankAccount(int accountNumber, String customerName, AccountType accountType, double accountBalance, LocalDate openingDate) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openingDate = openingDate;
	}
	
	// OVERRINDING OBJECT CLASS METHODS - EQUALS, TOSTRING

	public void withDraw(double amount) throws InvalidInputException
	{
		accountBalance = ValidationRule.validateBal(this.accountBalance - amount,this.accountType);
		System.out.println("amount withdrawn: "+amount);
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", openingDate=" + openingDate + "]";
	}

	@Override	
	public boolean equals(Object anotherBankAccount) {
		if(anotherBankAccount instanceof BankAccount)
			return (accountNumber == ((BankAccount)anotherBankAccount).accountNumber);
		return false;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public void depositAmt(double amount) {
		// TODO Auto-generated method stub
		accountBalance = accountBalance + amount;
		System.out.println("Amount deposited");
	}

	@Override
	public int compareTo(BankAccount anotherAcc) {
		if(this.accountNumber<anotherAcc.accountNumber) {
			return -1;
		}
		if(this.accountNumber==anotherAcc.accountNumber) {
			return 0;
		}
		return 1;
	}

	public void fundTransfer(BankAccount dest, double amount) throws InvalidInputException {
		// TODO Auto-generated method stub
		this.withDraw(amount);
		dest.depositAmt(amount);
		
	}
	
}
