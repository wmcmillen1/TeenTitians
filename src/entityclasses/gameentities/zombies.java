package entityclasses.gameentities;

public class zombies extends monster{

	public zombies() {
		super(75, 75, 37, 50, 207, 15, "Zombies", 20,
				"You smell the dead flesh of the undead. It appears to have a missing limb.");
		
	}

	public zombies(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
