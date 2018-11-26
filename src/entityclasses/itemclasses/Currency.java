package TeenTitians.src.entityclasses.itemclasses;

import TeenTitians.src.entityclasses.itemclasses.Item;
//Currency class by Austin
public class Currency extends Item
{
public int gold;


public Currency(String name, String ID, String description, int gold) {
	super(name, ID, description, gold);
	this.gold= gold;
}
public double spendGold(double itemPrice)
{
	double goldLeft = itemPrice - gold;
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
	double totalGold = goldPiece + gold;
	return totalGold;
}
}
