package TeenTitians.src.entityclasses.gameentities;

import TeenTitians.src.entityclasses.Game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
//Monster class by Jerson&Wesley
public final class monster extends entity
{

    private String description;

    public monster()
    {
    	super();
    	description = "";
    }

    public monster(int health, int currentHealth, int speed, int accuracy, int ID, int attack, String name, int defense, String description) {
        super(health, currentHealth, speed, accuracy, ID, attack, name, defense);
        this.description = description;
    }

    public int attack(int[] playerStats) {
        if(determineFirstAttack(playerStats[2])) {
            takeDamage(playerStats[4]);
            if (currentHealth > 0) {
                return attack;
            }else{
                return 0;
            }
        }else{
            int pHP = playerStats[1]-attack;
            if (pHP > 0) {
                takeDamage(playerStats[4]);
                return attack;
            }else{
                return attack;
            }

        }

    }

    public boolean determineFirstAttack(int playerSpeed) {
        //True means player goes first, false means monster
        return playerSpeed > speed;
    }
    public boolean PlayerAttackHit(int playerAcc) {
        int rand = (int)(Math.random() * 101);
        return rand > playerAcc;
    }
    public boolean monAttackHit() {
        int rand = (int)(Math.random() * 101);
        return rand > accuracy;
    }
    public String examine() {
	    return description;
    }
}