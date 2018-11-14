package entityclasses;

public class entity {
	public String description;
	public String name;
	public int ID;
	public int health;
	public int speed;
	public int attack;
	public int defense;
	public int accuracy;

	public entity() {
		description = "";
		name = "";
		health = 0;
		speed = 0;
		accuracy = 0;
		ID = 0;
		attack = 0;
		defense = 0;
	}

	public entity(int health, int speed, int accuracy, int ID, String description, int attack, String name,
			int defense) {
		this.accuracy = accuracy;
		this.health = health;
		this.speed = speed;
		this.ID = ID;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * public int attack(entity other) { int att = (int)(this.attack)+(this.speed) +
	 * this.accuracy; other.health -= att; return att;
	 **/
}
