package com.BankJavaOopProject.Part3;

public class Bank { // PARENT SUPER CLASS

	String bankName;
	private double currentBalance;
	private String accountType;

	
	private double depositReturnValue;
	private double withdrawExpenceValue;
	private double returnRateValue;
	private double finalBalance; // bu hesap kapatıldığda güncellenecek
								 // USER ın mevcut PARASI editlenebilir
	
	// private double welcomeMoney;
	// return rate --
	
	
	public Bank(double currentBalance, String accountType) { // constractor

		this.currentBalance = currentBalance; // buraya Welcome işlenmeli!!
		this.accountType = accountType.toLowerCase();
	}

	
	public void deposit(double deposit) { // mevcut balancı guncelleyecek!

		if (deposit < 0) {
			System.out.println("Invalid DATA!");
		} else if (deposit < 2000) {
			currentBalance += deposit;
			// setCurrentBalance(getCurrentBalance() + deposit);
		} else { // 2000 ve üstü para yatırılırsa
			//currentBalance += deposit + bonus ;
			currentBalance += deposit + depositReturnValue;
			
		}

	}
	
	
	public void withdraw(double withdraw) { // mevcut balancı guncelleyecek!

		if (withdraw < 0) {
			System.out.println("Invalid DATA!");
		} else if (withdraw < 1000) {
			currentBalance -= withdraw;
	
		} else { // 1000 ve üstü para çekilirse
			//currentBalance += deposit + bonus ;
			currentBalance -= (withdraw + withdrawExpenceValue);
			
		}

	}
	
	
	public void closeAccount(){
		
		finalBalance = currentBalance * returnRateValue;
		currentBalance =0;
	}
	
	
	
	
	
	public double getFinalBalance() {
		return finalBalance;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	public double getDepositReturnValue() {
		return depositReturnValue;
	}

	public void setDepositReturnValue(double depositReturnValue) {
		this.depositReturnValue = depositReturnValue;
	}

	public double getWithdrawExpenceValue() {
		return withdrawExpenceValue;
	}

	public void setWithdrawExpenceValue(double withdrawExpenceValue) {
		this.withdrawExpenceValue = withdrawExpenceValue;
	}

	public double getReturnRateValue() {
		return returnRateValue;
	}

	public void setReturnRateValue(double returnRateValue) {
		this.returnRateValue = returnRateValue;
	}

}
