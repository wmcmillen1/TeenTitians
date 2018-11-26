package TeenTitians.src.entityclasses.itemclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//Items by Austin
public class Item 
{
	String name;
	String ID;
	String description;
	int goldValue;
	ArrayList<String> inventory = new ArrayList<String>();
	HashMap<String, String> inventoryMap = new HashMap<String, String>();

	public Item() {
		name = "";
		ID = "";
		description = "";
		goldValue = 0;
	}

	public Item(String name, String ID, String description, int goldValue) {
		this.name = name;
		this.ID = ID;
		this.description = description;
		this.goldValue = goldValue;
		inventoryMap.put("A1 Sauce","A1");
		inventoryMap.put("Steak","A2");
		inventoryMap.put("A1 Steak","A3");
		inventoryMap.put("Rotten Apple","A4");
		inventoryMap.put("Apple","A5");
		inventoryMap.put("Watermelon","A6");
		inventoryMap.put("Smol Potion","A7");
		inventoryMap.put("Big Ol’ Potion","A8");
		inventoryMap.put("Garlic","A9");
		inventoryMap.put("Vacuum","A10");
		inventoryMap.put("The Wimpy Dagger","A11");
		inventoryMap.put("The Iron Digger","A12");
		inventoryMap.put("Flaming Iron Dagger","A13");
		inventoryMap.put("Swift Sword","A14");
		inventoryMap.put("McBlessed Sword","A15");
		inventoryMap.put("Bow & arrow","A16");
		inventoryMap.put("Almighty Rubber Chicken","A17");
		inventoryMap.put("Small Wood-en Buckler","A18");
		inventoryMap.put("Wooden Targe ","A19");
		inventoryMap.put("Wooden Kite Shield","A20");
		inventoryMap.put("Metal Target Shield","A21");
		inventoryMap.put("Spiked Metal Target Shield","A22");
		inventoryMap.put("Eden’s Vigil","A23");
		inventoryMap.put("Eden’s Warden","A24");
		inventoryMap.put("Metal Crest","A25");
		inventoryMap.put("Steel Tower","A26");
		inventoryMap.put("Strange Glowing Jar","A27");
		inventoryMap.put("Phylactery","A28");
		inventoryMap.put("Red Key","A29");
		inventoryMap.put("Yellow Key","A30");
		inventoryMap.put("Blue Key","A31");
		inventoryMap.put("Green Key","A32");
		inventoryMap.put("Gold Piece","A33");
	}
	public Item(String itemName) {

		inventoryMap.put("A1 Sauce","A1");
		inventoryMap.put("Steak","A2");
		inventoryMap.put("A1 Steak","A3");
		inventoryMap.put("Rotten Apple","A4");
		inventoryMap.put("Apple","A5");
		inventoryMap.put("Watermelon","A6");
		inventoryMap.put("Smol Potion","A7");
		inventoryMap.put("Big Ol’ Potion","A8");
		inventoryMap.put("Garlic","A9");
		inventoryMap.put("Vacuum","A10");
		inventoryMap.put("The Wimpy Dagger","A11");
		inventoryMap.put("The Iron Digger","A12");
		inventoryMap.put("Flaming Iron Dagger","A13");
		inventoryMap.put("Swift Sword","A14");
		inventoryMap.put("McBlessed Sword","A15");
		inventoryMap.put("Bow & arrow","A16");
		inventoryMap.put("Almighty Rubber Chicken","A17");
		inventoryMap.put("Small Wooden Buckler","A18");
		inventoryMap.put("Wooden Targe ","A19");
		inventoryMap.put("Wooden Kite Shield","A20");
		inventoryMap.put("Metal Target Shield","A21");
		inventoryMap.put("Spiked Metal Target Shield","A22");
		inventoryMap.put("Eden’s Vigil","A23");
		inventoryMap.put("Eden’s Warden","A24");
		inventoryMap.put("Metal Crest","A25");
		inventoryMap.put("Steel Tower","A26");
		inventoryMap.put("Strange Glowing Jar","A27");
		inventoryMap.put("Phylactery","A28");
		inventoryMap.put("Red Key","A29");
		inventoryMap.put("Yellow Key","A30");
		inventoryMap.put("Blue Key","A31");
		inventoryMap.put("Green Key","A32");
		inventoryMap.put("Gold Piece","A33");

		inventory.add("Phylactery");

		this.goldValue = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}

