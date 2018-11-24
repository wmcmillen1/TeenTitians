package TeenTitians.src.entityclasses.itemclasses;

import java.util.ArrayList;
import java.util.Scanner;
//Items by Austin
public class Item 
{
	public int stats;
	public boolean isConsumable;
	public boolean equip;
	Scanner input = new Scanner(System.in);
	ArrayList<String> Inventory = new ArrayList<String>();
	public Item() {
		stats = 13;
		isConsumable = false;
		equip = false;
	}

	public Item(int stats, boolean isConsumable, boolean equip) {

	}

	/**
	 * @return the stats
	 */
	public int getStats() {
		return stats;
	}

	/**
	 * @param stats
	 *            the stats to set
	 */
	public void setStats(int stats) {
		this.stats = stats;
	}

	/**
	 * @return the isConsumable
	 */
	public boolean isConsumable() {
		return isConsumable;
	}

	/**
	 * @param isConsumable
	 *            the isConsumable to set
	 */
	public void setConsumable(boolean isConsumable) {
		this.isConsumable = isConsumable;
	}

	/**
	 * @return the equip
	 */
	public boolean isEquip() {
		return equip;
	}

	/**
	 * @param equip
	 *            the equip to set
	 */
	public void setEquip(boolean equip) {
		this.equip = equip;
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<String> getInventory() {
		return Inventory;
	}

	/**
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(ArrayList<String> inventory) {
		Inventory = inventory;
	}

	public void consumeItem() {
		if (isConsumable == true) {
			System.out.println(getStats());
		}
	}

	public boolean pickUp(String item) 
	{
		if(item != null)
		{
			Inventory.add(item.toLowerCase());
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean Drop(String item) 
	{
		if(item != null)
		{
			Inventory.remove(item.toLowerCase());
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public void equip() 
	{
		
		System.out.println("Do you want to equip this item.");
		String item = input.nextLine();
		if (item.equalsIgnoreCase("yes")) 
		{
			System.out.println("Item has beem added to your inventory");
			System.out.println(Inventory);
	}
	}

	public boolean unequip() {
		
		System.out.println("Do you want to remove this item.");
		String item = input.nextLine();
		if (item.equalsIgnoreCase("yes")) 
		{
			System.out.println("Item has beem removed from your inventory");
			return true;
		}
		return false;

	}

	public void pour(boolean isA1Sauce, boolean isA1Steak) {
		if (isA1Sauce == true && isA1Steak == true) {
			System.out.println("A1 Sauce has been addesd to A1 Steak.");
		} else {
			System.out.println("Action cannot be performed. A1 sauce can only be combined with A1 Steak.");
		}
	}

	public void examine() 
	{
		System.out.println("Would you like to examine this item? ");
		String ans = input.nextLine();
		if(ans.equalsIgnoreCase("yes"))
		{
			System.out.println("Item Stats: " + getStats());
		}
		else
		{
			System.out.println();
		}
		
	}
	
	public int usePhylacteryheal() 
	{
	int healup = 0;
		
		System.out.println("Would you like to use the Phylactery? ");
		String ans = input.nextLine();
		if(ans.equalsIgnoreCase("yes"))
		{
			return healup + 1;
		}
		else
		{
			return healup;
		}	
	}
	
	public void usePhylacteryhint() 
	{
		
		System.out.println("Would you like to use the Phylactery? ");
		String ans = input.nextLine();
		if(ans.equalsIgnoreCase("yes"))
		{
		 System.out.println("You will recieve a hint.");
		}
		
	}

	}

}
