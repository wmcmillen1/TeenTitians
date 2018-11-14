package entityclasses;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class monster extends entity
{

    //private final String name;
    //private final String description;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static Random random = new Random();
    private final static Set<Integer> monstersSeen = new HashSet<Integer>();

    public monster()
    {
    	hitPoints = 0;
    	minDamage = 0;
    	maxDamage = 0;
    }
    public monster(int hitPoints, int minDamage,int maxDamage)
    {
    this.hitPoints = hitPoints;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    }


public int attack(boolean attackhits)
{
	if (attackhits == true) {
		return random.nextInt(maxDamage - minDamage + 1) + minDamage;
	} else
		return 0;
}
public void examine()
{
	System.out.println();
}
}