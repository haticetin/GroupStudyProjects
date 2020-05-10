package com.BankJavaOopProject.Part3;

public class Akbank extends Bank{

	
	public Akbank(double currentBalance, String accountType) {  //constractor
		super(currentBalance + 120, accountType);
		
		
		
		// final balance sıfırla
		
		switch (accountType.toLowerCase()) {   // intiliaze  
		case "gold":
			setDepositReturnValue(80);
			setWithdrawExpenceValue(70);
			setReturnRateValue(1.3);
			break;
		case "saving":
			setDepositReturnValue(90);
			setWithdrawExpenceValue(60);
			setReturnRateValue(1.2);
			break;
		case "interest":
			setDepositReturnValue(100);
			setWithdrawExpenceValue(50);
			setReturnRateValue(1.1);
			break;

		default:
			System.out.println("Invalid TYPE");
			break;
		}
		
	}

	

	

	


	
	

}
