package entityclasses.gameentities;

public class vampires extends monster{

	public vampires() {
		super(100, 100, 40, 60, 205, 20, "Vampires", 50,
				"You encounter a bat, that morphed into a human figure, with sharp inci-sors. He appears to be bloodthirsty. Does not sparkle.");
		
	}

	public vampires(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
