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
import java.awt.Toolkit;
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
	
	private Dimension dim;
	
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
    	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
    	dim = toolkit.getScreenSize();
    	frame.setSize(dim.width,dim.height);
//    	frame.setExtendedState(frame.getExtendedState() | Frame.MAXIMIZED_BOTH); 
//    	frame.setUndecorated(true);
//    	size = frame.getBounds().getSize();
    	MainMenuPane menuPane = new MainMenuPane(frame, dim);
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
        boardLabel.setAllSizes(gamePane, dim);
        switchPane = new JPanel(new CardLayout());
    	switchPane.add(menuPane, STARTPANEL);
    	switchPane.add(gamePane, GAMEPANEL);
    	menuPane.addElements();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setGlassPane(menuPop);
    	//frame.setPreferredSize(new Dimension(1920,1080));
    	//frame.setMaximumSize(new Dimension(1920,1080));
    	//frame.setMinimumSize(new Dimension(1920,1080));
    	frame.add(switchPane);
        frame.setVisible(true);
        switcher = (CardLayout)(switchPane.getLayout());
        CardSwitcher switchHandler = new CardSwitcher(switchPane, switcher);
        menuPane.passthrough(switchHandler);
    }
    
    public void addBoard()
    {
    	layeredPane = new JLayeredPane();
    	layeredPane.setPreferredSize(new Dimension(1100,1100));
    	layeredPane.revalidate();
    	frame.pack();
    	spritePane = new Board(20);
    	spritePane.setPreferredSize(new Dimension(1000, 1000));
    	spritePane.setBounds(10, ((dim.height) - 1000)/4, 1000, 1000);
    	
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
    	scrollPane.setPreferredSize(new Dimension(330,420));
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
                     ModalityType.APPLICATION_MODAL, Chance.returnString());
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
                     ModalityType.APPLICATION_MODAL, CommunityChest.returnString());
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