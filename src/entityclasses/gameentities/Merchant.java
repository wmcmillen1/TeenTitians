package TeenTitians.src.entityclasses.gameentities;

import java.util.ArrayList;
//Merchant class by Clyde
//Merchant was not implemented due solely to time constraints, and focusing on more Mission critical features.
public class Merchant {
	ArrayList<String> buy = new ArrayList<String>();
	ArrayList<String> sell = new ArrayList<String>();
	 ArrayList<String> orders = new ArrayList<String>();
	 
	public double merchantGold;
	public double itemCost;

	public Merchant() {
		merchantGold = 0;
		itemCost = 0;
	}

	public Merchant(double merchantGold, double itemCost) {
		this.merchantGold = merchantGold;
		this.itemCost = itemCost;
	}

	public double getMerchantGold() {
		return merchantGold;
	}

	public void setMerchantGold() {
		this.merchantGold = merchantGold;
	}

	public double getitemCost() {
		return itemCost;
	}

	public void ItemCost() {
		this.itemCost = itemCost;
	}

	public void buyItem(double itemgp, double playerGold)
	{
		ArrayList<String> buy = new ArrayList<String>();
		int exchange = 0;
		 for (int i = 0; i < orders.size(); i++) {
		 System.out.println("" + orders.get(i));
        if (orders.get(i).contains("buy")) 
        { 
             buy.add(orders.get(i));
            
        }
             exchange = 0;
        }

	}

	public void sellItem() {
		 ArrayList<String> sells = new ArrayList<String>(); 
		 int exchange = 0;
		 for (int i = 0; i < orders.size(); i++) {
		 System.out.println("" + orders.get(i));

		 if (orders.get(i).contains("sell")) {
		 sells.add(orders.get(i));
		 }
		 int sell = 0;
	}

}}
