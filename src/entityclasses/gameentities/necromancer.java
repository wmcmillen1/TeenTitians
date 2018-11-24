package entityclasses.gameentities;

public class necromancer extends monster{

	public necromancer() {
		super(200, 200, 55, 75, 202, 35, "Necromancer", 71,
				"You encounter a woman in a purple dress. She glows a purple aura around her. It looks as if she controls the dead around her.");
		
	}

	public necromancer(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
