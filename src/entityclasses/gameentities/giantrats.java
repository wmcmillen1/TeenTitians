package entityclasses.gameentities;

public class giantrats extends monster{

	public giantrats() {
		super(50, 50, 25, 40, 209, 10, "Giant Rats", 35,
				"You see a loose prisoner with shackles on his limbs. It looks as if he is hungry");
		
	}

	public giantrats(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
			String description)
	{
		this.health = health;
		this.currentHealth = currentHealth;
		this.speed = speed;
		this.accuracy = accuracy;
		this.ID = ID;
		this.attack = attack;
		this.name = name;
		this.defense = defense;
		this.description = description;
	}
}

