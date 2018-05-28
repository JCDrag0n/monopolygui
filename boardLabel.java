import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class boardLabel {
	private JPanel boardPane;

	public boardLabel() {
		

	}

	public void initBoard()
	{
		boardPane.setBackground(Color.BLACK);
		boardPane.setVisible(true);
	}
	
	public static StretchIcon imgConversion(String file)
	{
		 Image resource = null;
		 try {
             resource = ImageIO.read(boardLabel.class.getResource(file));
         } catch (IOException ioe) {
             ioe.printStackTrace();
         }
		 
		 StretchIcon result = new StretchIcon(resource, true);
		 
		 return result;
	}
	
	public static void setAllSizes(JComponent name, Dimension c)
	{
		name.setMinimumSize(c);
		name.setMaximumSize(c);
		name.setPreferredSize(c);
	}
	
	public static void setMouseListener(JLabel name, JLabel reset, JLabel app, JLabel hCount, int space, String file)
	{
		name.addMouseListener(new MouseAdapter() {
			String temp;
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	reset.setIcon(app.getIcon());
                app.setIcon(boardLabel.imgConversion(file));
                temp = hCount.getText();
                if (space != -1)
                {
                	if (((Property)GameHandler.getSpaces().get(space)).getHouses() == 5)
                	{
                		hCount.setVisible(true);
                		hCount.setText("HOUSES: 0 HOTEL: 1");
                	}
                	else
                	{
                	hCount.setVisible(true);
                	hCount.setText("HOUSES: " + ((Property)GameHandler.getSpaces().get(space)).getHouses() + " HOTEL: 0");
                	}
                }
                else {
                	hCount.setVisible(false);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                app.setIcon(reset.getIcon());
                hCount.setVisible(true);
                hCount.setText(temp);
            }
        });
	}
	
	public JPanel getPane()
	{
		return boardPane;
	}
}
