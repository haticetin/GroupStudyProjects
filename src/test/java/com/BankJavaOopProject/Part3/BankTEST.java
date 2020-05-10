package com.BankJavaOopProject.Part3;

public class BankTEST {
	public static void main(String[] args) {
		
		
		Akbank Talha = new Akbank(2000, "GOLD"); //constractor calistir!!
		System.out.println(Talha.getCurrentBalance());
		
		Talha.deposit(2000);  
		
		System.out.println(Talha.getCurrentBalance());
		
		Talha.withdraw(1000);
		
		System.out.println(Talha.getCurrentBalance());
		
		Talha.closeAccount();
		
		System.out.println("Talha Akbank Gold Final: " + Talha.getFinalBalance());
		System.out.println(Talha.getCurrentBalance());
		
		System.out.println("************************************");
		
		
		Talha = new Akbank (Talha.getFinalBalance(), "Saving");  // yeni saving hesabı
		
		System.out.println("Talha Akbank Saving Current: " + Talha.getCurrentBalance());
		
		Talha.closeAccount();   // Akbank Talha Saving hesabını kapattım
		System.out.println("Talha Akbank Saving Final: " + Talha.getFinalBalance());
		
		System.out.println("************************************");
		
		
		Karabank TalhaKara = new Karabank (Talha.getFinalBalance(), "interest");  
		
		System.out.println("TalhaKarabank Current:" + TalhaKara.getCurrentBalance());
		
		System.out.println("TalhaAkbank Current: " + Talha.getCurrentBalance());
		
		//System.out.println("TalhaAkbank Final : " + Talha.getFinalBalance());
		// finalBalance wallet a cevrilip static tutulması lazm.
		
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		/*
		Karabank Fatih = new Karabank(1000, "SAVING");
		System.out.println(Fatih.getCurrentBalance());
		
		//Fatih.deposit(1000);
		*/
	}

}
