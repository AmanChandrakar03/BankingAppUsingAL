package com.app.banking;

public enum AccountType {
SAVING(5_000),CURRENT(2_000),FD(50_000),NRE(1_00_000),LOAN(80_000),NRO(80_000);
	
	private int minimumBalance;
	
	private AccountType(int minBal){
		minimumBalance = minBal;
	}
	
	public int getMinimumBalance() {
		return this.minimumBalance;
	}
	
	
}
