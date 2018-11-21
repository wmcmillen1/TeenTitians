package entityclasses.gameentities;

public class skeletons extends monster{

	public skeletons() {
		super(75, 75, 33, 35, 206, 15, "Skeletons", 25,
				"You see bones on the floor that sprawl up to form a full skeleton with glowing red eyes");
		
	}

	public skeletons(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
