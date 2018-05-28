import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	private static JButton useCard;
	private static JButton manage;
	
	private static String chanceString;
	private static String chestString;
	
	private static Player current;
	
	private static JFrame frame;
	private static boolean isReady = false;
	private static ArrayList<Space> spaces;

	public GameHandler(String p1, String p2, String p3, String p4, String p1Token, String p2Token, String p3Token, String p4Token, CardSwitcher source, int num)
	{
		source.switchTo(Sandbox.GAMEPANEL);
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(p1);
		nameList.add(p2);
		nameList.add(p3);
		nameList.add(p4);
		ArrayList<String> tokenList = new ArrayList<String>();
		tokenList.add(p1Token);
		tokenList.add(p2Token);
		tokenList.add(p3Token);
		tokenList.add(p4Token);
		playerList = new ArrayList<Player>();
		for (int i = 0; i < num; i++)
		{
			playerList.add(new Player(nameList.get(i), tokenList.get(i)));
		}
		numofPlayers = num;
		startGame();
	}
	
	public void startGame()
	{
		spaces = new ArrayList<Space>();
        spaces.add(new Go(921, 944));
        spaces.add(new Property("Mediterranean Avenue", "Brown", 60, 2, 4, 10, 30, 90, 160, 250, 50, 30, 824, 958));
        spaces.add(new CommunityChest(742, 958));
        spaces.add(new Property("Baltic Avenue", "Brown", 60, 4, 8, 20, 60, 180, 320, 450, 50, 30, 660, 958));
        spaces.add(new Tax("Income Tax", 200, 578, 958));
        spaces.add(new Railroad("Reading Railroad", 496, 958));
        spaces.add(new Property("Oriental Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50, 414, 958));
        spaces.add(new Chance(332, 958));
        spaces.add(new Property("Vermont Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50, 250, 958));
        spaces.add(new Property("Connecticut Avenue", "Light Blue", 120, 8, 16, 40, 100, 300, 450, 600, 50, 60, 168, 958));
        spaces.add(new Jail(39, 958));
        spaces.add(new Property("St. Charles Place", "Pink", 140, 10, 20, 50, 150, 450, 625, 750, 100, 70, 50, 824));
        spaces.add(new Utility("Electric Company", 50, 742));
        spaces.add(new Property("States Avenue", "Pink", 140, 10, 20, 50, 150, 450, 625, 750, 100, 70, 50, 660));
        spaces.add(new Property("Virginia Avenue", "Pink", 60, 12, 24, 60, 180, 500, 700, 900, 100, 80, 50, 578));
        spaces.add(new Railroad("Pennsylvania Railroad", 50, 496));
        spaces.add(new Property("St. James Place", "Orange", 180, 14, 28, 70, 200, 550, 750, 950, 100, 90, 50, 414));
        spaces.add(new CommunityChest(50, 332));
        spaces.add(new Property("Tennessee Avenue", "Orange", 180, 14, 28, 70, 200, 550, 750, 950, 100, 90, 50, 250));
        spaces.add(new Property("New York Avenue", "Orange", 200, 16, 32, 80, 220, 600, 800, 1000, 100, 100, 50, 168));
        spaces.add(new FreeParking(58, 58));
        spaces.add(new Property("Kentucky Avenue", "Red", 220, 18, 36, 90, 250, 700, 875, 1050, 150, 110, 170, 53));
        spaces.add(new Chance(252, 53));
        spaces.add(new Property("Indiana Avenue", "Red", 220, 18, 36, 90, 250, 700, 875, 1050, 150, 110, 334, 53));
        spaces.add(new Property("Illinois Avenue", "Red", 240, 20, 40, 100, 300, 750, 925, 1100, 150, 120, 416, 53));
        spaces.add(new Railroad("B. & O. RailRoad", 498, 53));
        spaces.add(new Property("Atlantic Avenue", "Yellow", 260, 22, 44, 110, 330, 800, 975, 1150, 150, 130, 580, 53));
        spaces.add(new Property("Ventnor Avenue", "Yellow", 260, 22, 44, 110, 330, 800, 975, 1150, 150, 130, 662, 53));
        spaces.add(new Utility("Water Works", 744, 53));
        spaces.add(new Property("Marvin Gardens", "Yellow", 280, 24, 48, 120, 360, 850, 1025, 1200, 150, 140, 826, 53));
        spaces.add(new GoToJail(935, 53));
        spaces.add(new Property("Pacific Avenue", "Green", 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 150, 943, 167));
        spaces.add(new Property("North Carolina Avenue", "Green", 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 150, 943, 249));
        spaces.add(new CommunityChest(943, 331));
        spaces.add(new Property("Pennsylvania Avenue", "Green", 320, 28, 56, 150, 450, 1000, 1200, 1400, 200, 160, 943, 413));
        spaces.add(new Railroad("Short Line", 943, 495));
        spaces.add(new Chance(943, 577));
        spaces.add(new Property("Park Place", "Blue", 350, 35, 70, 175, 500, 1100, 1300, 1500, 200, 175, 943, 659));
        spaces.add(new Tax("Luxury Tax", 75,  943, 741));
        spaces.add(new Property("Boardwalk", "Blue", 400, 50, 100, 200, 600, 1400, 1700, 2000, 200, 200, 943, 823));
        InitBoard board = new InitBoard(spaces, playerList);
        Player current = playerList.get(whoseTurn);
		isReady = true;
        log.append("Welcome to Monopoly!\n\n");
        log.append(current.getName() + "'s turn.\n");
        
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
		current = playerList.get(whoseTurn);
		if (playerList.size() == 1)
		{
			buy.setEnabled(false);
			manage.setEnabled(false);
			endTurn.setEnabled(false);
			roll.setEnabled(false);
			JOptionPane.showMessageDialog(frame, "Congrats " + current.getName() + " YOU WIN!!!!");
			//log.append("\n\n\n\n\n Congrats " + current.getName() + "! YOU WIN!!!!");
			
		}
		else {
		buy.setEnabled(false);
		endTurn.setEnabled(false);
		roll.setEnabled(true);
		log.append("\n" + current.getName() + "'s turn. \n");
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
				log.append("\n" + current.getName() + " has been in jail for three turns. Fine is now paid. \n\n");
				current.resetJailTurns();
				current.setInJail(false);
				current.changeMoney(0 - 50);
				roll.setEnabled(true);
				buy.setEnabled(false);
				endTurn.setEnabled(false);
			}
			else {
				current.addJailTurn();
				JDialog jailDialog = new JDialog(frame, "JAIL OPTIONS", ModalityType.APPLICATION_MODAL);
				JPanel cardPane = new JPanel();
				JButton pay = new JButton(new AbstractAction("PAY FINE") {

		            @Override
		            public void actionPerformed(ActionEvent evt) {
		            		current.setInJail(false);
		            		current.resetJailTurns();
		            		current.changeMoney(0 - 50);
		            		log.append(current.getName() + " paid the fine. \n\n");
		            		jailDialog.dispose();
		            }});
				
				JButton rollB = new JButton(new AbstractAction("ROLL") {

		            @Override
		            public void actionPerformed(ActionEvent evt) {
		            	
		            	int i = (int) (Math.random() * 6) + 1;
		        		int j = (int) (Math.random() * 6) + 1;
		        		lastRoll = i+j;
		        		if(i == j)
		        		{
		        			current.setInJail(false);
		            		current.resetJailTurns();
		            		log.append(current.getName() + " rolled doubles. Lucky. \n\n");
		            		location = current.getPos() + i + j;
		            		jailDialog.dispose();
		            		buy.setEnabled(true);
		            		roll.setEnabled(false);
		            		endTurn.setEnabled(true);	
		            		current.moveTo(location);
		        		}
		        		else
		        		{
		        			log.append(current.getName() + " failed to roll doubles. Truly Unfortunate \n\n");
		        			endTurn();
		        			endTurn.setEnabled(false);
		        			roll.setEnabled(true);
		        			buy.setEnabled(false);
		        			jailDialog.dispose();
		        		}
		   

		            }});
				useCard = new JButton(new AbstractAction("GET OUT OF JAIL FREE") {

		            @Override
		            public void actionPerformed(ActionEvent evt) {
		            	current.setInJail(false);
	            		current.resetJailTurns();
	            		current.setOutCards(current.getOutCards() - 1);
	            		log.append(current.getName() + " used a get out of jail free card. Cheater. \n\n");
	            		jailDialog.dispose();
	            		roll.setEnabled(true);
	            		endTurn.setEnabled(false);
	            		buy.setEnabled(false);
	            		jailDialog.dispose();

		            }});
				if (current.getOutCards() == 0)
				{
					useCard.setEnabled(false);
				}
				cardPane.add(pay);
				cardPane.add(rollB);
				cardPane.add(useCard);
				jailDialog.setContentPane(cardPane);
				jailDialog.pack();
	            jailDialog.setLocationRelativeTo(frame);
				jailDialog.setVisible(true);
			}
		}
		else {
			roll.setEnabled(true);
		}
		
	}
	}
	
	public static void endTurn()
	{
		current = playerList.get(whoseTurn);
		if (current.getMoney() < 0)
		{
			log.append(current.getName() + " is bankrupt!\n\n");
			for (int i = 0; i < 40; i++)
			{
				if(current.equals(spaces.get(i).getOwner()))
				{
					if(spaces.get(i) instanceof Property)
					{
						while (((Property)spaces.get(i)).getHouses() > 0)
						{
							((Property)spaces.get(i)).subHouses();
						}
						((Property)spaces.get(i)).setMortgageState(false);
						((Property)spaces.get(i)).ownerNulled();
					}
					if(spaces.get(i) instanceof Railroad)
					{
						((Railroad)spaces.get(i)).setMortgageState(false);
						((Railroad)spaces.get(i)).ownerNulled();
					}
					if(spaces.get(i) instanceof Utility)
					{
						((Utility)spaces.get(i)).setMortgageState(false);
						((Utility)spaces.get(i)).ownerNulled();
					}
				}
			}
			for(int i = 0; i < playerList.size(); i++)
			{
				if(current.equals(playerList.get(i)))
				{
					playerList.remove(i);
					numofPlayers--;
				}
			}
		}
		whoseTurn++;
		turnHandler();
		startTurn();
		doubleCount = 0;
	}
	
	
	public static void buy()
	{
		InitBoard.getSpaces().get(current.getPos()).buy(current);
		log.append(current.getName() + " has purchased " + InitBoard.getSpaces().get(current.getPos()).getName() + "\n\n");
		buy.setEnabled(false);
	}
	
	
	
	public static void roll()
	{
		current = playerList.get(whoseTurn);
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
		if (i == j)
		{
			doubleCount++;
			roll.setEnabled(true);
			endTurn.setEnabled(false);
			
			if (doubleCount == 3)
			{
				current.goToJail();
				roll.setEnabled(false);
				endTurn();
			}
			else {
				roll.setEnabled(true);
				buy.setEnabled(true);
			}
		}
		else if (doubleCount == 0)
		{
			roll.setEnabled(false);
			buy.setEnabled(true);
			endTurn.setEnabled(true);
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
		else if ((InitBoard.getSpaces().get(location) instanceof CommunityChest))
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
		else if (!(InitBoard.getSpaces().get(location) instanceof Property) && !(InitBoard.getSpaces().get(location) instanceof Railroad) && !(InitBoard.getSpaces().get(location) instanceof Utility) )
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
		if (whoseTurn + 1 >= numofPlayers) {
			return playerList.get(0);
		}
		else {
		return playerList.get(whoseTurn + 1);
		}
	}
	
	public static ArrayList<Player> getPlayerList()
	{
		return playerList;
	}
	
	public static String getChance()
	{
		return chanceString;
	}
	
	public static String getCommunity()
	{
		return chestString;
	}
	
	public static int getLastRoll()
	{
		return lastRoll;
	}
	
	public static JButton getBuy()
	{
		return buy;
	}
	
	public static JButton getRoll()
	{
		return roll;
	}
	
	public static JButton getEndTurn()
	{
		return endTurn;
	}
	
	public static JTextArea getLog()
	{
		return log;
	}
	
	public static ArrayList<Space> getSpaces()
	{
		return spaces;
	}
	public static void receiveLog(JTextArea area)
	{
		log = area;
	}
	
	public static void receiveRoll(JButton rollB)
	{
		roll = rollB;
	}
	
	public static void receiveManage(JButton manageB)
	{
		manage = manageB;
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
	
	public static void receiveFrame(JFrame input)
	{
		frame = input;
	}
	
	public static Player getPlayer(int n)
	{
		return playerList.get(n);
	}
	
	
	public static boolean isReady()
	{
		return isReady;
	}
	
	public static int getNumPlayers()
	{
		return numofPlayers;
	}
	
}
