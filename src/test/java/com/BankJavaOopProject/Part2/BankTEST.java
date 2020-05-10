package com.BankJavaOopProject.Part2;

public class BankTEST {
	public static void main(String[] args) {
		
		Akbank Talha = new Akbank(2000, "GOLD");
		System.out.println(Talha.getCurrentBalance());
		
		Talha.deposit(2000);  
		
		System.out.println(Talha.getCurrentBalance());
		
		System.out.println();
		
		
		/*
		Karabank Fatih = new Karabank(1000, "SAVING");
		System.out.println(Fatih.getCurrentBalance());
		
		//Fatih.deposit(1000);
		*/
	}

}
