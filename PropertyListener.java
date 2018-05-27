import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class PropertyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton)e.getSource();
        String tokenName = (String)source.getSelectedItem();
        if (tokenName.equals("Boot"))
        {
        	PlayerInitMenu.setToken("/Boot.png", 1);
        }
        if (tokenName.equals("Car"))
        {
        	PlayerInitMenu.setToken("/Car.png", 1);
        }
        if (tokenName.equals("Dog"))
        {
        	PlayerInitMenu.setToken("/Dog.png", 1);
        }
        if (tokenName.equals("Iron"))
        {
        	PlayerInitMenu.setToken("/Iron.png", 1);
        }
        if (tokenName.equals("Thimble"))
        {
        	PlayerInitMenu.setToken("/Thimble.png", 1);
        }
        if (tokenName.equals("TopHat"))
        {
        	PlayerInitMenu.setToken("/TopHat.png", 1);
        }
        if (tokenName.equals("Wheelbarrow"))
        {
        	PlayerInitMenu.setToken("/Wheelbarrow.png", 1);
        }
	}

}
