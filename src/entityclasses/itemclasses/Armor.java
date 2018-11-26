package TeenTitians.src.entityclasses.itemclasses;
//Armor by Austin
public class Armor extends Item {
	public int defence;
	public int speed;
	public int accuracy;
	public int HP;

	public Armor() {

	}

	public Armor(String name, String ID, String description, int defence, int speed, int accuracy, int HP, int goldValue) {
		super(name, ID, description, goldValue);
		this.defence = defence;
		this.speed = speed;
		this.accuracy = accuracy;
		this.HP = HP;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public Item equip(String item)
	{
		if (makeItem(item) instanceof Armor) {
			return (Armor)(makeItem(item));
		}else{
			return new Armor("MIAERROR", "MIAERROR", "MIAERROR", 0, 0,0,0,0);
		}
	}


	public Armor unequip() {

		System.out.println("Item has been removed from your inventory");
		return new Armor("","","", 0,0,0,0,0);

	}

}