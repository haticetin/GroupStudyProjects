package com.BankJavaOopProject.Part1;

public class BankPART1 {
	
	String BANKNAME;
	private double balance ; // instance Variable
	/*private*/ String accountType; // instance variable
	private double finalBalanceValue;
	// Welcome Money +++


	
	
	public BankPART1(double firstBalance, String accountType) { //Constructor // ilk değer atama
		this.balance = firstBalance + 120 ;
		this.accountType = accountType.toLowerCase(); // local variable ı instance var atadık
	
		if (!(this.accountType.equals("golden") || this.accountType.equals("saving") ||this.accountType.equals("interest"))) {
			System.out.println("Please Enter valid Account Type!!");
			System.exit(0);
		}
		
	}

	
	
	public void depositYATIR(double deposit) { //PARA YATIRMA
		
		if (deposit<0) {
			System.out.println("Invalid Data! Please enter positive value!");
		} else if (deposit<2000) {
			setBalance(balance + deposit);
			//balance += deposit;
			
		} else { // deposite 2000 ve üstü
			
			switch (accountType) {
			case "golden":
				setBalance(balance + deposit + 80 );
				break;
			case "saving":
				setBalance(balance + deposit + 90 );
				break;
			case "interest":
				setBalance(balance + deposit + 100 );
				break;
			default:
				System.out.println("INVALID type");
				break;
			}
		}
	}
	
	public void withdrawPARACEK (double withdraw) {
		
		if (withdraw<0) {
			System.out.println("Invalid Data! Please enter positive value!");
		} else if (withdraw<1000) {
			setBalance(balance - withdraw );
			//balance -= withdraw;
		} else { // withdraw 1000 ve üstü
			
			switch (accountType) {
			case "golden":
				setBalance(balance - withdraw - 70 );
				break;
			case "saving":
				setBalance(balance  - withdraw - 60 ) ;
				break;
			case "interest":
				setBalance(balance  - withdraw - 50 );
				break;
			default:
				System.out.println("INVALID type");
				break;
			}
		}
	}

	
	
	public double finalBalance () {  // Karı ekle , son parayı VER
		
		switch (accountType) {
		case "golden":
		finalBalanceValue= balance*1.3;
			break;
		case "saving":
			finalBalanceValue= balance*1.2;
				break;
		case "interest":
			finalBalanceValue= balance*1.1;
				break;
		default:
			System.out.println("INVALID type");
			finalBalanceValue=0;
			break;
		}
		
		return finalBalanceValue;
	}
	
	
	
	
	
	public double getBalance() { //getir göster
		return balance;
	}

	public void setBalance(double balance) { // düzenle ekle çıkar
		this.balance = balance;
	}



	public double getFinalBalanceValue() {
		return finalBalanceValue;
	}
	
	
	
	
	
	
	
	
	
	
		
	
	

	 
}
