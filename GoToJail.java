
public class GoToJail implements Space {
	public GoToJail()
	{
		
	}
	public String getName()
	{
		return "Go To Jail";
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return null;
	}
	public void buy(Player p) {}
	public void payRent(Player p)
	{
		p.goToJail();
	}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
