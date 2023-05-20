package com.app.tester;
import com.app.banking.*;
import static utils.CollectionUtils.populateList;
import com.bankingApp.utils.InvalidInputException;
import com.bankingApp.utils.ValidationRule;
import java.time.LocalDate;
import java.util.*;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
		ArrayList<BankAccount> accHolder = populateList();
		System.out.println("Welcome to Aapka Bank");
		System.out.println("Choose operation: ");
		boolean exit = false;
		while(!exit)
		{try {
			System.out.println("1. Create  New Bank Account\n" + 
					"2. Display account summary of all accounts\n"
					+ "3. Withdraw from account\n"
					+ "4. Deposit into account\n"
					+ "5. Fund transfer\n"
					+ "6. Sort accounts based on account number\n"
					+ "7. Sort accounts based on account opening date\n"
					+ "8. Sort accounts based on account balance\n" + 
					"0. Exit");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Enter account number ");
				int accountNum  = ValidationRule.validateAccount(sc.nextInt(),accHolder);
				System.out.println("Enter customer name: ");
				String accName = sc.next();
				System.out.println("Enter account type (SAVING,CURRENT,FD,NRE,LOAN,NRO");
				AccountType accType = ValidationRule.validateAccType(sc.next().toUpperCase());
				System.out.println("Enter initial account Balance: ");
				double accBalance = ValidationRule.validateAccountBalance(sc.nextDouble(),accType);
				System.out.println("Enter account opening date(yyyy-mm-dd ");
				LocalDate date = ValidationRule.validAccOpeningDate(sc.next());
				accHolder.add(new BankAccount(accountNum,accName,accType,accBalance,date));
				System.out.println("Congratulation Your account is Registered");
				break;
			
			case 2://Display
				//System.out.println("Accounts summary: ");
				
//				for(BankAccount b : accHolder) 
//				{
//					System.out.println(b);
//				}
				accHolder.forEach(a->System.out.println(a));
				break;
			case 3://Withdraw from account
				System.out.println("Enter account number: ");
				accountNum = ValidationRule.checkAccount(accHolder,sc.nextInt());
				
				System.out.println("Enter amount you want to withdraw: ");
				double amount = sc.nextDouble();
				accHolder.get(accountNum).withDraw(amount);
				break;
				
			case 4://Deposit into account
				System.out.println("Enter account number: ");
				accountNum = ValidationRule.checkAccount(accHolder,sc.nextInt());
				System.out.println("enter amount you want to deposit");
				amount = sc.nextDouble();
				accHolder.get(accountNum).depositAmt(amount);
				break;
				
			case 5://Fund transfer
				System.out.println("Enter source acount number: ");
				int srcAcc = sc.nextInt();
				System.out.println("Enter receiver acount number: ");
				int destAcc = sc.nextInt();
				System.out.println("Enter amount you want to transfer");
				amount = sc.nextDouble();
				int srcAccIndex = accHolder.indexOf(srcAcc);
				int destAccIndex = accHolder.indexOf(destAcc);
				if(srcAccIndex == -1) {
					throw new InvalidInputException("Account dont exist");
				}
				if(destAccIndex == -1) {
					throw new InvalidInputException("Account dont exist");
				}
				//acctList.get(srcIndex).transferFunds(acctList.get(destIndex),amount);

				accHolder.get(srcAccIndex).fundTransfer(accHolder.get(destAccIndex),amount);
				System.out.println("Money transferred");
			
				break;
			
			case 6://Sort accounts based on account number
				Collections.sort(accHolder);
				System.out.println(accHolder);
				
				break;
				
			case 7:// Sort accounts based on account opening date
				Collections.sort(accHolder,new Comparator<BankAccount>() {
					@Override
					public int compare(BankAccount b1,BankAccount b2) {
						return b1.getOpeningDate().compareTo(b2.getOpeningDate());
						
					}
				});
				break;
				
			case 8://Sort accounts based on account balance\n
				Collections.sort(accHolder,new Comparator<BankAccount>() {
					@Override 
					public int compare(BankAccount b1, BankAccount b2)
					{
						if(b1.getAccountBalance()<b2.getAccountBalance()) {
							return -1;
						}
						if(b1.getAccountBalance()==b2.getAccountBalance()) {
							return 0;
						}
						return 1;
					}
				});
				break;
			case 9: //exit
				exit = true;
			}
			}
		 catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	}
}
		
