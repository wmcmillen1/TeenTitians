package entityclasses.gameentities;

public class shadowperson extends monster{

	public shadowperson() {
		super(100, 100, 40, 50, 204, 20, "Shadow Person", 30,
				"You sense a presence of a malicious entity, with a smell of sulfur.");
		
	}

	public shadowperson(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense,
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
