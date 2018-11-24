package entityclasses.gameentities;

public class lich extends monster{

	public lich() {
		super(125, 125, 50, 60, 203, 25, "Lich", 55,
				"You see a glowing skeleton with a body full of armor. Its eyes appear to glow blue from underneath its murmillo helmet. It appears to be protecting a black leather box hanging on its neck.");
		
	}

	public lich(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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

