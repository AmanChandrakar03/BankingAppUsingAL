package utils;

import static com.app.banking.AccountType.CURRENT;
import static com.app.banking.AccountType.FD;
import static com.app.banking.AccountType.LOAN;
import static com.app.banking.AccountType.SAVING;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


import com.app.banking.BankAccount;

public class CollectionUtils {

public static ArrayList<BankAccount> populateList(){
		
		//Create empty map
		ArrayList<BankAccount> list = new ArrayList<>();
		//int accountNumber, String customerName, AccountType accountType, double accountBalance, LocalDate openingDate
		list.add(new BankAccount(10, "Aman", SAVING,50000, parse("2010-04-23")));
		list.add(new BankAccount(101, "Rahul", LOAN,250000, parse("2020-01-03")));
		list.add(new BankAccount(56, "Virat", SAVING,520000, parse("2015-01-31")));
		list.add(new BankAccount(121, "Ajinkya", CURRENT,5000, parse("2003-11-23")));
		list.add(new BankAccount(1011, "Slam", FD,150000, parse("2018-07-23")));
		
		//System.out.println(map);
		return list;
	}
}
