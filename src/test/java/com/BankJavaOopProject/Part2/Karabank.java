package com.BankJavaOopProject.Part2;

public class Karabank extends Bank {

	
	
	public Karabank(double currentBalance, String accountType) {
		
		super(currentBalance + 100, accountType);
		
	}

	@Override
	public void deposit(double deposit) {
		// TODO Auto-generated method stub
		super.deposit(deposit);
	}
	
	
	

}
