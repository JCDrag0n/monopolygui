
public interface Space {
	void buy(Player p);
	void payRent(Player p);
	String getColor();
	Player getOwner();
	String getName();
	void addHouse();
	void removeHouse();
	void mortgage();
	void unmortgage();
	void ownerNull();
}
