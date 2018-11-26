package TeenTitians.src.entityclasses.itemclasses;

import TeenTitians.src.entityclasses.itemclasses.Item;
//Weapons Class by Austin
public class Weapons extends Item
{
	private int damage;
	private int accuracy;
	private int speed;
	private int defence;
	private boolean equip;

	public Weapons() {

    }


    public Weapons(String name, String ID, String description, int damage,int goldValue, int accuracy, int speed, int defence, boolean equip) {
        super(name, ID, description, goldValue);
        this.damage = damage;
        this.accuracy = accuracy;
        this.speed = speed;
        this.equip = equip;
        this.defence = defence;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public boolean isEquip() {
        return equip;
    }

    public void setEquip(boolean equip) {
        this.equip = equip;
    }

    public Weapons equip(String item)
	{
		System.out.println("Item has been equiped");
		if (makeItem(item) instanceof Weapons) {
		    return (Weapons)(makeItem(item));
        }else{
		    return new Weapons("MIWERROR", "MIWERROR", "MIWERROR", 0, 0,0,0,0, false);
        }
	}


	public Weapons unequip() {

		System.out.println("Item has beem removed from your inventory");
		return new Weapons("","", "",0,0,0,0,0, false);

	}
}
