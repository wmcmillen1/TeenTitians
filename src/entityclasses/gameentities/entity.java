package TeenTitians.src.entityclasses.gameentities;
//Entity Class by Jerson&Wesley
public class entity {
	protected String name;
	protected int ID;
	protected int health;
	protected int currentHealth;
	protected int speed;
	protected int attack;
	protected int defense;
	protected int accuracy;


	public entity() {
		name = "";
		health = 0;
		currentHealth = 0;
		speed = 0;
		accuracy = 0;
		ID = 0;
		attack = 0;
		defense = 0;
	}

	public entity(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name,
			int defense) {
		this.accuracy = accuracy;
		this.health = health;
		this.currentHealth = currentHealth;
		this.speed = speed;
		this.ID = ID;
		this.attack = attack;
		this.defense = defense;
		this.name = name;

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

	public int getCurrentHealth() { return currentHealth; }

	public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }

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

	public void takeDamage(int damageValue) {
		if (defense <= 30) {
			currentHealth -= (damageValue-5);
		}else if (defense > 30 && defense <= 50) {
			currentHealth -= (damageValue-15);
		}else if (defense > 50 && defense <= 70) {
			currentHealth -= (damageValue-30);
		}else{
			currentHealth -= (damageValue-45);
		}
	}
}
