import java.util.ArrayList;
public class InitBoard {
	private static ArrayList<Space> spaces;
	private static ArrayList<Player> players;
	public InitBoard(ArrayList<Space> spacein, ArrayList<Player> playerin)
	{
		spaces = spacein;
		players = playerin;
	}
	public static ArrayList<Space> getSpaces()
	{
		return spaces;
	}
	public static ArrayList<Player> getPlayers()
	{
		return players;
	}
}
