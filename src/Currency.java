
public class Currency extends Item
{
public double Gold;

public Currency()
{
	
	Gold = 0.0;
}

public Currency(double Gold)
{
	this.Gold= Gold;
}
public double spendGold(double itemPrice)
{
	double goldLeft = itemPrice - Gold;
	return goldLeft;
}
/**
 * Method: gainGold
 * This method returns the total amount of gold as the player finds gold.
 * @param goldPiece
 * @return totalGold
 */
public double gainGold(double goldPiece)
{
	double totalGold = goldPiece + Gold;
	return totalGold;
}
}
