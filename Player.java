import java.util.ArrayList;

import javax.swing.JTextArea;

public class Player {

	private String name;
	private int location;
	private int money;
	private boolean isInJail;
	private int jailTurns;
	private int railroadCount;
	private int utilitiesCount;
	private int lastRoll;
	private int numGetOutCards;
	private int houses;
	private int hotels;
	private boolean isBankrupt;
	private ArrayList<String> properties;
	private static JTextArea log;
	
	public Player(String n)
	{
		name = n;
		location = 0;
		money = 1500;
		properties = new ArrayList<String>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<String> getProperties()
	{
		return properties;
	}
	public void changeMoney(int n)
	{
		money += n;
		log.append(this.getName() + " now has " + this.getMoney() + " dollars following a change of " + n + "\n\n");
	}
	public int getMoney()
	{
		return money;
	}
	public int getPos()
	{
		return location;
	}
	
	public void turn()
	{
		
	}
	
	public void jailTurn() {
		
	}
	
	public void moveTo(int n)
	{
		location = n;
		log.append(this.getName() + " moved to " + InitBoard.getSpaces().get(location).getName() + "\n\n");
	}
	public int roll()
	{
		int i = (int) (Math.random() * 6) + 1;
		int j = (int) (Math.random() * 6) + 1;
		return i + j;
	}
	
	public void goToJail()
	{
		isInJail = true;
		moveTo(10);
		jailTurns = 0;
	}
	
	public boolean hasMonopoly(String color)
	{
		int colorCount = 0;
		int ownedCount = 0;
		for (int i = 0; i < 40; i++)
		{
			String propColor = InitBoard.getSpaces().get(i).getColor();
			Player owner = InitBoard.getSpaces().get(i).getOwner();
			if (propColor != null && propColor.equals(color))
			{
				colorCount++;
				if (owner != null && owner.equals(this))
				{
					ownedCount++;
				}
			}
		}
		if (colorCount == ownedCount)
		{
			return true;
		}
		return false;
	}
	
	public void drawGetOutCard() {
	    if (numGetOutCards < 2) {
	      numGetOutCards++;
	    }
	}
	
	public boolean getBankrupt()
	{
		return isBankrupt;
	}
	
	public static void receiveLog(JTextArea area) { log = area; }
	public int lastRoll() {return lastRoll;}
	public void addRailroad() {railroadCount++;}
	public void removeRailroad() {railroadCount--;}
	public int getRailroad() {return railroadCount;}
	public void addUtility() {utilitiesCount++;}
	public void removeUtility() {utilitiesCount--;}
	public int getUtilities() {return utilitiesCount;}
	public void changeHouses(int n) {houses += n;}
	public void changeHotel(int n) {hotels += n;}
	public int getHouses() {return houses;}
	public int getHotels() {return hotels;}
	public boolean getJailStatus() {return isInJail;}
	public int getJailTurns() {return jailTurns;}
}
