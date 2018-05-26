import java.util.ArrayList;

public class CommunityChest implements Space {
	
	private String chestString;
	
	public CommunityChest()
	{
		
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
        	chestString = "Community Chest Card: Advance to Go (Collect $200).";
        	p.moveTo(0);
        }
        if (ran == 1)
        {
        	chestString = "Community Chest Card: Bank error in your favor -- Collect $200.";
        	p.changeMoney(200);  
        }
        if (ran == 2)
        {
        	chestString = "Community Chest Card: Doctor's fees -- Pay $50.";
        	p.changeMoney(0-50);
        }
        if (ran == 3)
        {
        	chestString = "Community Chest Card: Get Out Of Jail Free -- This card may be kept until needed.";
        	p.drawGetOutCard();
        }
        if (ran == 4)
        {
        	chestString = "Community Chest Card: Go To Jail -- Go Directly To Jail -- Do not pass Go -- Do not collect $200.";
        	p.goToJail();
        }
        if (ran == 5)
        {
        	chestString = "Community Chest Card: Grand Opera Night -- Collect $50 from every player for opening night seats.";
        	p.changeMoney(150);
        	ArrayList<Player> temp = InitBoard.getPlayers();
            for (int i = 0; i < temp.size(); i++)
            {
            	if (!(temp.get(i).equals(p))) {temp.get(i).changeMoney(0 - 50);}
            }
        }
        if (ran == 6)
        {
        	chestString = "Community Chest Card: Xmas Fund matures -- Collect $100.";
        	p.changeMoney(100);
        }
        if (ran == 7)
        {
        	chestString = "Community Chest Card: Income Tax Refund -- Collect $20.";
        	p.changeMoney(20);
        }
        if (ran == 8)
        {
        	chestString = "Community Chest Card: Life Insurance Matures -- Collect $100.";
        	p.changeMoney(100);
        }
        if (ran == 9)
        {
        	chestString = "Community Chest Card: You are assessed for street repairs -- $40 per house -- $115 per hotel.";
        	p.changeMoney(0-40*p.getHouses());
        	p.changeMoney(0-115*p.getHotels());
        }
        if (ran == 10)
        {
        	chestString = "Community Chest Card: Pay hospital fees of $100.";
        	p.changeMoney(0-100); 
        }
        if (ran == 11)
        {
        	chestString = "Community Chest Card: Pay school fees of $150.";
        	p.changeMoney(0-150);
        }
        if (ran == 12)
        {
        	chestString = "Community Chest Card: Receive $25 consultancy fee.";
          p.changeMoney(25);
        }
        if (ran == 13)
        {
        	chestString = "Community Chest Card: You have won second prize in a beauty contest -- Collect $10.";
        	p.changeMoney(10);
        }
        if (ran == 14)
        {
        	chestString = "Community Chest Card: You inherit $100.";
        	p.changeMoney(100);
        }
        if (ran == 15)
        {
        	chestString = "Community Chest Card: From sale of stock you get $50.";
        	p.changeMoney(50);
        }
	}
	
	public String returnString() {
		return chestString;
	}
	public void buy(Player p) {}
	public void addHouse() {}
	public void removeHouse() {}
	public void mortgage() {}
	public void unmortgage() {}
	public void ownerNull() {}
}
