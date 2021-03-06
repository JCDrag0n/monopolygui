import java.util.Scanner;
public class Railroad implements Space {
	private String name;
	private Player owner;
	private boolean isMortgaged;
	private static final int mortgage = 100;
	private static final int cost = 200;
	private int xCo;
	private int yCo;
	public Railroad(String railName, int x, int y)
	{
		name = railName;
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
		 if (owner.getRailroad() == 1)
		 {
			 p.changeMoney(0-25);
			 owner.changeMoney(25);
		 }
		 else if (owner.getRailroad() == 2)
		 {
			 p.changeMoney(0-50);
			 owner.changeMoney(50);
		 }
		 else if (owner.getRailroad() == 3)
		 {
			 p.changeMoney(0-100);
			 owner.changeMoney(100);
		 }
		 else 
		 {
			 p.changeMoney(0-200);
			 owner.changeMoney(200);
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
			  GameHandler.getLog().append("\n" + owner.getName() + " has unmortgaged " + this.getName() + "\n");
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
	  public void addHouse() {}
	  public void removeHouse() {}
	  public void ownerNull() {}
	  
	  public void ownerNulled()
		{
			owner = null;
		}
}
