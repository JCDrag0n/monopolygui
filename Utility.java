public class Utility implements Space{
	private String name;
	private Player owner;
	private boolean isMortgaged;
	private int xCo;
	private int yCo;
	public static final int mortgage = 75;
	public static final int cost = 150;
	public Utility(String utilName, int x, int y)
	{
		name = utilName;
		xCo = x;
		yCo = y;
	}
	public String getName()
	{
		return name;
	}
	public String getColor()
	{
		return null;
	}
	public Player getOwner()
	{
		return owner;
	}
	
	public void setOwner(Player p)
	{
		owner.getProperties().remove(this.getName());
		owner = p;
		p.getProperties().add(this.getName());
	}
	
	public void buy(Player p)
	{

		owner = p;
		p.getProperties().add(this.getName());
		p.changeMoney(0 - cost);
	}
	public void payRent(Player p)
	{
		if (!(owner == null) && !(p == owner) && !isMortgaged)
		{
			if (owner.getUtilities() == 2)
			{
				p.changeMoney(0 - p.lastRoll() * 10);
				owner.changeMoney(p.lastRoll() * 10);
			}
			else
			{
				p.changeMoney(0 - p.lastRoll() * 4);
				owner.changeMoney(p.lastRoll() * 4);
			}
}
	}
	public void mortgage()
	{
		if (!isMortgaged)
		{
			isMortgaged = true;
			owner.changeMoney(mortgage);
			GameHandler.getLog().append("\n" + owner.getName() + " has mortgaged " + this.getName() + "\n");
		}
	}
	public void unmortgage()
	{
		if (isMortgaged)
		{
			isMortgaged = false;
			owner.changeMoney(0 - (int) (mortgage * 1.1));
			GameHandler.getLog().append("\n" + owner.getName() + "has unmortgaged " + this.getName() + "\n");
		}
	}
	
	public int getX()
	{
		return xCo;
	}
	
	public int getY()
	{
		return yCo;
	}
	
	public boolean getMortgageState()
	{
		return isMortgaged;
	}
	
	public void setMortgageState(boolean set)
	{
		isMortgaged = set;
	}
	
	public void ownerNulled()
	{
		owner = null;
	}
	
	public void addHouse() {}
	public void removeHouse() {}
	public void ownerNull() {}
}