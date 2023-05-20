package com.bankingApp.utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.banking.*;
import com.app.tester.*;
public class ValidationRule {
	public static int validateAccount(int accountNum,List<BankAccount> accHolder) throws InvalidInputException {
		BankAccount accnum = new BankAccount(accountNum);
		if(accHolder.contains(accnum)) 
			throw new InvalidInputException("Invalid account number");
		return accountNum;
	}

	public static AccountType validateAccType(String accountType) throws InvalidInputException{
	
		for(AccountType ac : AccountType.values()) {
			if(ac.name().equals(accountType)) {
				return  AccountType.valueOf(accountType);
			}
		}
		throw new InvalidInputException("No such account type exists.");
	}
	public static double validateAccountBalance(double accBalance,AccountType accType) throws InvalidInputException {
		if(accBalance<accType.getMinimumBalance()) {
			throw new InvalidInputException("Less than minm balance");
		}
		return accBalance;
	}

	public static LocalDate validAccOpeningDate(String date) throws InvalidInputException {
		LocalDate opDate = LocalDate.parse(date);
		if(LocalDate.now().isAfter(opDate)) {
			return opDate;
		}
		throw new InvalidInputException("account cannot be open");
		}

	public static int checkAccount( ArrayList<BankAccount> accHolder,int accNum) throws InvalidInputException {
		BankAccount accountNumber = new BankAccount(accNum);
		int index = accHolder.indexOf(accountNumber);
		if(index == -1) {
			throw new InvalidInputException("Invalid");
		}
		return index;
	}

	public static double validateBal(double bal, AccountType accountType) throws InvalidInputException {
		  if(bal < accountType.getMinimumBalance()) {
				throw new InvalidInputException("account cannot be open");
		  }
		  return bal;
	}

}
