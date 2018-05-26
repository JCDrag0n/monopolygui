import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Sandbox {
	
	private JFrame frame;
	
	//private JLabel board;
	private JLabel property;
	private JLabel header;

	private JPanel uiHolder;
	private JPanel imgHolder;
	private JPanel buttonHolder;
	private JPanel boardPane;
	private JPanel menuPop;
	private JPanel chancePop;
	private JPanel switchPane;
	private BackgroundPane gamePane;
	
	private Image boardImage;
	private Image propertyImage;
	private Image backgroundimg;
	
	private JTextArea log;
	private JScrollPane scrollPane;
	
	private JButton buy;
	private JButton trade;
	private JButton roll;
	private JButton menu;
	private JButton endTurn;
	private JButton manage;
	private JButton chance;
	private JButton community;
	
	private JLayeredPane layeredPane;
	
	private Board spritePane;
	
//	private JLabel currentIcon, med, cchest, balt, tax1, rrail, ori, chance, ver, con, jail; 
//	private JLabel stc, ele, stat, virg, penn, stj, cchest2, tenn, ny, fpark;
//	private JLabel kent, chance2, ind, ill, bor, alta, vent, water, marvin, gtjail;
//	private JLabel pacific, north, cchest3, pennave, shortL, chance3, park, tax2, boardwalk, go, center;
//	
	private CardLayout switcher;
	
	protected static final Color GP_COLOR = new Color(0, 0, 0, 30);
	
	final static String STARTPANEL = "MAIN MENU";
	final static String GAMEPANEL = "MONOPOLY";

	
    public Sandbox()
    {
    }
    
    public void createFrame() throws IOException
    {
    	frame = new JFrame("Monopoly");
    	MainMenuPane menuPane = new MainMenuPane(frame);
    	menuPop = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(GP_COLOR);
                g.fillRect(0, 0, getWidth(), getHeight());
             };
          };
        menuPop.setOpaque(false);
        menuPop.setVisible(false);
    	//frame.setContentPane(new BackgroundPane("/Wood1.jpg"));
    	//frame.getContentPane().setLayout(new BorderLayout());
        gamePane = new BackgroundPane("/Wood1.jpg");
        gamePane.setLayout(new BorderLayout());
        boardLabel.setAllSizes(gamePane, new Dimension(1920, 1080));
        switchPane = new JPanel(new CardLayout());
    	switchPane.add(menuPane, STARTPANEL);
    	switchPane.add(gamePane, GAMEPANEL);
    	menuPane.addElements();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setGlassPane(menuPop);
    	frame.setPreferredSize(new Dimension(1920,1080));
    	frame.setMaximumSize(new Dimension(1920,1080));
    	frame.setMinimumSize(new Dimension(1920,1080));
    	//frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH); 
    	//frame.setUndecorated(true);
    	frame.add(switchPane);
        frame.setVisible(true);
        switcher = (CardLayout)(switchPane.getLayout());
        CardSwitcher switchHandler = new CardSwitcher(switchPane, switcher);
        menuPane.passthrough(switchHandler);
    }
    
    public void initBoard()
    {
//    	  try {
//              boardImage = ImageIO.read(getClass().getResource("/Board.jpg"));
//          } catch (IOException ioe) {
//              ioe.printStackTrace();
//          }
//    	StretchIcon boardimg = new StretchIcon(boardImage, true);
//    	board = new JLabel(boardimg);
    	//board = new JFrame("Monopoly Board Test");
//    			boardPane = new JPanel(new GridBagLayout());
//    			boardPane.setPreferredSize(new Dimension(1000,1000));
//    			
//    			//board.add(boardPane);
//    			
//    			GridBagConstraints propertyc = new GridBagConstraints();
//    			GridBagConstraints squarec = new GridBagConstraints();
//    			GridBagConstraints centerc = new GridBagConstraints();
//    			
//    			Dimension propertyr = new Dimension(82, 132);
//    			Dimension squared = new Dimension(132, 132);
//    			Dimension propertyl = new Dimension(132, 82);
//    			Dimension centerd = new Dimension(736, 736);
//    			
////    			propertyc.ipadx = 82;
////    			propertyc.ipady = 132;
////    			
////    			squarec.ipadx = 132;
////    			squarec.ipady = 132;
//    			
//    			centerc.gridwidth = 9;
//    			centerc.gridheight = 9;
//    			
//    			StretchIcon propertyimg = boardLabel.imgConversion("/AtlanticPC.png");
//    			property = new JLabel(propertyimg);
//    			
//    			currentIcon = new JLabel();
//    			
//    			fpark = new JLabel(boardLabel.imgConversion("/freeparking.png"));
//    			boardLabel.setAllSizes(fpark, squared);
//    			squarec.gridx = 0;
//    			squarec.gridy = 0;
//    			boardPane.add(fpark, squarec);
//    			
//    			kent = new JLabel(boardLabel.imgConversion("/kentucky.png"));
//    			boardLabel.setAllSizes(kent, propertyr);
//    			propertyc.gridx = 1;
//    			propertyc.gridy = 0;
//    			boardPane.add(kent, propertyc);
//    			
//    			kent.addMouseListener(new MouseAdapter() {
//
//    	            @Override
//    	            public void mouseEntered(java.awt.event.MouseEvent evt) {
//    	            	currentIcon.setIcon(property.getIcon());
//    	                property.setIcon(boardLabel.imgConversion("/KentuckyPC.png"));
//    	                System.out.println("return");
//    	            }
//
//    	            @Override
//    	            public void mouseExited(java.awt.event.MouseEvent evt) {
//    	                property.setIcon(currentIcon.getIcon());
//    	            }
//    	        });
//    			
//    			chance2 = new JLabel(boardLabel.imgConversion("chanceu.png"));
//    			boardLabel.setAllSizes(chance2, propertyr);
//    			propertyc.gridx = 2;
//    			propertyc.gridy = 0;
//    			boardPane.add(chance2, propertyc);
//    			
//    			ind = new JLabel(boardLabel.imgConversion("indiana.png"));
//    			boardLabel.setAllSizes(ind, propertyr);
//    			propertyc.gridx = 3;
//    			propertyc.gridy = 0;
//    			boardPane.add(ind, propertyc);
//    			
//    			ill = new JLabel(boardLabel.imgConversion("illinois.png"));
//    			boardLabel.setAllSizes(ill, propertyr);
//    			propertyc.gridx = 4;
//    			propertyc.gridy = 0;
//    			boardPane.add(ill, propertyc);
//    			
//    			bor = new JLabel(boardLabel.imgConversion("borail.png"));
//    			boardLabel.setAllSizes(bor, propertyr);
//    			propertyc.gridx = 5;
//    			propertyc.gridy = 0;
//    			boardPane.add(bor, propertyc);
//    			
//    			alta = new JLabel(boardLabel.imgConversion("atlantic.png"));
//    			boardLabel.setAllSizes(alta, propertyr);
//    			propertyc.gridx = 6;
//    			propertyc.gridy = 0;
//    			boardPane.add(alta, propertyc);
//    			
//    			vent = new JLabel(boardLabel.imgConversion("ventnor.png"));
//    			boardLabel.setAllSizes(vent, propertyr);
//    			propertyc.gridx = 7;
//    			propertyc.gridy = 0;
//    			boardPane.add(vent, propertyc);
//    			
//    			water = new JLabel(boardLabel.imgConversion("water.png"));
//    			boardLabel.setAllSizes(water, propertyr);
//    			propertyc.gridx = 8;
//    			propertyc.gridy = 0;
//    			boardPane.add(water, propertyc);
//    			
//    			marvin = new JLabel(boardLabel.imgConversion("marvin.png"));
//    			boardLabel.setAllSizes(marvin, propertyr);
//    			propertyc.gridx = 9;
//    			propertyc.gridy = 0;
//    			boardPane.add(marvin, propertyc);
//    			
//    			gtjail = new JLabel(boardLabel.imgConversion("gotojail.png"));
//    			boardLabel.setAllSizes(gtjail, squared);
//    			squarec.gridx = 10;
//    			squarec.gridy = 0;
//    			boardPane.add(gtjail, squarec);
//    			
//    			pacific = new JLabel(boardLabel.imgConversion("pacific.png"));
//    			boardLabel.setAllSizes(pacific, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 1;
//    			boardPane.add(pacific, propertyc);
//    			
//    			north = new JLabel(boardLabel.imgConversion("northc.png"));
//    			boardLabel.setAllSizes(north, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 2;
//    			boardPane.add(north, propertyc);
//    			
//    			cchest3 = new JLabel(boardLabel.imgConversion("communitycr.png"));
//    			boardLabel.setAllSizes(cchest3, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 3;
//    			boardPane.add(cchest3, propertyc);
//    			
//    			pennave = new JLabel(boardLabel.imgConversion("pennave.png"));
//    			boardLabel.setAllSizes(pennave, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 4;
//    			boardPane.add(pennave, propertyc);
//    			
//    			shortL = new JLabel(boardLabel.imgConversion("shortline.png"));
//    			boardLabel.setAllSizes(shortL, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 5;
//    			boardPane.add(shortL, propertyc);
//    			
//    			chance3 = new JLabel(boardLabel.imgConversion("chancer.png"));
//    			boardLabel.setAllSizes(chance3, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 6;
//    			boardPane.add(chance3, propertyc);
//    			
//    			park = new JLabel(boardLabel.imgConversion("park.png"));
//    			boardLabel.setAllSizes(park, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 7;
//    			boardPane.add(park, propertyc);
//    			
//    			tax2 = new JLabel(boardLabel.imgConversion("luxtax.png"));
//    			boardLabel.setAllSizes(tax2, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 8;
//    			boardPane.add(tax2, propertyc);
//    			
//    			boardwalk = new JLabel(boardLabel.imgConversion("boardwalk.png"));
//    			boardLabel.setAllSizes(boardwalk, propertyl);
//    			propertyc.gridx = 10;
//    			propertyc.gridy = 9;
//    			boardPane.add(boardwalk, propertyc);
//    			
//    			go = new JLabel(boardLabel.imgConversion("go.png"));
//    			boardLabel.setAllSizes(go, squared);
//    			squarec.gridx = 10;
//    			squarec.gridy = 10;
//    			boardPane.add(go, squarec);
//    			
//    			ny = new JLabel(boardLabel.imgConversion("ny.png"));
//    			boardLabel.setAllSizes(ny, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 1;
//    			boardPane.add(ny, propertyc);
//    			
//    			tenn = new JLabel(boardLabel.imgConversion("tennessee.png"));
//    			boardLabel.setAllSizes(tenn, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 2;
//    			boardPane.add(tenn, propertyc);
//    			
//    			cchest2 = new JLabel(boardLabel.imgConversion("communitycl.png"));
//    			boardLabel.setAllSizes(cchest2, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 3;
//    			boardPane.add(cchest2, propertyc);
//    			
//    			stj = new JLabel(boardLabel.imgConversion("stjames.png"));
//    			boardLabel.setAllSizes(stj, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 4;
//    			boardPane.add(stj, propertyc);
//    			
//    			penn = new JLabel(boardLabel.imgConversion("pennrail.png"));
//    			boardLabel.setAllSizes(penn, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 5;
//    			boardPane.add(penn, propertyc);
//    			
//    			virg = new JLabel(boardLabel.imgConversion("virginia.png"));
//    			boardLabel.setAllSizes(virg, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 6;
//    			boardPane.add(virg, propertyc);
//    			
//    			stat = new JLabel(boardLabel.imgConversion("states.png"));
//    			boardLabel.setAllSizes(stat, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 7;
//    			boardPane.add(stat, propertyc);
//    			
//    			ele = new JLabel(boardLabel.imgConversion("electric.png"));
//    			boardLabel.setAllSizes(ele, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 8;
//    			boardPane.add(ele, propertyc);
//    			
//    			stc = new JLabel(boardLabel.imgConversion("stcharles.png"));
//    			boardLabel.setAllSizes(stc, propertyl);
//    			propertyc.gridx = 0;
//    			propertyc.gridy = 9;
//    			boardPane.add(stc, propertyc);
//    			
//    			con = new JLabel(boardLabel.imgConversion("connecticut.png"));
//    			boardLabel.setAllSizes(con, propertyr);
//    			propertyc.gridx = 1;
//    			propertyc.gridy = 10;
//    			boardPane.add(con, propertyc);
//    			
//    			ver = new JLabel(boardLabel.imgConversion("vermont.png"));
//    			boardLabel.setAllSizes(ver, propertyr);
//    			propertyc.gridx = 2;
//    			propertyc.gridy = 10;
//    			boardPane.add(ver, propertyc);
//    			
//    			chance = new JLabel(boardLabel.imgConversion("chanced.png"));
//    			boardLabel.setAllSizes(chance, propertyr);
//    			propertyc.gridx = 3;
//    			propertyc.gridy = 10;
//    			boardPane.add(chance, propertyc);
//    			
//    			ori = new JLabel(boardLabel.imgConversion("oriental.png"));
//    			boardLabel.setAllSizes(ori, propertyr);
//    			propertyc.gridx = 4;
//    			propertyc.gridy = 10;
//    			boardPane.add(ori, propertyc);
//    			
//    			rrail = new JLabel(boardLabel.imgConversion("readingrail.png"));
//    			boardLabel.setAllSizes(rrail, propertyr);
//    			propertyc.gridx = 5;
//    			propertyc.gridy = 10;
//    			boardPane.add(rrail, propertyc);
//    			
//    			tax1 = new JLabel(boardLabel.imgConversion("inctax.png"));
//    			boardLabel.setAllSizes(tax1, propertyr);
//    			propertyc.gridx = 6;
//    			propertyc.gridy = 10;
//    			boardPane.add(tax1, propertyc);
//    			
//    			balt = new JLabel(boardLabel.imgConversion("baltic.png"));
//    			boardLabel.setAllSizes(balt, propertyr);
//    			propertyc.gridx = 7;
//    			propertyc.gridy = 10;
//    			boardPane.add(balt, propertyc);
//    			
//    			cchest = new JLabel(boardLabel.imgConversion("communitycd.png"));
//    			boardLabel.setAllSizes(cchest, propertyr);
//    			propertyc.gridx = 8;
//    			propertyc.gridy = 10;
//    			boardPane.add(cchest, propertyc);
//    			
//    			med = new JLabel(boardLabel.imgConversion("mediterranean.png"));
//    			boardLabel.setAllSizes(med, propertyr);
//    			propertyc.gridx = 9;
//    			propertyc.gridy = 10;
//    			boardPane.add(med, propertyc);
//    			
//    			jail = new JLabel(boardLabel.imgConversion("jail.png"));
//    			boardLabel.setAllSizes(jail, squared);
//    			squarec.gridx = 0;
//    			squarec.gridy = 10;
//    			boardPane.add(jail, squarec);
//    			
//    			center = new JLabel(boardLabel.imgConversion("center.png"));
//    			boardLabel.setAllSizes(center, centerd);
//    			centerc.gridx = 1;
//    			centerc.gridy = 1;
//    			boardPane.add(center, centerc);
//    			
//    			boardPane.setBackground(Color.BLACK);
//    			boardPane.setVisible(true);
//    	boardPane.setPreferredSize(new Dimension(1000,1000));
//    	boardPane.setBounds(10, 20, 1000, 1000);
//    	boardPane.setOpaque(false);
//    	boardPane.setFocusable(true);
//    	boardPane.requestFocus();
    	
//    	board.setHorizontalAlignment(JLabel.CENTER);
//    	board.setVerticalAlignment(JLabel.CENTER);

    	//frame.pack();
    }
    
    public void addBoard()
    {
    	layeredPane = new JLayeredPane();
    	layeredPane.setPreferredSize(new Dimension(1100,1100));
    	spritePane = new Board(20);
    	spritePane.setPreferredSize(new Dimension(1000, 1000));
    	spritePane.setBounds(10, 20, 1000, 1000);
    	
    	chancePop = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(GP_COLOR);
                g.fillRect(0, 0, getWidth(), getHeight());
             };
          };
        chancePop.setOpaque(false);
        chancePop.setVisible(false);
        
        //layeredPane.add(boardPane, Integer.valueOf(1), 0);
    	layeredPane.add(spritePane, Integer.valueOf(1), 1);
    	layeredPane.add(chancePop, Integer.valueOf(0));
