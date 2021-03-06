import java.util.ArrayList;

public class CommunityChest implements Space {
	
	private static String chestString;
	private int xCo;
	private int yCo;
	
	public CommunityChest(int x, int y)
	{
		xCo = x;
		yCo = y;
	}
	public String getName()
	{
		return "Community Chest";
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
        	chestString = "Advance to Go (Collect $200).";
        	p.moveTo(0);
        	p.changeMoney(200);
        }
        if (ran == 1)
        {
        	chestString = "Bank error in your favor -- Collect $200.";
        	p.changeMoney(200);  
        }
        if (ran == 2)
        {
        	chestString = "Doctor's fees -- Pay $50.";
        	p.changeMoney(0-50);
        }
        if (ran == 3)
        {
        	chestString = "Get Out Of Jail Free -- This card may be kept until needed.";
        	p.drawGetOutCard();
        }
        if (ran == 4)
        {
        	chestString = "Go To Jail -- Go Directly To Jail -- Do not pass Go -- Do not collect $200.";
        	p.goToJail();
        }
        if (ran == 5)
        {
        	chestString = "Grand Opera Night -- Collect $50 from every player for opening night seats.";
        	p.changeMoney(150);
        	ArrayList<Player> temp = InitBoard.getPlayers();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(0 - 50);}
            }
        }
        if (ran == 6)
        {
        	chestString = "Xmas Fund matures -- Collect $100.";
        	p.changeMoney(100);
        }
        if (ran == 7)
        {
        	chestString = "Income Tax Refund -- Collect $20.";
        	p.changeMoney(20);
        }
        if (ran == 8)
        {
        	chestString = "Life Insurance Matures -- Collect $100.";
        	p.changeMoney(100);
        }
        if (ran == 9)
        {
        	chestString = "You are assessed for street repairs -- $40 per house -- $115 per hotel.";
        	p.changeMoney(0-40*p.getHouses());
        	p.changeMoney(0-115*p.getHotels());
        }
        if (ran == 10)
        {
        	chestString = "Pay hospital fees of $100.";
        	p.changeMoney(0-100); 
        }
        if (ran == 11)
        {
        	chestString = "Pay school fees of $150.";
        	p.changeMoney(0-150);
        }
        if (ran == 12)
        {
        	chestString = "Receive $25 consultancy fee.";
          p.changeMoney(25);
        }
        if (ran == 13)
        {
        	chestString = "You have won second prize in a beauty contest -- Collect $10.";
        	p.changeMoney(10);
        }
        if (ran == 14)
        {
        	chestString = "You inherit $100.";
        	p.changeMoney(100);
        }
        if (ran == 15)
        {
        	chestString = "From sale of stock you get $50.";
        	p.changeMoney(50);
        }
	}
	
	public static String returnString() {
		return chestString;
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
