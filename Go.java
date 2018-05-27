
public class Go implements Space {
	private int xCo;
	private int yCo;
	
	public Go(int x, int y)
	{
		xCo = x;
		yCo = y;
	}
	public String getColor()
	{
		return null;
	}
	public String getName()
	{
		return "Go!";
	}
	public Player getOwner()
	{
		return null;
	}
	public void act(Player p)
	{
		
	}
	
	public int getX()
	{
		return xCo;
	}
	
	public int getY()
	{
		return yCo;
	}
	public void buy(Player p) {}
	public void payRent(Player p) {}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
