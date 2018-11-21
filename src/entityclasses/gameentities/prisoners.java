package entityclasses.gameentities;

public class prisoners extends monster{

	public prisoners() {
		super(75, 75, 25, 50, 208, 15, "Prisoners", 20,
				"You see a loose prisoner with shackles on his limbs. It looks as if he is hungry");
		
	}

	public prisoners(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
