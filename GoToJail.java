
public class GoToJail implements Space {
	private int xCo;
	private int yCo;
	public GoToJail(int x, int y)
	{
		xCo = x;
		yCo = y;
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
	public int getX()
	{
		return xCo;
	}
	public int getY()
	{
		return yCo;
	}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
