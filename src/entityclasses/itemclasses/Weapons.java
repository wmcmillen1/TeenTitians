package TeenTitians.src.entityclasses.itemclasses;

import TeenTitians.src.entityclasses.itemclasses.Item;
//Weapons Class by Austin
public class Weapons extends Item
{
	public int damage;
	public String itemDescription;
	public String name;
	public int ID;

	public Weapons() 
	{
		super();
		damage = 0;
		itemDescription = "";
		name = "";
		ID = 0;

	}

	public Weapons(int damage, String itemDescription, String name, int ID, int stats, boolean equip)
	{
		this.damage = damage;
		this.itemDescription = itemDescription;
		this.name = name;
		this.ID = ID;
		this.stats = stats;
		this.equip = equip;
	}
}