	public ArrayList<String> getInventory() {
		return inventory;
	}

	public ArrayList<String> setInventory(ArrayList<String> inventory) {
	    return this.inventory = inventory;
    }
	public void addToInventory(String name) {
		inventory.add(name);
	}
	public void removeFromInventory(String name) {
		if (inventory.contains(name)) {
			inventory.remove(name);
		}
	}
	public HashMap<String, String> getInventoryMap() {
		return inventoryMap;
	}
	public void setInventoryMap(HashMap<String, String> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}

	public boolean pickUp(String item)
	{
		if(item != null)
		{
			inventory.add(item);
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
			inventory.remove(item.toLowerCase());
			return true;
		}
		else
		{
			return false;
		}
	}
	



	public void pour(boolean isA1Sauce, boolean isA1Steak) {
		if (isA1Sauce == true && isA1Steak == true) {
			System.out.println("A1 Sauce has been addesd to A1 Steak.");
		} else {
			System.out.println("Action cannot be performed. A1 sauce can only be combined with A1 Steak.");
		}
	}

	public String examine() {
		return "Item Stats: ";

	}
	


	public Item makeItem(String ID) {
		System.out.println(ID);
		switch (ID) {
			case "A1":
				return new Consumable("A1 Sauce", "A1", "Doesn't do much but it's some damn good sauce (goes well on steak)", 5, 10, 0, 0);
			case "A2":
				return new Consumable("Steak", "A2", "Taste great but could use some A1 sauce", 10, 10, 0, 0 );
			case "A3":
				return new Consumable("A1 Steak", "A3", "The finest cuisine with both A1 sauce and steak", 20, 20, 5, 0);
			case "A4":
				return new Consumable("Rotten Apple", "A4", "Not the best fruit but it'll do", 1, 5, -5, -10);
			case "A5":
				return new Consumable("Apple", "A5", "Better fruit but sadly not watermelon", 3, 10, 0, 0);
			case "A6":
				return new Consumable("Watermelon", "A6", "OMG ITS WATERMELON SOOOO GOOD!!", 15, 20, 0, 5);
			case "A7":
				return new Consumable("Small Potion", "A7", "Itty bitty potion that looks dark dirty red",20, 10, 0, 0);
			case "A8":
				return new Consumable("Big Ol’ Potion", "A8", "A blood red bottle that… wait. IS THAT ACTUAL BLOOD!?!?", 30, 30, 0, 0);
			case "A16":
				return new Consumable("Garlic", "A16", "Good for pasta sauce but more useful for keeping vampires away", 25, 1, 0 , 0);
			case "A26":
				return new Consumable ("Strange Glowing Jar", "A26", "A jar of glowing, light blue, presumably magical substance of an unknown origin. The contents of the jar form a type of balm, with a pungent aroma that compels one to spread to substance over themselves", 150, 100, 0, 0);
			case "A9":
				return new Weapons ("Vacuum”", "A9", "Sucks up shadows", 100, 100, 0, 0, 0, false);
			case "A10":
				return new Weapons ("The Wimpy Dagger", "A10", "Starting dagger that looks rusty and fragile (Hopefully the enemy got their tetanus shot)", 12, 0, 0, 0, 0,false);
			case "A11":
				return new Weapons ("The Iron Dagger", "A11", "A much better shiny dagger that is made of pure iron", 20, 45, 0, 0,0, false);
			case "A12":
				return new Weapons ("Flaming Iron Dagger", "A12", "Careful not to burn yourself. Slaps roof of dagger This baby can … Oh crap I'm on fire!!!", 30, 85, 0,0, 0, false);
			case "A13":
				return new Weapons ("Swift Sword", "A13", "ZOOM! ZOOOM! A white sword blessed with speed ill be able to beat anything (if i can hit it)",30, 450, -10, 0,0, false );
			case "A14":
				return new Weapons ("McBlessed Sword", "A14", "All hail the blessed sword. It is empowered with the power of the holy ones able to take down many foes at once. (although you’ll only fight one at a time wimp)", 75, 1000, 50, 50, 50, false);
			case "A15":
				return new Weapons ("Bow and arrow", "A15", "A curved short bow made of nice elder wood. Why a bow? TO MAKE PAIN RAIN DOWN ON OUR ENEMIES!!!", 30, 90, 25, 0, 0,false);
			case "A28":
				return new Weapons ("Almighty Rubber Chicken", "A28", "A rubber chicken from the depths of hell. Forged in the fires of Mordor. By Sauron’s most gifted blacksmith, Celebrimbor", 500000,  10000, 0,0,0, false);
			case "A23":
				return new Weapons ("Eden’s Warden", "A23", "Blessed armament of the first seraphim, who was entrusted with the protection of Eden after the eviction of man. This sword seems to be composed of flame given solid form, yet it does not burn the hand of the righteous. The sword turns every which way, searching for evil that it might be purged with divine flame", 60, 500, 30, 0,0, false);
			case "A17":
				return new Armor ("Small Wooden Buckler", "A17", "A small, wooden buckler to guard against light attacks from small weapons. Not very effective as a purely defensive item, but a dexterous user might be able to use it to parry",10, -1,-1,0,  80);
			case "A18":
				return new Armor ("Wooden Target", "A18", "A medium, wooden target fit for general combat against lightly armed foes. Acceptable defense against low-powered enemies, but leaves one wanting when confronted with more difficult foes. The increased size makes for more awkward handling than a buckler", 25, -2, -3, 0,  105);
			case "A19":
				return new Armor ("Wooden Kite Shield", "A19", "A medium-sized wooden kite shield intended for standard infantry combat. Offers a great balance between durability and maneuverability, but is still outclassed by shields made of sturdier materials.", 20, -2,-1,0,150);
			case "A20":
				return new Armor ("Metal Target Shield", "A20", "A small, metal buckler with decent durability. Less effective protection than a full-sized shield, but a dexterous user can use it to parry", 15, -2, -1, 0, 200);
			case "A21":
				return new Armor ("Spiked Metal Target Shield", "A21", "A small, metal buckler with decent durability and a large spike protruding from the center. Less effective protection than a full-sized shield, but the user can bash with the spike.", 15, -2, -1, 0, 215);
			case "A22":
				return new Armor ("Eden’s Vigil", "A22", "Blessed raiment of the first seraphim, who was entrusted with the protection of Eden after the eviction of man. This helm glows with celestial light, and purges the darkness from the wearer’s surroundings, and indeed, their very soul", 50, 0, 35, 25 , 500);
			case "A24":
				return new Armor ("Metal Crest", "A24", "A standard metal shield with no particular quirks or benefits. This is a good all-rounder for the novitiate adventurer just trying to get by.", 35, 0,0,0, 230);
			case "A25":
				return new Armor ("Steel Tower", "A25", "A large, steel tower shield probably intended for decorative or ceremonial purposes as opposed to live combat. Still, the shield is sturdy, and provided the weight doesn’t bother you, it’ll stop just about any blow from making purchase.", 45, -5, -5,0, 350 );
			case "A27":
				return  new Item ("Phylactery", "A27", "Every proctor is given a unique charm at the conclusion of their training. Though the form and composition of each charm may differ from proctor to proctor, its symbolism as an embodiment of faith and determination remains uniform. Clutching it is said to provide the user with nostalgic comfort and clarity of purpose, thought, and will -- though these effects may be purely placebic in nature.", 0);
			case "A29":
				return new Item ("Red Key", "A29", "It’s a red key. Maybe I can open yellow doors with this", 0);
			case "A30":
				return new Item ("Yellow Key", "A30", "It’s a yellow key. Maybe I can open yellow doors with this",0) ;
			case "A31":
				return new Item ("Blue Key", "A31", "It’s a blue key. Maybe I can open yellow doors with this", 0);
			case "A32":
				return new Item ("Green Key", "A32", "It’s a green key. Maybe I can open yellow doors with this", 0);
			case "A33":
				return new Currency ("Gold Piece", "A33", "Glittering, shining, sparkling gold! This stuff makes the world go ‘round, investors commit suicide, and less-than-savory people do less-than-savory things just to get by", 1);
			default:
				System.out.println("Just to make sure");
				return new Item("IMERROR", "IMERROR", "IMERROR",0);

		}
	}






}
