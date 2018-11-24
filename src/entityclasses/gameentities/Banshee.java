package entityclasses.gameentities;

public class Banshee extends monster {
	
	 
	public Banshee() {
		super(300, 300, 60, 80, 201, 40, "Banshee", 85,
				"You hear an ominous wail from a woman in an all-white dress. She ap-pears to be on her knees combing her silky hair");
		
	}

	public Banshee(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
