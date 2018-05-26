import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class ButtonCreator extends JButton {
	
	private Dimension dimension;

	public ButtonCreator(String name, Dimension size)
	{
		super(name);
		dimension = size;
	}
	
	public ButtonCreator(AbstractAction event, Dimension size)
	{
		super(event);
		dimension = size;
	}
	
	public void setSize(Dimension size)
	{
		dimension = size;
	}
	
	public Dimension getPreferredSize()
	{
		return dimension;
	}
	
	public Dimension getMinimumSize()
	{
		return dimension;
	}
	
	public Dimension getMaximumSize()
	{
		return dimension;
	}
	
	public void setEnabled(boolean set)
	{
		super.setEnabled(set);
	}
	
}
