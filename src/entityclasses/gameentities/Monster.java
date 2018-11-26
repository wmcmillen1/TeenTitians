package TeenTitians.src.entityclasses.gameentities;

//Monster class by Jerson&Wesley
public class Monster extends Entity
{

    private String description;
    private int probability;
    private String drops;
    private int goldDrop;


    public Monster(int health, int currentHealth, int speed, int accuracy, String ID, int attack, String name, int defense, String description, int probability, String drops, int goldDrop) {
        super(health, currentHealth, speed, accuracy, ID, attack, name, defense);
        this.description = description;
        this.probability = probability;
        this.drops = drops;
        this.goldDrop = goldDrop;
    }

    public Monster() {
        super(0, 0, 0, 0, "ERROR", 0, "CONERROR", 0);
        this.description = "ERROR";
        this.probability = 0;
        this.drops = "ERROR";
        this.goldDrop = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public String getDrops() {
        return drops;
    }

    public void setDrops(String drops) {
        this.drops = drops;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    @Override
    public String toString() {
        return ID;
    }
    public Monster makeMonster(String ID) {
        switch(ID) {
            case "M1":
                return new Monster(300, 300, 60, 80, "M1", 40, "Banshee", 85,
                        "You hear an ominous wail from a woman in an all-white dress. She ap-pears to be on her knees combing her silky hair", 10, "", 100);
            case "M2":
                return new Monster(200, 200, 55, 75, "M2", 35, "Necromancer", 71,
                        "You encounter a woman in a purple dress. She glows a purple aura around her. It looks as if she controls the dead around her.", 30, "", 75);
            case "M3":
                return new Monster(125, 125, 50, 60, "M3", 25, "Lich", 55,
                        "You see a glowing skeleton with a body full of armor. Its eyes appear to glow blue from underneath its murmillo helmet. It appears to be protecting a black leather box hanging on its neck.", 40,"", 60 );
            case "M4":
                return new Monster(100, 100, 40, 50, "M4", 20, "Shadow Person", 30,
                        "You sense a presence of a malicious entity, with a smell of sulfur.", 100, "", 50);
            case "M5":
                return new Monster(100, 100, 40, 60, "M5", 20, "Vampire", 50,
                        "You encounter a bat, that morphed into a human figure, with sharp incisors. He appears to be bloodthirsty. Does not sparkle.", 50, "A7,A8",20);
            case "M6":
                return new Monster(75, 75, 33, 35, "M6", 15, "Skeleton", 25,
                        "You see bones on the floor that sprawl up to form a full skeleton with glowing red eyes", 70, "", 15);
            case "M7":
                return new Monster(75, 75, 37, 50, "M7", 15, "Zombie", 20,
                        "You smell the dead flesh of the undead. It appears to have a missing limb.",70, "A2", 10);
            case "M8":
                return new Monster(75, 75, 25, 50, "M8", 15, "Prisoner", 20,
                        "You see a loose prisoner with shackles on his limbs. It looks as if he is hungry", 70, "A5", 10);
            case "M9":
                return new Monster(50, 50, 25, 40, "M9", 10, "Giant Rat", 35,
                        "You see a loose prisoner with shackles on his limbs. It looks as if he is hungry", 80, "", 5);
            default:
                return new Monster(0,0,0,0,"ERROR",0,"MMERROR",0,"ERROR", 0,"ERROR", 0);
        }

    }


    public int attack(int health, int currentHealth, int speed, boolean didHit, int attack) {
        if(determineFirstAttack(speed)) {  //if Player strikes first
            if (didHit) {   //if player hits
                takeDamage(attack);                 //monster takes damage
                if (this.currentHealth > 0) {       //if monster is still alive
                    if (monAttackHit()) {               //if monster hits
                        return this.attack;                  //return monster damage to player
                    }else{
                        return 0;                       //else return no damage
                    }
                }else{
                    return 0;                       //else return no damage
                }
            }else {                             //else if the player misses
                if (monAttackHit()) {               //if monster hits
                    return this.attack;                //monster returns attack damage
                }else {                             //else
                    return 0;                           //return no damage
                }
            }
        }else{                            //Else monster strike first
            int pHP = currentHealth;
            if (monAttackHit()) {           //if mosnter hits
                pHP -= this.attack;         //calculate player health after attack
                if (pHP > 0) {                          //if player would still be alive
                    if (didHit) {       //if player hits
                        takeDamage(attack);                     //monster takes damage,
                    }                                       //else the monster takes no damage
                    return attack;                          //monster returns damage,
                }else{                                  //else if player would dies
                    return attack;                          //monster returns damage
                }
            }else {                         //else monster misses
                if (didHit) { //if player hits
                    takeDamage(attack);                 //monster takes damage
                }
            }

        }
        return 0;
    }


    public boolean determineFirstAttack(int playerSpeed) {
        //True means player goes first, false means monster
        return playerSpeed > speed;
    }
    public boolean playerAttackHit(int playerAcc) {
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

    public boolean spawnMonster() {
        int rand = (int)(Math.random() * 101);
        return rand > probability;

    }
}