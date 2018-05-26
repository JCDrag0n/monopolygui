import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GameHandler {
	
	private CardSwitcher source;
	private static ArrayList<Player> playerList;
	private static JTextArea log;
	private static boolean alreadyRolled = false;
	private static int whoseTurn = 0;
	private static int numofPlayers;
	
	private static int doubleCount;
	
	private static boolean isinJail;
	private static int jailTurns;
	private static int lastRoll;
	private static int location;
	
	private static JButton roll;
	private static JButton buy;
	private static JButton endTurn;
	private static JButton chance;
	private static JButton community;
	
	private static String chanceString;
	private static String chestString;

	public GameHandler(String p1, String p2, String p3, String p4, CardSwitcher source, int num)
	{
		source.switchTo(Sandbox.GAMEPANEL);
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(p1);
		nameList.add(p2);
		nameList.add(p3);
		nameList.add(p4);
		playerList = new ArrayList<Player>();
		for (int i = 0; i < num; i++)
		{
			playerList.add(new Player(nameList.get(i)));
		}
		numofPlayers = num;
		startGame();
	}
	
	public void startGame()
	{
		ArrayList<Space> spaces = new ArrayList<Space>();
        spaces.add(new Go());
        spaces.add(new Property("Mediterranean Avenue", "Brown", 60, 2, 4, 10, 30, 90, 160, 250, 50, 30));
        spaces.add(new CommunityChest());
        spaces.add(new Property("Baltic Avenue", "Brown", 60, 4, 8, 20, 60, 180, 320, 450, 50, 30));
        spaces.add(new Tax("Income Tax", 200));
        spaces.add(new Railroad("Reading Railroad"));
        spaces.add(new Property("Oriental Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
        spaces.add(new Chance());
        spaces.add(new Property("Vermont Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
        spaces.add(new Property("Connecticut Avenue", "Light Blue", 120, 8, 16, 40, 100, 300, 450, 600, 50, 60));
        spaces.add(new Jail());
        spaces.add(new Property("St. Charles Place", "Pink", 140, 10, 20, 50, 150, 450, 625, 750, 100, 70));
        spaces.add(new Utility("Electric Company"));
        spaces.add(new Property("States Avenue", "Pink", 140, 10, 20, 50, 150, 450, 625, 750, 100, 70));
        spaces.add(new Property("Virginia Avenue", "Pink", 60, 12, 24, 60, 180, 500, 700, 900, 100, 80));
        spaces.add(new Railroad("Pennsylvania Railroad"));
        spaces.add(new Property("St. James Place", "Orange", 180, 14, 28, 70, 200, 550, 750, 950, 100, 90));
        spaces.add(new CommunityChest());
        spaces.add(new Property("Tennessee Avenue", "Orange", 180, 14, 28, 70, 200, 550, 750, 950, 100, 90));
        spaces.add(new Property("New York Avenue", "Orange", 200, 16, 32, 80, 220, 600, 800, 1000, 100, 100));
        spaces.add(new FreeParking());
        spaces.add(new Property("Kentucky Avenue", "Red", 220, 18, 36, 90, 250, 700, 875, 1050, 150, 110));
        spaces.add(new Chance());
        spaces.add(new Property("Indiana Avenue", "Red", 220, 18, 36, 90, 250, 700, 875, 1050, 150, 110));
        spaces.add(new Property("Illinois Avenue", "Red", 240, 20, 40, 100, 300, 750, 925, 1100, 150, 120));
        spaces.add(new Railroad("B. & O. RailRoad"));
        spaces.add(new Property("Atlantic Avenue", "Yellow", 260, 22, 44, 110, 330, 800, 975, 1150, 150, 130));
        spaces.add(new Property("Ventnor Avenue", "Yellow", 260, 22, 44, 110, 330, 800, 975, 1150, 150, 130));
        spaces.add(new Utility("Water Works"));
        spaces.add(new Property("Marvin Gardens", "Yellow", 280, 24, 48, 120, 360, 850, 1025, 1200, 150, 140));
        spaces.add(new GoToJail());
        spaces.add(new Property("Pacific Avenue", "Green", 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 150));
        spaces.add(new Property("North Carolina Avenue", "Green", 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 150));
        spaces.add(new CommunityChest());
        spaces.add(new Property("Pennsylvania Avenue", "Green", 320, 28, 56, 150, 450, 1000, 1200, 1400, 200, 160));
        spaces.add(new Railroad("Short Line"));
        spaces.add(new Chance());
        spaces.add(new Property("Park Place", "Blue", 350, 35, 70, 175, 500, 1100, 1300, 1500, 200, 175));
        spaces.add(new Tax("Luxury Tax", 75));
        spaces.add(new Property("Boardwalk", "Blue", 400, 50, 100, 200, 600, 1400, 1700, 2000, 200, 200));
        InitBoard board = new InitBoard(spaces, playerList);
        Player current = playerList.get(whoseTurn);
		
        log.append("Welcome to Monopoly!\n\n");
        log.append("\n\n" + current.getName() + "'s turn.");
        
	}
	
	public static void turnHandler()
	{
		if (whoseTurn == numofPlayers)
		{
			whoseTurn = 0;
		}
	}
	
	public static void startTurn()
	{
		buy.setEnabled(false);
		endTurn.setEnabled(false);
		roll.setEnabled(true);
		Player current = playerList.get(whoseTurn);
		log.append("\n\n" + current.getName() + "'s turn.");
		if (InitBoard.getSpaces().get(location).getOwner() !=null)
		{
			buy.setEnabled(false);
		}
		if (current.getMoney() < 0 && !current.getBankrupt())
		{
			log.append("You are in debt! You can declare bankruptcy (END TURN), sell houses, or mortgage properties\n");
			buy.setEnabled(false);
			roll.setEnabled(false);
		}
		
		if (current.getJailStatus())
		{
			if(current.getJailTurns() == 3)
			{
				current.changeMoney(0 - 50);
			}
			else {
				
			}
		}
		else {
			roll.setEnabled(true);
		}
		
	}
	
	public static void endTurn()
	{
		Player current = playerList.get(whoseTurn);
		if (current.getMoney() < 0)
		{
			log.append(current.getName() + " is bankrupt!\n\n");
			//remove all houses/hotels, set all related properties to null
		}
		whoseTurn++;
		turnHandler();
		startTurn();
		doubleCount = 0;
	}
	
	
	public static void buy()
	{
		Player current = playerList.get(whoseTurn);
		InitBoard.getSpaces().get(location).buy(current);
		log.append(current.getName() + " has purchased " + InitBoard.getSpaces().get(location).getName() + "\n\n");
		buy.setEnabled(false);
	}
	
	
	
	public static void roll()
	{
		Player current = playerList.get(whoseTurn);
		int i = (int) (Math.random() * 6) + 1;
		int j = (int) (Math.random() * 6) + 1;
		lastRoll = i+j;
		log.append(current.getName() + " has rolled a " + i + " and " + j + ", totalling " + lastRoll +"\n\n");
		
		location = current.getPos() + i + j;
		if (location + i + j >= 40)
		{	
			location = (location + i + j) % 40;
			current.changeMoney(200);
		}
		
		if (doubleCount == 0)
		{
			roll.setEnabled(false);
			buy.setEnabled(true);
			endTurn.setEnabled(true);
		}
		else if (doubleCount == 3)
		{
			current.goToJail();
			roll.setEnabled(false);
			endTurn();
			//gotoJail code
		}
		else {
			roll.setEnabled(true);
			buy.setEnabled(true);
		}
		if (i == j)
		{
			doubleCount++;
			roll.setEnabled(true);
			endTurn.setEnabled(false);
		}
		else 
		{
			endTurn.setEnabled(true);
			roll.setEnabled(false);
		}
		
		current.moveTo(location);
		
		if ((InitBoard.getSpaces().get(location) instanceof Chance))
		{
			if (!(InitBoard.getSpaces().get(location) instanceof Property) && !(InitBoard.getSpaces().get(location) instanceof Railroad) && !(InitBoard.getSpaces().get(location) instanceof Utility) )
			{
				buy.setEnabled(false);
				InitBoard.getSpaces().get(location).payRent(current);
			}
			else if (InitBoard.getSpaces().get(location).getOwner() == null)
			{
				buy.setEnabled(true);
			}
			else if (InitBoard.getSpaces().get(location).getOwner() == current)
			{
				buy.setEnabled(false);
			}
			else {
				buy.setEnabled(false);
				InitBoard.getSpaces().get(location).payRent(current);
			}
			chance.doClick();
		}
		if ((InitBoard.getSpaces().get(location) instanceof CommunityChest))
		{
			if (!(InitBoard.getSpaces().get(location) instanceof Property) && !(InitBoard.getSpaces().get(location) instanceof Railroad) && !(InitBoard.getSpaces().get(location) instanceof Utility) )
			{
				buy.setEnabled(false);
				InitBoard.getSpaces().get(location).payRent(current);
			}
			else if (InitBoard.getSpaces().get(location).getOwner() == null)
			{
				buy.setEnabled(true);
			}
			else if (InitBoard.getSpaces().get(location).getOwner() == current)
			{
				buy.setEnabled(false);
			}
			else {
				buy.setEnabled(false);
				InitBoard.getSpaces().get(location).payRent(current);
			}
			community.doClick();
		}
		if (!(InitBoard.getSpaces().get(location) instanceof Property) && !(InitBoard.getSpaces().get(location) instanceof Railroad) && !(InitBoard.getSpaces().get(location) instanceof Utility) )
		{
			buy.setEnabled(false);
			InitBoard.getSpaces().get(location).payRent(current);
		}
		else if (InitBoard.getSpaces().get(location).getOwner() == null)
		{
			buy.setEnabled(true);
		}
		else if (InitBoard.getSpaces().get(location).getOwner() == current)
		{
			buy.setEnabled(false);
		}
		else {
			buy.setEnabled(false);
			InitBoard.getSpaces().get(location).payRent(current);
		}
		//icon move code	
		
	}
	
	public static boolean getRollStatus()
	{
		return alreadyRolled;
	}
	
	public static Player getPlayer()
	{
		return playerList.get(whoseTurn);
	}
	
	public static Player getNextPlayer()
	{
		if (whoseTurn + 1 == numofPlayers) {
			return playerList.get(0);
		}
		else {
		return playerList.get(whoseTurn + 1);
		}
	}
	
	public static String getChance()
	{
		return chanceString;
	}
	
	public static String getCommunity()
	{
		return chestString;
	}
	
	public static void receiveLog(JTextArea area)
	{
		log = area;
	}
	
	public static void receiveRoll(JButton rollB)
	{
		roll = rollB;
	}
	
	public static void receiveBuy(JButton buyB)
	{
		buy = buyB;
	}
	
	public static void receiveEndTurn(JButton endTurnB)
	{
		endTurn = endTurnB;
	}
	
	public static void receiveChance(JButton chanceB)
	{
		chance = chanceB;
	}
	
	public static void receiveCommunity(JButton chestB) 
	{
		community = chestB;
	}
	

}
