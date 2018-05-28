import java.util.ArrayList;
public class Chance implements Space{
	private static String chanceString;
	private int xCo;
	private int yCo;
	
	public Chance(int x, int y)
	{
		xCo = x;
		yCo = y;
	}
	public String getName()
	{
		return "Chance";
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
		int ran = (int) (Math.random() * 16);
		if (ran == 0)
        {
			chanceString = "Advance to Go!";
            p.moveTo(0);
            InitBoard.getSpaces().get(0).payRent(p);
            p.changeMoney(200);
        }
        if (ran == 1)
        {
        	chanceString = "Advance to Illinois Ave.";
        	int loc = p.getPos();
            p.moveTo(24);
            if (loc > 24)
            {
            	p.changeMoney(200);
            }
            if (InitBoard.getSpaces().get(24).getOwner() != p)
        	{
        		if(InitBoard.getSpaces().get(24).getOwner() == null)
        		{
        			GameHandler.getBuy().setEnabled(true);
        		}
        		else
        		{
        			InitBoard.getSpaces().get(24).payRent(p);
        		}
        	}
        }
        if (ran == 2)
        {
        	chanceString = "Advance to St. Charles Place.";
        	int loc = p.getPos();
        	 p.moveTo(11); 
        	if (loc > 11)
        	{
        		p.changeMoney(200);
        	}
        	if (InitBoard.getSpaces().get(11).getOwner() != p)
        	{
        		if(InitBoard.getSpaces().get(11).getOwner() == null)
        		{
        			GameHandler.getBuy().setEnabled(true);
        		}
        		else
        		{
        			InitBoard.getSpaces().get(11).payRent(p);
        		}
        	}
            
        }
        if (ran == 3)
        {
        	chanceString = "Advance to the nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
        	int loc = p.getPos();
        	if (p.getPos() < 12 || p.getPos() > 28)
        	{
        		p.moveTo(12);
        		if (loc > 28)
        		{
        			p.changeMoney(200);
        		}
        	    if (InitBoard.getSpaces().get(12).getOwner() != null && InitBoard.getSpaces().get(12).getOwner() != p)
        	    {
        	        int i = p.roll();
        	        p.changeMoney(0 - i * 10);
        	        InitBoard.getSpaces().get(12).getOwner().changeMoney(i * 10);
        	    }
        	    else if (InitBoard.getSpaces().get(12).getOwner() == null)
        	    {
        	    	GameHandler.getBuy().setEnabled(true);
        	    }
        	 }
        	        
        	 else
        	 {
        	     p.moveTo(28);
        	     if (InitBoard.getSpaces().get(28).getOwner() != null && InitBoard.getSpaces().get(28).getOwner() != p)
        	     {
        	         int i = p.roll();
        	         p.changeMoney(0 - i * 10);
        	         InitBoard.getSpaces().get(28).getOwner().changeMoney(i * 10);
        	      }
        	  }
        	             	// go to  closest utility,  if owned, pay ten  times dice roll
        }
        if (ran == 4)
        {
        	chanceString = "Advance to the nearest Railroad and pay the owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.";
            if (p.getPos() < 5) 
            {
            	p.moveTo(5);
            	if (InitBoard.getSpaces().get(5).getOwner() != p)
            	{
            		if(InitBoard.getSpaces().get(5).getOwner() == null)
            		{
            			GameHandler.getBuy().setEnabled(true);
            		}
            		else
            		{
            			InitBoard.getSpaces().get(5).payRent(p);
            			InitBoard.getSpaces().get(5).payRent(p);
            		}
            	}
            }
            else if (p.getPos() < 15) 
            {
            	p.moveTo(15);
            	if (InitBoard.getSpaces().get(15).getOwner() != p)
            	{
            		if(InitBoard.getSpaces().get(15).getOwner() == null)
            		{
            			GameHandler.getBuy().setEnabled(true);
            		}
            		else
            		{
            			InitBoard.getSpaces().get(15).payRent(p);
            			InitBoard.getSpaces().get(15).payRent(p);
            		}
            	}
            }
            else if (p.getPos() < 25)
            {
            	p.moveTo(25);
            	if (InitBoard.getSpaces().get(25).getOwner() != p)
            	{
            		if(InitBoard.getSpaces().get(25).getOwner() == null)
            		{
            			GameHandler.getBuy().setEnabled(true);
            		}
            		else
            		{
            			InitBoard.getSpaces().get(25).payRent(p);
            			InitBoard.getSpaces().get(25).payRent(p);
            		}
            	}
            }
            else if (p.getPos() < 35) 
            {
            	p.moveTo(35);
            	if (InitBoard.getSpaces().get(35).getOwner() != p)
            	{
            		if(InitBoard.getSpaces().get(35).getOwner() == null)
            		{
            			GameHandler.getBuy().setEnabled(true);
            		}
            		else
            		{
            			InitBoard.getSpaces().get(35).payRent(p);
            			InitBoard.getSpaces().get(35).payRent(p);
            		}
            	}
            }
            else 
            {
            	p.moveTo(5);
            	p.changeMoney(200);
            	if (InitBoard.getSpaces().get(5).getOwner() != p)
            	{
            		if(InitBoard.getSpaces().get(5).getOwner() == null)
            		{
            			GameHandler.getBuy().setEnabled(true);
            		}
            		else
            		{
            			InitBoard.getSpaces().get(5).payRent(p);
            			InitBoard.getSpaces().get(5).payRent(p);
            		}
            	}
            }
        }
        if (ran == 5)
        {
        	chanceString = "Bank pays you dividend of $50.";
            p.changeMoney(50);
        }
        if (ran == 6)
        {
        	chanceString = "Get Out Of Jail Free -- This card may be kept until needed.";
            p.drawGetOutCard();
        }
        if (ran == 7)
        {
        	chanceString = "Go Back 3 Spaces";
            p.moveTo(p.getPos() - 3);
            InitBoard.getSpaces().get(p.getPos()).payRent(p);
        }
        if (ran == 8)
        {
        	chanceString = "Go To Jail -- Go Directly To Jail -- Do not pass Go, do not collect $200.";
            p.goToJail();
        }
        if (ran == 9)
        {
        	chanceString = "Make general repairs on all your property -- For each house pay $25 -- For each hotel pay $100.";
        	int i = 0;
        	i += p.getHouses() * 25;
        	i += p.getHotels() * 100;
            p.changeMoney(0-i);
        }
        if (ran == 10)
        {
        	chanceString = "Pay poor tax of $15.";
            p.changeMoney(0-15);
        }
        if (ran == 11)
        {
        	chanceString = "Take a trip to Reading Railroad -- If you pass Go, collect $200.";
        	int loc = p.getPos();
            p.moveTo(5);
            if (loc > 5) {p.changeMoney(200);}
            if (InitBoard.getSpaces().get(5).getOwner() != p)
        	{
        		if(InitBoard.getSpaces().get(5).getOwner() == null)
        		{
        			GameHandler.getBuy().setEnabled(true);
        		}
        		else
        		{
        			InitBoard.getSpaces().get(5).payRent(p);
        		}
        	}
        }
        if (ran == 12)
        {
        	chanceString = "Advance to Boardwalk.";
            p.moveTo(39);
            if (InitBoard.getSpaces().get(39).getOwner() != p)
        	{
        		if(InitBoard.getSpaces().get(39).getOwner() == null)
        		{
        			GameHandler.getBuy().setEnabled(true);
        		}
        		else
        		{
        			InitBoard.getSpaces().get(39).payRent(p);
        		}
        	}
        }
        if (ran == 13)
        {
        	chanceString = "You have been elected Chairman of the Board -- Pay each $50";
            p.changeMoney(0-150);
            ArrayList<Player> temp = InitBoard.getPlayers();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(50);}
            }
        }
        if (ran == 14)
        {
        	chanceString = "Your building and loan matures -- Collect $150.";
            p.changeMoney(150);
        }
        if (ran == 15)
        {
        	chanceString = "You have won a crossword competition -- Collect $100.";
            p.changeMoney(100);
        }
	}
	
	public static String returnString()
	{
		return chanceString;
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
