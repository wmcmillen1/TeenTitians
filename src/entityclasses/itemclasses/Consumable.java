package TeenTitians.src.entityclasses.itemclasses;
//Consumable class by Clyde
public class Consumable
{
	/**
	private String [] healing = {"A1 Sauce", "Steak", "A1 Steak", "Rotten Apple","Apple", "Watermelon")
Consumable health = new Consumble();
ArrayList<String> healing = new ArrayList<String>();
healing.addAll(Arrays.asList(healing));
**/
	private int recoverHealth;
	
	public Consumable()
{
	int recoverHealth = 0;
} 	
	public Consumable(int recoverHealth)
{
	this.recoverHealth = recoverHealth;
}
	public int getRecoverHealth() {
	return recoverHealth;
}
	public void setRecoverHealth(int recoverHealth) {
	this.recoverHealth = recoverHealth;
}

	public int Heal(boolean useConsumable, int HP)
{
	if(useConsumable == true)
		recoverHealth =  HP + 20;
	return recoverHealth ;
}
}