//    	layeredPane.setVisible(true);
    	gamePane.add(layeredPane, BorderLayout.LINE_START);
    }
    
    public void initUI()
    {
    	uiHolder = new JPanel();
    	uiHolder.setLayout(new BoxLayout(uiHolder, BoxLayout.PAGE_AXIS));
    	uiHolder.setPreferredSize(new Dimension(910, 1080));
    	uiHolder.setOpaque(false);
    	uiHolder.setVisible(true);
    	
    	gamePane.add(uiHolder, BorderLayout.LINE_END);
    	//frame.pack();
    }
    
    public void imageUI()
    {
    	imgHolder = new JPanel(new FlowLayout());
    	imgHolder.setOpaque(false);
    	imgHolder.setVisible(true);
    	imgHolder.setBorder(new EmptyBorder(20,0,0,0));
    	uiHolder.add(imgHolder);
    }
    
    public void addProperty()
    {
    	//property.setPreferredSize(new Dimension(320, 408));
    	//property.setVisible(true);
    	imgHolder.add(spritePane.getProperty());
    	//frame.pack();
    }
    
    public void addLog()
    {
    	log = new JTextArea();
    	log.setEditable(false);
    	log.setLineWrap(true);
    	log.setWrapStyleWord(true);
    	header = new JLabel("Log");
    	scrollPane = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scrollPane.setPreferredSize(new Dimension(320,408));
    	scrollPane.setColumnHeaderView(header);
    	imgHolder.add(scrollPane);
    	//frame.pack();
    }
    
    public void buttonUI()
    {
//    	GridLayout buttonLayout = new GridLayout(0,2, 5, 5);
//    	buttonHolder = new JPanel(buttonLayout);
//    	buttonHolder.setVisible(true);
//    	buttonHolder.setPreferredSize(new Dimension(900,400));
 
//    	buyHolder = new JPanel(new BorderLayout());
//    	buyHolder.setVisible(true);
//    	buyHolder.setPreferredSize(new Dimension(300, 100));
    	Border empty = BorderFactory.createEmptyBorder(80,80,80,80);
    	buttonHolder = new JPanel(new GridBagLayout());
    	buttonHolder.setVisible(true);
    	buttonHolder.setBorder(empty);
    	buttonHolder.setOpaque(false);
    	uiHolder.add(buttonHolder);
//    	user = new JPanel(buttonLayout);
//    	end = new JPanel(new BorderLayout());
//    	buttonHolder.add(user, BorderLayout.LINE_START);
//    	buttonHolder.add(end, BorderLayout.LINE_END);
    }
    
    public void addButtons()
    {
    	GridBagConstraints buyc = new GridBagConstraints();
    	GridBagConstraints rollc = new GridBagConstraints();
    	GridBagConstraints menuc = new GridBagConstraints();
    	GridBagConstraints managec = new GridBagConstraints();
    	GridBagConstraints endTurnC = new GridBagConstraints();
    	
    	buy = new JButton(new AbstractAction("BUY") {

            @Override
            public void actionPerformed(ActionEvent evt) {
    			GameHandler.buy();
        }});
    	
    	buyc.gridx = 0;
    	buyc.gridy = 0;
    	buyc.weightx = 0.5;
    	buyc.ipady = 80;
    	buyc.insets = new Insets(5, 5, 5, 5);
    	buyc.fill = GridBagConstraints.BOTH;
    	
    	buy.setEnabled(false);
    	
    	roll = new JButton(new AbstractAction("ROLL") {

            @Override
            public void actionPerformed(ActionEvent evt) {
    			GameHandler.roll();
        }});
    	
    	rollc.gridx = 0;
    	rollc.gridy = 1;
    	rollc.weightx = 0.5;
    	rollc.ipady = 80;
    	rollc.insets = new Insets(5, 5, 5, 5);
    	rollc.fill = GridBagConstraints.BOTH;
    	
    	menu = new JButton(new AbstractAction("MENU") {

            @Override
            public void actionPerformed(ActionEvent evt) {
               menuPop.setVisible(true);

               MenuDialog menuDialog = new MenuDialog(frame, "MENU",
                     ModalityType.APPLICATION_MODAL);
               menuDialog.initUI();
               menuDialog.pack();
               menuDialog.setLocationRelativeTo(frame);
               menuDialog.setVisible(true);
               
               menuPop.setVisible(false);
        }});
    	
    	menuc.gridx = 0;
    	menuc.gridy = 2;
    	menuc.weightx = 1.0;
    	menuc.gridwidth = 2;
    	menuc.ipady = 100;
    	menuc.insets = new Insets(5, 5, 5, 5);
    	menuc.fill = GridBagConstraints.BOTH;
    	
    	endTurn = new JButton(new AbstractAction("END TURN") {

            @Override
            public void actionPerformed(ActionEvent evt) {
               GameHandler.endTurn();
        }});
    	
    	endTurnC.gridx = 1;
    	endTurnC.gridy = 1;
    	endTurnC.weightx = 0.5;
    	endTurnC.ipady = 80;
    	endTurnC.insets = new Insets(5, 5, 5, 5);
    	endTurnC.fill = GridBagConstraints.BOTH;
    	
    	manage = new JButton(new AbstractAction("MANAGE") {

            @Override
            public void actionPerformed(ActionEvent evt) {
//               chancePop.setVisible(true);
//
//               ChanceDialog chanceDialog = new ChanceDialog(frame, "CHANCE CARD",
//                     ModalityType.APPLICATION_MODAL, "<html>ADVANCE TO ST.CHARLES PLACE.<br> IF YOU PASS GO, <br> COLLECT $200</html>");
//               chanceDialog.initUI();
//               chanceDialog.pack();
//               chanceDialog.setLocationRelativeTo(boardPane);
//               chanceDialog.setVisible(true);
//               
//               chancePop.setVisible(false);
            	
            	menuPop.setVisible(true);
            	ManageDialog manageDialog = new ManageDialog(frame, "MANAGE INVENTORY",
                        ModalityType.APPLICATION_MODAL);
            	manageDialog.initUI();
            	manageDialog.pack();
            	manageDialog.setLocationRelativeTo(frame);
                manageDialog.setVisible(true);
                
                menuPop.setVisible(false);
            	
        	
        }});
    	
    	managec.gridx = 1;
    	managec.gridy = 0;
    	managec.weightx = 0.5;
    	managec.ipady = 80;
    	managec.insets = new Insets(5, 5, 5, 5);
    	managec.fill = GridBagConstraints.BOTH;
    	
    	chance = new JButton(new AbstractAction("CHANCE") {

            @Override
            public void actionPerformed(ActionEvent evt) {
               chancePop.setVisible(true);

               ChanceDialog chanceDialog = new ChanceDialog(frame, "CHANCE CARD",
                     ModalityType.APPLICATION_MODAL, GameHandler.getChance());
               chanceDialog.initUI();
               chanceDialog.pack();
               chanceDialog.setLocationRelativeTo(layeredPane);
               chanceDialog.setVisible(true);
               
               chancePop.setVisible(false);
            }});
               
    	community = new JButton(new AbstractAction("CHEST") {

            @Override
            public void actionPerformed(ActionEvent evt) {
               chancePop.setVisible(true);

               ComChestDialog chestDialog = new ComChestDialog(frame, "COMMUNITY CHEST CARD",
                     ModalityType.APPLICATION_MODAL, GameHandler.getCommunity());
               chestDialog.initUI();
               chestDialog.pack();
               chestDialog.setLocationRelativeTo(layeredPane);
               chestDialog.setVisible(true);
               
               chancePop.setVisible(false);
            }});
               
    	
    	buttonHolder.add(buy, buyc);
    	buttonHolder.add(manage, managec);
    	buttonHolder.add(roll, rollc);
    	buttonHolder.add(endTurn, endTurnC);
    	buttonHolder.add(menu, menuc);
    	
    	
//    	buyHolder.add(buy, BorderLayout.CENTER);
//    	buttonHolder.add(roll);
//    	buttonHolder.add(manage);
//    	buttonHolder.add(endTurn);
//    	buttonHolder.add(menu);	
    }
    
    public JFrame getFrame()
    {
    	return frame;
    }
    
    public CardLayout getCards()
    {
    	return switcher;
    }
    
    public JPanel getStartPane()
    {
    	return switchPane;
    }
    
    public JTextArea getLog()
    {
    	return log;
    }
    
    public JButton getRoll()
    {
    	return roll;
    }
    
    public JButton getEndTurn()
    {
    	return endTurn;
    }
    
    public JButton getBuy()
    {
    	return buy;
    }
    
    public JButton getChance()
    {
    	return chance;
    }
    
    public JButton getCommunity()
    {
    	return community;
    }
    
    
    public static BufferedImage createImage(JPanel panel) {

        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        g.dispose();
        System.out.println("reached");
        
        try {
            File outputfile = new File("bufferedboard.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
    

}