package com.BankJavaOopProject.Part2;

public class Akbank extends Bank{

	
	public Akbank(double currentBalance, String accountType) {
		super(currentBalance + 120, accountType);
		
	}

	@Override
	public void deposit(double deposit) {
		//bonus bul
		double bonus=0;  // olmadı child daki variable parent da kullanılamaz !!! Bonusa çözüm lazım !!
		switch (getAccountType()) {
		case "golden":
			 bonus=80;
			break;
		case "saving":
			 bonus=90;
			break;
		case "interest":
			 bonus=100;
			break;

		default:
			System.out.println("Invalid TYPE");
			break;
		}
		super.deposit(deposit);
	}
	
	

	


	
	

}
