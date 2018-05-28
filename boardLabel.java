import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class boardLabel {
	
	private JFrame board;
	private JPanel boardPane;
	
	private JLabel property, med, cchest, balt, tax1, rrail, ori, chance, ver, con, jail; 
	private JLabel stc, ele, stat, virg, penn, stj, cchest2, tenn, ny, fpark;
	private JLabel kent, chance2, ind, ill, bor, alta, vent, water, marvin, gtjail;
	private JLabel pacific, north, cchest3, pennave, shortL, chance3, park, tax2, boardwalk, go, center;
	
	private Image propertyImage;
	
	

	public boardLabel() {
		
		//board = new JFrame("Monopoly Board Test");
		boardPane = new JPanel(new GridBagLayout());
		boardPane.setPreferredSize(new Dimension(1000,1000));
		
		//board.add(boardPane);
		
		GridBagConstraints propertyc = new GridBagConstraints();
		GridBagConstraints squarec = new GridBagConstraints();
		GridBagConstraints centerc = new GridBagConstraints();
		
		Dimension propertyr = new Dimension(82, 132);
		Dimension squared = new Dimension(132, 132);
		Dimension propertyl = new Dimension(132, 82);
		Dimension centerd = new Dimension(736, 736);
		
//		propertyc.ipadx = 82;
//		propertyc.ipady = 132;
//		
//		squarec.ipadx = 132;
//		squarec.ipady = 132;
		
		centerc.gridwidth = 9;
		centerc.gridheight = 9;
		
		StretchIcon propertyimg = imgConversion("/BalticPC.png");
		property = new JLabel(propertyimg);
		
		fpark = new JLabel(imgConversion("/freeparking.png"));
//		fpark.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                property.setIcon(imgConversion("/BalticPC.png"));
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                property.setIcon(pic1);
//            }
//        });
		setAllSizes(fpark, squared);
		squarec.gridx = 0;
		squarec.gridy = 0;
		boardPane.add(fpark, squarec);
		
		kent = new JLabel(imgConversion("/kentucky.png"));
		setAllSizes(kent, propertyr);
		propertyc.gridx = 1;
		propertyc.gridy = 0;
		boardPane.add(kent, propertyc);
		
		chance2 = new JLabel(imgConversion("chanceu.png"));
		setAllSizes(chance2, propertyr);
		propertyc.gridx = 2;
		propertyc.gridy = 0;
		boardPane.add(chance2, propertyc);
		
		ind = new JLabel(imgConversion("indiana.png"));
		setAllSizes(ind, propertyr);
		propertyc.gridx = 3;
		propertyc.gridy = 0;
		boardPane.add(ind, propertyc);
		
		ill = new JLabel(imgConversion("illinois.png"));
		setAllSizes(ill, propertyr);
		propertyc.gridx = 4;
		propertyc.gridy = 0;
		boardPane.add(ill, propertyc);
		
		bor = new JLabel(imgConversion("borail.png"));
		setAllSizes(bor, propertyr);
		propertyc.gridx = 5;
		propertyc.gridy = 0;
		boardPane.add(bor, propertyc);
		
		alta = new JLabel(imgConversion("atlantic.png"));
		setAllSizes(alta, propertyr);
		propertyc.gridx = 6;
		propertyc.gridy = 0;
		boardPane.add(alta, propertyc);
		
		vent = new JLabel(imgConversion("ventnor.png"));
		setAllSizes(vent, propertyr);
		propertyc.gridx = 7;
		propertyc.gridy = 0;
		boardPane.add(vent, propertyc);
		
		water = new JLabel(imgConversion("water.png"));
		setAllSizes(water, propertyr);
		propertyc.gridx = 8;
		propertyc.gridy = 0;
		boardPane.add(water, propertyc);
		
		marvin = new JLabel(imgConversion("marvin.png"));
		setAllSizes(marvin, propertyr);
		propertyc.gridx = 9;
		propertyc.gridy = 0;
		boardPane.add(marvin, propertyc);
		
		gtjail = new JLabel(imgConversion("gotojail.png"));
		setAllSizes(gtjail, squared);
		squarec.gridx = 10;
		squarec.gridy = 0;
		boardPane.add(gtjail, squarec);
		
		pacific = new JLabel(imgConversion("pacific.png"));
		setAllSizes(pacific, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 1;
		boardPane.add(pacific, propertyc);
		
		north = new JLabel(imgConversion("northc.png"));
		setAllSizes(north, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 2;
		boardPane.add(north, propertyc);
		
		cchest3 = new JLabel(imgConversion("communitycr.png"));
		setAllSizes(cchest3, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 3;
		boardPane.add(cchest3, propertyc);
		
		pennave = new JLabel(imgConversion("pennave.png"));
		setAllSizes(pennave, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 4;
		boardPane.add(pennave, propertyc);
		
		shortL = new JLabel(imgConversion("shortline.png"));
		setAllSizes(shortL, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 5;
		boardPane.add(shortL, propertyc);
		
		chance3 = new JLabel(imgConversion("chancer.png"));
		setAllSizes(chance3, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 6;
		boardPane.add(chance3, propertyc);
		
		park = new JLabel(imgConversion("park.png"));
		setAllSizes(park, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 7;
		boardPane.add(park, propertyc);
		
		tax2 = new JLabel(imgConversion("luxtax.png"));
		setAllSizes(tax2, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 8;
		boardPane.add(tax2, propertyc);
		
		boardwalk = new JLabel(imgConversion("boardwalk.png"));
		setAllSizes(boardwalk, propertyl);
		propertyc.gridx = 10;
		propertyc.gridy = 9;
		boardPane.add(boardwalk, propertyc);
		
		go = new JLabel(imgConversion("go.png"));
		setAllSizes(go, squared);
		squarec.gridx = 10;
		squarec.gridy = 10;
		boardPane.add(go, squarec);
		
		ny = new JLabel(imgConversion("ny.png"));
		setAllSizes(ny, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 1;
		boardPane.add(ny, propertyc);
		
		tenn = new JLabel(imgConversion("tennessee.png"));
		setAllSizes(tenn, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 2;
		boardPane.add(tenn, propertyc);
		
		cchest2 = new JLabel(imgConversion("communitycl.png"));
		setAllSizes(cchest2, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 3;
		boardPane.add(cchest2, propertyc);
		
		stj = new JLabel(imgConversion("stjames.png"));
		setAllSizes(stj, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 4;
		boardPane.add(stj, propertyc);
		
		penn = new JLabel(imgConversion("pennrail.png"));
		setAllSizes(penn, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 5;
		boardPane.add(penn, propertyc);
		
		virg = new JLabel(imgConversion("virginia.png"));
		setAllSizes(virg, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 6;
		boardPane.add(virg, propertyc);
		
		stat = new JLabel(imgConversion("states.png"));
		setAllSizes(stat, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 7;
		boardPane.add(stat, propertyc);
		
		ele = new JLabel(imgConversion("electric.png"));
		setAllSizes(ele, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 8;
		boardPane.add(ele, propertyc);
		
		stc = new JLabel(imgConversion("stcharles.png"));
		setAllSizes(stc, propertyl);
		propertyc.gridx = 0;
		propertyc.gridy = 9;
		boardPane.add(stc, propertyc);
		
		con = new JLabel(imgConversion("connecticut.png"));
		setAllSizes(con, propertyr);
		propertyc.gridx = 1;
		propertyc.gridy = 10;
		boardPane.add(con, propertyc);
		
		ver = new JLabel(imgConversion("vermont.png"));
		setAllSizes(ver, propertyr);
		propertyc.gridx = 2;
		propertyc.gridy = 10;
		boardPane.add(ver, propertyc);
		
		chance = new JLabel(imgConversion("chanced.png"));
		setAllSizes(chance, propertyr);
		propertyc.gridx = 3;
		propertyc.gridy = 10;
		boardPane.add(chance, propertyc);
		
		ori = new JLabel(imgConversion("oriental.png"));
		setAllSizes(ori, propertyr);
		propertyc.gridx = 4;
		propertyc.gridy = 10;
		boardPane.add(ori, propertyc);
		
		rrail = new JLabel(imgConversion("readingrail.png"));
		setAllSizes(rrail, propertyr);
		propertyc.gridx = 5;
		propertyc.gridy = 10;
		boardPane.add(rrail, propertyc);
		
		tax1 = new JLabel(imgConversion("inctax.png"));
		setAllSizes(tax1, propertyr);
		propertyc.gridx = 6;
		propertyc.gridy = 10;
		boardPane.add(tax1, propertyc);
		
		balt = new JLabel(imgConversion("baltic.png"));
		setAllSizes(balt, propertyr);
		propertyc.gridx = 7;
		propertyc.gridy = 10;
		boardPane.add(balt, propertyc);
		
		cchest = new JLabel(imgConversion("communitycd.png"));
		setAllSizes(cchest, propertyr);
		propertyc.gridx = 8;
		propertyc.gridy = 10;
		boardPane.add(cchest, propertyc);
		
		med = new JLabel(imgConversion("mediterranean.png"));
		setAllSizes(med, propertyr);
		propertyc.gridx = 9;
		propertyc.gridy = 10;
		boardPane.add(med, propertyc);
		
		jail = new JLabel(imgConversion("jail.png"));
		setAllSizes(jail, squared);
		squarec.gridx = 0;
		squarec.gridy = 10;
		boardPane.add(jail, squarec);
		
		center = new JLabel(imgConversion("center.png"));
		setAllSizes(center, centerd);
		centerc.gridx = 1;
		centerc.gridy = 1;
		boardPane.add(center, centerc);
		
	}
	
	public void initBoard()
	{
		boardPane.setBackground(Color.BLACK);
		boardPane.setVisible(true);
//    	board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	board.pack();
//    	board.setVisible(true);
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
                	hCount.setVisible(true);
                	hCount.setText("HOUSES: " + ((Property)GameHandler.getSpaces().get(space)).getHouses() + " HOTEL: 0");
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
	
	public JLabel getProperty()
	{
		return property;
	}
}
