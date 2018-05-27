
public class Tax implements Space {
	private String name;
	private int tax;
	private int xCo;
	private int yCo;
	public Tax(String taxName, int taxPrice, int x, int y)
	{
		name = taxName;
		tax = taxPrice;
		xCo = x;
		yCo = y;
	}
	public String getName()
	{
		return name;
	}
	public void buy(Player p) {}
	public void payRent(Player p)
	{
		p.changeMoney(0 - tax);
		FreeParking.changeMoney(tax);
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return null;
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
