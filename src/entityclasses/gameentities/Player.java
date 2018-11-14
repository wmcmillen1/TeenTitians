package TeenTitians.src.entityclasses.gameentities;

import java.util.Random;
//Player class by Jerson&Wesleyw

public final class Player extends entity {

	private String description;
	private boolean isBlocking = false;

	public Player() {
		super();
		description = "";
	}

	public Player(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense, String description) {
		super(health,currentHealth, speed, accuracy, ID, attack, name, defense);
		this.description = description;
	}

	public void Heal(int amount) {
		currentHealth+=amount;
	}


	public void defend() {
		isBlocking = true;
	}

	@Override
	public void takeDamage(int damageValue) {
		if (isBlocking){
			if (defense <= 30) {
				currentHealth -= (damageValue-10);
			}else if (defense > 30 && defense <= 50) {
				currentHealth -= (damageValue-30);
			}else if (defense > 50 && defense <= 70) {
				currentHealth -= (damageValue-60);
			}else{
				currentHealth -= (damageValue-90);
			}
		}else {
			super.takeDamage(damageValue);
		}
	}

	public boolean isAlive() {
		return currentHealth > 0;
	}

	public String getStatus() {
		return "Player HP: " + currentHealth;
	}

	public int[] getPlayerStatus() {
		int[] playerStats = new int[6];
		playerStats[0] = health;
		playerStats[1] = currentHealth;
		playerStats[2] = speed;
		playerStats[3] = accuracy;
		playerStats[4] = attack;
		playerStats[5] = defense;
		return playerStats;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}