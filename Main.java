import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	
	private String playerOneName;
	private String playerTwoName;
	private String playerThreeName;
	private String playerFourName;
	
	private CardSwitcher source;
	
	public Main(String p1, String p2, String p3, String p4, CardSwitcher source)
	{
		this.source = source;
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(p1);
		nameList.add(p2);
		nameList.add(p3);
		nameList.add(p4);
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < 2; i++)
		{
			playerList.add(new Player(nameList.get(i)));
		}
		
		 ArrayList<Space> spaces = new ArrayList<Space>();
	        spaces.add(new Go());
	        spaces.add(new Property("Mediterranean Avenue", "Brown", 60, 2, 4, 10, 30, 90, 160, 250, 50, 30));
	        spaces.add(new CommunityChest());
	        spaces.add(new Property("Baltic Avenue", "Brown", 60, 4, 8, 20, 60, 180, 320, 450, 50, 30));
	        spaces.add(new Tax("Income Tax", 200));
	        spaces.add(new Railroad("Reading Railroad"));
	        spaces.add(new Property("Oriental Avenue", "Light Blue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
	        spaces.add(new Chance());
	        spaces.add(new Property("Vermont Avenue", "Light BLue", 100, 6, 12, 30, 90, 270, 400, 550, 50, 50));
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
	        System.out.println("Each of you starts with $1500. Let's play!");
	        boolean done = false;
	        while (!done)
	        {
	        	source.switchTo(Sandbox.GAMEPANEL);
	        	for (Player p: playerList)
	        	{
	        		p.turn();
	        		int counter = 0;
	        		Player winner = new Player("Nobody");
	        		for (Player elements: playerList)
	        		{	
	        			if (!(elements.getBankrupt()))
	        			{
	        				counter++;
	        				winner = elements;
	        			}
	        		}
	        		if (counter == 1) 
	        		{
	        			done = true;
	        			System.out.println(winner.getName() + " is the winner!!!");
	        			break;
	        		}
	        	}
	        	
	        }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Player> playerList = new ArrayList<Player>();
//        Scanner in = new Scanner(System.in);
//        int numPlayers = 0;
//        System.out.println("Welcome to Monopoly! How many players?");
//        String playernum = in.nextLine();
//        numPlayers = Integer.parseInt(playernum);
//        for (int i = 1; i <= numPlayers; i++) {
//             System.out.println("Input Player " + i + "\'s name:");
//             String temp = in.nextLine();
//             playerList.add(new Player(temp));
//        }
	}
}