package com.JavaAssigments.ass14_q14_groupStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * represents TJMaxx store class. https://tjmaxx.com/
 */
public class TJMaxx {

	/**
	 * Private lists to hold regular Item objects and OnSaleItem objects that
	 * represent items that sell in TJMaxx
	 */
	private List<Item> regularItemList;
	private List<OnSaleItem> onSaleItemList;

	/**
	 * Public no-args constructor - Instantiates regularItems and onSaleItems lists
	 * as new ArrayList
	 */
	public TJMaxx() {
		// TODO
		regularItemList = new ArrayList<Item>();
		onSaleItemList = new ArrayList<OnSaleItem>();
	}

	/**
	 * adds an item object to regularItems list
	 * 
	 * @param item
	 */

// Item pantalon = new Item("bluejean", 1, 1, 100.0);
//addRegularItem(pantalon);

	public void addRegularItem(Item item) {
		regularItemList.add(item);
	}

	/**
	 * adds OnSaleItem object to onSaleItems list
	 * 
	 * @param item
	 */
	public void addOnSaleItem(OnSaleItem item) {
		onSaleItemList.add(item);
	}

	/**
	 * getter for regularItems
	 * 
	 * @return
	 */
	public List<Item> getRegularItems() {
		// TODO change from null
		return regularItemList;
	}

	/**
	 * getter for onSaleItems
	 * 
	 * @return
	 */
	public List<OnSaleItem> getOnSaleItems() {
		// TODO change from null
		return onSaleItemList;
	}

	/**
	 * return count of regularItem object
	 * 
	 * @return
	 */
	public int regularItemsCount() {
		// TODO change from -1
		return regularItemList.size();
	}

	/**
	 * returns count of onSaleItems in TJ Maxx
	 * 
	 * @return
	 */
	public int onSaleItemsCount() {
		// TODO change from -1
		return onSaleItemList.size();
	}

	/**
	 * returns the name of each item in TJ Maxx starting from regular item then
	 * onSaleItems
	 * 
	 * @return
	 */
	public List<String> getAllItemNames() {

		List<String> allItem = new ArrayList<String>();

		// allItem.add(regularItemList.get(0).getClass().getSimpleName());

		for (Item regular : regularItemList) {
			//allItem.add(regular.getClass().getSimpleName()); // ITEM ların obje isimlerini döndüm!!!
			allItem.add(regular.getName());		// if we want to learn Item's name 	
		}

		for (OnSaleItem sale : onSaleItemList) {
			//allItem.add(sale.getClass().getSimpleName());
			allItem.add(sale.getName());		// if we want to learn Item's name 	
		}

		return allItem;
	}

	/**
	 * gets catalog number and returns price for the item it will search for the
	 * item both regularItems and onsaleonSaleItems
	 * 
	 * @param catalogNumber
	 * @returns 0.0 if product cannot be found with that catalognumber
	 */
	public double getItemPrice(int catalogNumber) {

		for (Item regular : regularItemList) {
			if (regular.getCatalogNumber() == catalogNumber) {
				return regular.getPrice();
			}
		}

		for (OnSaleItem sale : onSaleItemList) {
			if (sale.getCatalogNumber() == catalogNumber) {
				return sale.getPrice();
			}
		}

		return 0.0;

	}

	/**
	 * accepts a name then searches amoung onSaleItems. Once it finds, the method
	 * will return that OnSaleItem object
	 * 
	 * @param name
	 * @return
	 */

//	OnSaleItem pantalon = new OnSaleItem("bluejeans", 1, 101, 100, 10);

	public OnSaleItem getOnSaleItem(String name) {

		for (OnSaleItem sale : onSaleItemList) {
			if (sale.getName() == name) {
				return sale;
			}
		}
		return null;
	}

	/**
	 * removes the item with matching catalogNumber from both regularItems and
	 * onSaleItems. Does nothing if not found
	 * 
	 * @param catalogNumber
	 */
	public void removeItem(int catalogNumber) {

		for (Item regular : regularItemList) {
			if (regular.getCatalogNumber() == catalogNumber) {
				regularItemList.remove(regular);
			}
		}

		for (OnSaleItem sale : onSaleItemList) {
			if (sale.getCatalogNumber() == catalogNumber) {
				onSaleItemList.remove(sale);
			}
		}
		System.out.println("There is no item with this catalog number!!!");
	}

	/**
	 * - it accepts a catalog number and finds that item among regularItems and
	 * onSaleItems - if it finds the item: - decrease the count of the Item by 1 -
	 * 
	 * if count reaches 0 after decrementing then remove the product(call removeItem
	 * method)
	 *
	 * @param catalogNumber
	 */
	public void buyItem(int catalogNumber) {

		for (Item regular : regularItemList) {
			if (regular.getCatalogNumber() == catalogNumber) {
				if (regular.getQuantity() <= 1) {
					removeItem(catalogNumber);
					System.out.println("Out of STOCK, Item deleted");
				} else {
					regular.setQuantity(regular.getQuantity() - 1);

				}
			}
		}
		for (OnSaleItem sale : onSaleItemList) {
			if (sale.getCatalogNumber() == catalogNumber) {
				if (sale.getQuantity() <= 1) {
					removeItem(catalogNumber);
					System.out.println("Out of STOCK, Item deleted");
				} else {
					sale.setQuantity(sale.getQuantity() - 1);
				}
			}
		}
	}

}
