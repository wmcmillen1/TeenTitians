package TeenTitians.src.entityclasses.itemclasses;
//Consumable class by Clyde
public class Consumable extends Item
{
	/**
	private String [] healing = {"A1 Sauce", "Steak", "A1 Steak", "Rotten Apple","Apple", "Watermelon")
Consumable health = new Consumble();
ArrayList<String> healing = new ArrayList<String>();
healing.addAll(Arrays.asList(healing));
**/
	private int recoverHealth;
	private int defenceGain;
	private int accGain;

	public Consumable() {

    }

	public Consumable(String name, String ID, String description, int goldValue, int recoverHealth, int defenceGain, int accGain) {
		super(name,ID, description, goldValue);
		this.recoverHealth = recoverHealth;
		this.defenceGain = defenceGain;
		this.accGain = accGain;
	}
	public int getRecoverHealth() {
	    return recoverHealth;
    }
	public void setRecoverHealth(int recoverHealth) {
	    this.recoverHealth = recoverHealth;
    }

    public int getDefenceGain() {
        return defenceGain;
    }

    public void setDefenceGain(int defenceGain) {
        this.defenceGain = defenceGain;
    }

    public int getAccGain() {
        return accGain;
    }

    public void setAccGain(int accGain) {
        this.accGain = accGain;
    }

    public int Heal() {
		return recoverHealth;
	}
}
