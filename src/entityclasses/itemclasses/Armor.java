package TeenTitians.src.entityclasses.itemclasses;
//Armor by Austin
public class Armor extends Item 
{
	public double defence;
	public double speed;
	public double accuracy;
	
	
	public Armor() 
	{
		super();
		defence = 0;
		speed = 0;
		accuracy = 0;
		
	}
	
public Armor(int stats, boolean isConsumable,  boolean equip)
{
	
}
	public Armor(double defence, double speed, double accuracy) 
	{
	this.defence = defence;
	this.speed = speed;
	this.accuracy = accuracy;
	}
	
	public String block(double damage, int hitpoints, int stats) 
	{
		System.out.println("");
		int durable = stats - hitpoints;
		System.out.println("Attack blocked,");
		return "-" + durable;
	}

}
