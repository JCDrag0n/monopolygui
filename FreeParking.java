
public class FreeParking implements Space {
	private static int money;
	private int xCo;
	private int yCo;
	public FreeParking(int x, int y)
	{
		xCo = x;
		yCo = y;
		money = 100;
	}
	public String getName()
	{
		return "Free Parking";
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return null;
	}
	public void payRent(Player p)
	{
		p.changeMoney(money);
		money = 100;
	}
	public static void changeMoney(int in)
	{
		money += in;
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
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
	public void setOwner(Player p) {}
}
