package com.JavaAssigments.ass14_q14_groupStudy;



public class TEST {

	public static void main(String[] args) {
		
		TJMaxx UKtjmaxx = new TJMaxx();
		
		Item menSuit = new Item("Black Suit", 101, 2, 1000);
		Item womenSuit = new Item("Pink Suit", 102, 3, 2000);
		Item menShirt = new Item("Blue Tank-top Shirt", 103, 2, 100);
		Item womenShirt = new Item("Red Tank-top Shirt", 104, 3, 200);
		
		OnSaleItem menTrousers = new OnSaleItem("Blue jean trousers", 3, 105, 200, 10);
		OnSaleItem womenTrousers = new OnSaleItem("White jean trousers", 2, 106, 400, 10);
		OnSaleItem socks = new OnSaleItem("Winter Socks", 1, 107, 100, 50);
		
		
		Item[] items = {menSuit,womenSuit,menShirt,womenShirt};
		OnSaleItem[] saleItems = {menTrousers,womenTrousers,socks};
		
		//UKtjmaxx.addRegularItem(menSuit);
		//UKtjmaxx.addOnSaleItem(menTrousers);
		
		for (Item item :items) {
			UKtjmaxx.addRegularItem(item);
		}
		for (OnSaleItem saleItem : saleItems) {
			UKtjmaxx.addOnSaleItem(saleItem);
		}
		
		
		System.out.println(UKtjmaxx.getRegularItems());
		System.out.println(UKtjmaxx.getOnSaleItems());
		
		System.out.println(UKtjmaxx.getAllItemNames());
		
		System.out.println(UKtjmaxx.getItemPrice(101));
		
		System.out.println(UKtjmaxx.getOnSaleItem("Winter Socks"));
		
		UKtjmaxx.buyItem(101);
		
		System.out.println(menSuit.getQuantity());
		
		UKtjmaxx.buyItem(107);
		
		
	}
	
}
