package com.BankJavaOopProject.Part2;

public class Bank { // PARENT SUPER CLASS

	String bankName;
	private double currentBalance;
	private double finalBalance; // kar payı ile gelen para
	private String accountType;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	// private double welcomeMoney;
	// return rate --
	public Bank(double currentBalance, String accountType) { // constractor

		this.currentBalance = currentBalance; // buraya Welcome işlenmeli!!
		this.accountType = accountType;
	}

	public void deposit(double deposit) { // mevcut balancı guncelleyecek!

		if (deposit < 0) {
			System.out.println("Invalid DATA!");
		} else if (deposit < 2000) {
			currentBalance += deposit;
			// setter ile de yapılır;
			// setCurrentBalance(getCurrentBalance() + deposit);
		} else { // 2000 ve üstü para yatırılırsa
			//currentBalance += deposit + bonus ;
		}

	}

	/*public void bonusCalc(String accountType) {

		switch (accountType) {
		case "gold":
			bonusAkbank= 80;
			bonusKarabank=80;
			expenceAkbank=70
			expenceKarabank=90;
			
			break;
		case "saving":

			break;
		case "interest":

			break;

		default:
			break;
		}
	}*/

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

}
