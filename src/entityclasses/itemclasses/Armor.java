package TeenTitians.src.entityclasses.itemclasses;
//Armor by Austin
public class Armor extends Item
{
	public double durable;
	
	public Armor() 
	{
		super();
		durable = 0.0;
	}
	
public Armor(int stats, boolean isConsumable,  boolean equip)
{
	this.stats = stats;
	this.isConsumable = isConsumable;
	this.equip = equip;
}
	public Armor(double durable) 
	{
	this.durable = durable;	
	}
	
	public double block(double damage, int hitpoints, int stats) 
	{
		int durable = stats - hitpoints;
		return durable;
	}

}


