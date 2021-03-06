package TeenTitians.src.entityclasses.gameentities;
//Entity Class by Jerson&Wesley
public class Entity {
	protected String name;
	protected String ID;
	protected int health;
	protected int currentHealth;
	protected int speed;
	protected int attack;
	protected int defense;
	protected int accuracy;


	public Entity() {
		name = "";
		health = 0;
		currentHealth = 0;
		speed = 0;
		accuracy = 0;
		ID = "";
		attack = 0;
		defense = 0;
	}

	public Entity(int health, int currentHealth, int speed, int accuracy, String ID, int attack, String name,
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
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
			if (damageValue-5 > 0) {
				currentHealth -= (damageValue-5);
			}
		}else if (defense > 30 && defense <= 50) {
			if (damageValue-15 > 0) {
				currentHealth -= (damageValue-15);
			}
		}else if (defense > 50 && defense <= 70) {
			if (damageValue-30 > 0) {
				currentHealth -= (damageValue-30);
			}
		}else{
			if (damageValue-45 > 0) {
				currentHealth -= (damageValue-45);
			}
		}
	}
}
