import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PlayerInitMenu extends JDialog implements ActionListener{
	
	private JPanel initAmountPane;
	private JPanel initPlayerPaneTwo;
	private JPanel initPlayerPaneThree;
	private JPanel initPlayerPaneFour;
	private JPanel playerPane;
	private JPanel playerPane2;
	private JPanel playerPane32;
	private JPanel playerPane3;
	private JPanel playerPane43;
	private JPanel playerPane4;
	private JPanel buttonUI;
	private JPanel buttonUI3;
	private JPanel buttonUI4;
	
	private JPanel switcherPane;
	
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton cancel;
	private JButton source;
	private JButton back;
	private JButton start;
	private JButton p3back;
	private JButton p3start;
	private JButton p4back;
	private JButton p4start;
	
	private JComboBox oneTokenList;
	private JComboBox twoTokenList;
	private JComboBox threeTokenList;
	
	private JComboBox p3oneTokenList;
	private JComboBox p3twoTokenList;
	private JComboBox p3threeTokenList;
	
	private JComboBox p4oneTokenList;
	private JComboBox p4twoTokenList;
	private JComboBox p4threeTokenList;
	private JComboBox fourTokenList;
	
	private ButtonGroup icons, icons2;
	
	private JPanel sourcePane, sourcePane2;
	private JPanel sourceSwitcherPane;
	
	private JTextField playerOneName, playerTwoName, p3playerOneName, p3playerTwoName, p3playerThreeName, p4playerOneName, p4playerTwoName, p4playerThreeName, playerFourName;
	private JLabel textFieldLabel1, textFieldLabel2, t3textFieldLabel1, t3textFieldLabel2, t3textFieldLabel3, t4textFieldLabel1, t4textFieldLabel2, t4textFieldLabel3, textFieldLabel4;
	
	private String pOneName;
	private String pTwoName;
	private String pThreeName;
	private String pFourName;
	
	private String[] tokens = { "", "Boot", "Car", "Dog", "Iron", "Thimble", "TopHat", "WheelBarrow" };
	
	private CardLayout switcher;
	private CardLayout layout;
			
	private CardSwitcher switchHandler;
	
	private int numofPlayers;
	
	private Dimension buttonD = new Dimension(300, 100);
	private Dimension labelD = new Dimension(150, 20);
	private Dimension fieldD = new Dimension(200, 20);
	
	private static String pOneToken;
	private static String pTwoToken;
	private static String pThreeToken;
	private static String pFourToken;
	
	final static String INITPANEL = "INIT";
	final static String PLAYERPANELTWO = "TWO";
	final static String PLAYERPANELTHREE = "THREE";
	final static String PLAYERPANELFOUR = "FOUR";
	
	public PlayerInitMenu(Window owner, String title, Dialog.ModalityType modalityType, CardSwitcher source)
	{
		super(owner,title, modalityType);
		switchHandler = source;
	}
	
	public void initUI()
	{
		
		GridBagConstraints ui = new GridBagConstraints();
		initAmountPane = new JPanel();
		initAmountPane.setLayout(new BoxLayout(initAmountPane, BoxLayout.PAGE_AXIS));
		
		initPlayerPaneTwo = new JPanel();
		initPlayerPaneTwo.setLayout(new BorderLayout());
		
		initPlayerPaneThree = new JPanel();
		initPlayerPaneFour = new JPanel();
		
		playerPane = new JPanel();
		playerPane.setLayout(new BoxLayout(playerPane, BoxLayout.PAGE_AXIS));
		
		playerPane2 = new JPanel();
		playerPane2.setLayout(new BoxLayout(playerPane2, BoxLayout.PAGE_AXIS));
		
		playerPane3 = new JPanel();
		playerPane3.setLayout(new BoxLayout(playerPane3, BoxLayout.PAGE_AXIS));
		
		playerPane32 = new JPanel();
		playerPane32.setLayout(new BoxLayout(playerPane32, BoxLayout.PAGE_AXIS));
		
		playerPane4 = new JPanel();
		playerPane4.setLayout(new BoxLayout(playerPane4, BoxLayout.PAGE_AXIS));
		
		playerPane43 = new JPanel();
		playerPane43.setLayout(new BoxLayout(playerPane43, BoxLayout.PAGE_AXIS));
		
		buttonUI = new JPanel();
		buttonUI.setLayout(new BoxLayout(buttonUI, BoxLayout.PAGE_AXIS));
		
		buttonUI3 = new JPanel();
		buttonUI3.setLayout(new BoxLayout(buttonUI3, BoxLayout.PAGE_AXIS));
		
		buttonUI4 = new JPanel();
		buttonUI4.setLayout(new BoxLayout(buttonUI4, BoxLayout.PAGE_AXIS));
		
		switcherPane = new JPanel();
		switcherPane.setLayout(new CardLayout());
		
		two = new JButton("TWO PLAYERS");
		three = new JButton("THREE PLAYERS");
		four = new JButton("FOUR PLAYERS");
		cancel = new JButton("CANCEL");
		start = new JButton("START");
		back = new JButton("BACK");
		p3start = new JButton("START");
		p3back = new JButton("BACK");
		p4start = new JButton("START");
		p4back = new JButton("BACK");
		
		oneTokenList = new JComboBox(tokens);
		oneTokenList.setSelectedIndex(0);
		oneTokenList.addActionListener(this);
		
		twoTokenList = new JComboBox(tokens);
		twoTokenList.setSelectedIndex(0);
		twoTokenList.addActionListener(this);
		
		p3oneTokenList = new JComboBox(tokens);
		p3oneTokenList.setSelectedIndex(0);
		p3oneTokenList.addActionListener(this);
		
		p3twoTokenList = new JComboBox(tokens);
		p3twoTokenList.setSelectedIndex(0);
		p3twoTokenList.addActionListener(this);
		
		p3threeTokenList = new JComboBox(tokens);
		p3threeTokenList.setSelectedIndex(0);
		p3threeTokenList.addActionListener(this);
		
		p4oneTokenList = new JComboBox(tokens);
		p4oneTokenList.setSelectedIndex(0);
		p4oneTokenList.addActionListener(this);
		
		p4twoTokenList = new JComboBox(tokens);
		p4twoTokenList.setSelectedIndex(0);
		p4twoTokenList.addActionListener(this);
		
		p4threeTokenList = new JComboBox(tokens);
		p4threeTokenList.setSelectedIndex(0);
		p4threeTokenList.addActionListener(this);
		
		fourTokenList = new JComboBox(tokens);
		fourTokenList.setSelectedIndex(0);
		fourTokenList.addActionListener(this);
		
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		cancel.addActionListener(this);
		start.addActionListener(this);
		back.addActionListener(this);
		p3start.addActionListener(this);
		p3back.addActionListener(this);
		p4start.addActionListener(this);
		p4back.addActionListener(this);
		
		oneTokenList.addActionListener(this);
		twoTokenList.addActionListener(this);
		p3oneTokenList.addActionListener(this);
		p3twoTokenList.addActionListener(this);
		p3threeTokenList.addActionListener(this);
		p4oneTokenList.addActionListener(this);
		p4twoTokenList.addActionListener(this);
		p4threeTokenList.addActionListener(this);
		fourTokenList.addActionListener(this);
		
		boardLabel.setAllSizes(oneTokenList, labelD);
		boardLabel.setAllSizes(twoTokenList, labelD);
		boardLabel.setAllSizes(p3oneTokenList, labelD);
		boardLabel.setAllSizes(p3twoTokenList, labelD);
		boardLabel.setAllSizes(p3threeTokenList, labelD);
		boardLabel.setAllSizes(p4oneTokenList, labelD);
		boardLabel.setAllSizes(p4twoTokenList, labelD);
		boardLabel.setAllSizes(p4threeTokenList, labelD);
		boardLabel.setAllSizes(fourTokenList, labelD);
		
		two.setAlignmentX(Component.CENTER_ALIGNMENT);
		three.setAlignmentX(Component.CENTER_ALIGNMENT);
		four.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		p3start.setAlignmentX(Component.CENTER_ALIGNMENT);
		p3back.setAlignmentX(Component.CENTER_ALIGNMENT);
		p4start.setAlignmentX(Component.CENTER_ALIGNMENT);
		p4back.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		boardLabel.setAllSizes(two, buttonD);
		boardLabel.setAllSizes(three, buttonD);
		boardLabel.setAllSizes(four, buttonD);
		boardLabel.setAllSizes(cancel, buttonD);
		boardLabel.setAllSizes(start, buttonD);
		boardLabel.setAllSizes(back, buttonD);
		boardLabel.setAllSizes(p3start, buttonD);
		boardLabel.setAllSizes(p3back, buttonD);
		boardLabel.setAllSizes(p4start, buttonD);
		boardLabel.setAllSizes(p4back, buttonD);
		
		playerOneName = new JTextField(15);
		playerTwoName = new JTextField(15);
		
		p3playerOneName = new JTextField(15);
		p3playerTwoName = new JTextField(15);
		p3playerThreeName = new JTextField(15);
		
		p4playerOneName = new JTextField(15);
		p4playerTwoName = new JTextField(15);
		p4playerThreeName = new JTextField(15);
		playerFourName = new JTextField(15);
		
		boardLabel.setAllSizes(playerOneName, fieldD);
		boardLabel.setAllSizes(playerTwoName, fieldD);
		boardLabel.setAllSizes(p3playerOneName, fieldD);
		boardLabel.setAllSizes(p3playerTwoName, fieldD);
		boardLabel.setAllSizes(p3playerThreeName, fieldD);
		boardLabel.setAllSizes(p4playerOneName, fieldD);
		boardLabel.setAllSizes(p4playerTwoName, fieldD);
		boardLabel.setAllSizes(p4playerThreeName, fieldD);
		boardLabel.setAllSizes(playerFourName, fieldD);
		
		textFieldLabel1 = new JLabel("PLAYER ONE NAME:");
		textFieldLabel2 = new JLabel("PLAYER TWO NAME:");
		
		t3textFieldLabel1 = new JLabel("PLAYER ONE NAME:");
		t3textFieldLabel2 = new JLabel("PLAYER TWO NAME:");
		t3textFieldLabel3 = new JLabel("PLAYER THREE NAME:");
		
		t4textFieldLabel1 = new JLabel("PLAYER ONE NAME:");
		t4textFieldLabel2 = new JLabel("PLAYER TWO NAME:");
		t4textFieldLabel3 = new JLabel("PLAYER THREE NAME:");
		textFieldLabel4 = new JLabel("PLAYER FOUR NAME:");
		
		boardLabel.setAllSizes(textFieldLabel1, labelD);
		boardLabel.setAllSizes(textFieldLabel2, labelD);
		boardLabel.setAllSizes(t3textFieldLabel1, labelD);
		boardLabel.setAllSizes(t3textFieldLabel2, labelD);
		boardLabel.setAllSizes(t3textFieldLabel3, labelD);
		boardLabel.setAllSizes(t4textFieldLabel1, labelD);
		boardLabel.setAllSizes(t4textFieldLabel2, labelD);
		boardLabel.setAllSizes(t4textFieldLabel3, labelD);
		boardLabel.setAllSizes(textFieldLabel4, labelD);
		
		initAmountPane.add(Box.createRigidArea(new Dimension(10, 10)));
		initAmountPane.add(two);
		initAmountPane.add(Box.createRigidArea(new Dimension(10, 10)));
		initAmountPane.add(three);
		initAmountPane.add(Box.createRigidArea(new Dimension(10, 10)));
		initAmountPane.add(four);
		initAmountPane.add(Box.createRigidArea(new Dimension(10, 10)));
		initAmountPane.add(cancel);
		initAmountPane.setBorder(new EmptyBorder(10,10,10,10));
		
		
		playerPane.add(textFieldLabel1);
		playerPane.add(playerOneName);
		playerPane.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane.add(oneTokenList);
		playerPane.add(Box.createVerticalGlue());
		
		playerPane2.add(textFieldLabel2);
		playerPane2.add(playerTwoName);
		playerPane2.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane2.add(twoTokenList);
		playerPane2.add(Box.createVerticalGlue());
		
		playerPane3.add(t3textFieldLabel1);
		playerPane3.add(p3playerOneName);
		playerPane3.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane3.add(p3oneTokenList);
		playerPane3.add(Box.createRigidArea(new Dimension(30, 30)));
		playerPane3.add(t3textFieldLabel3);
		playerPane3.add(p3playerThreeName);
		playerPane3.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane3.add(p3threeTokenList);
		playerPane3.add(Box.createVerticalGlue());
		
		playerPane32.add(t3textFieldLabel2);
		playerPane32.add(p3playerTwoName);
		playerPane32.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane32.add(p3twoTokenList);
		playerPane32.add(Box.createVerticalGlue());
		
		playerPane43.add(t4textFieldLabel1);
		playerPane43.add(p4playerOneName);
		playerPane43.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane43.add(p4oneTokenList);
		playerPane43.add(Box.createRigidArea(new Dimension(30, 30)));
		playerPane43.add(t4textFieldLabel3);
		playerPane43.add(p4playerThreeName);
		playerPane43.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane43.add(p4threeTokenList);
		playerPane43.add(Box.createVerticalGlue());

		
		playerPane4.add(t4textFieldLabel2);
		playerPane4.add(p4playerTwoName);
		playerPane4.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane4.add(p4twoTokenList);
		playerPane4.add(Box.createRigidArea(new Dimension(30, 30)));
		playerPane4.add(textFieldLabel4);
		playerPane4.add(playerFourName);
		playerPane4.add(Box.createRigidArea(new Dimension(10, 10)));
		playerPane4.add(fourTokenList);
		playerPane4.add(Box.createVerticalGlue());
		
		
		initPlayerPaneTwo.add(playerPane, BorderLayout.LINE_START);
		initPlayerPaneTwo.add(Box.createRigidArea(new Dimension(10,10)), BorderLayout.CENTER);
		initPlayerPaneTwo.add(playerPane2, BorderLayout.LINE_END);
		buttonUI.add(start);
		buttonUI.add(back);
		initPlayerPaneTwo.add(buttonUI, BorderLayout.PAGE_END);
		initPlayerPaneTwo.setBorder(new EmptyBorder(10,10,10,10));
		
		initPlayerPaneThree.add(playerPane3, BorderLayout.LINE_START);
		initPlayerPaneThree.add(Box.createRigidArea(new Dimension(10,10)), BorderLayout.CENTER);
		initPlayerPaneThree.add(playerPane32, BorderLayout.LINE_END);
		buttonUI3.add(p3start);
		buttonUI3.add(p3back);
		initPlayerPaneThree.add(buttonUI3, BorderLayout.PAGE_END);
		initPlayerPaneThree.setBorder(new EmptyBorder(10,10,10,10));
		
		initPlayerPaneFour.add(playerPane43, BorderLayout.LINE_START);
		initPlayerPaneFour.add(Box.createRigidArea(new Dimension(10,10)), BorderLayout.CENTER);
		initPlayerPaneFour.add(playerPane4, BorderLayout.LINE_END);
		buttonUI4.add(p4start);
		buttonUI4.add(p4back);
		initPlayerPaneFour.add(buttonUI4, BorderLayout.PAGE_END);
		initPlayerPaneFour.setBorder(new EmptyBorder(10,10,10,10));

		
		//boardLabel.setAllSizes(initPlayerPaneTwo, new Dimension(500, 200));
//		
//		initPlayerPaneThree.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneThree.add(two);
//		initPlayerPaneThree.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneThree.add(three);
//		initPlayerPaneThree.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneThree.add(four);
//		initPlayerPaneThree.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneThree.add(cancel);
//		initPlayerPaneThree.setBorder(new EmptyBorder(10,10,10,10));
//		
//		initPlayerPaneFour.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneFour.add(two);
//		initPlayerPaneFour.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneFour.add(three);
//		initPlayerPaneFour.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneFour.add(four);
//		initPlayerPaneFour.add(Box.createRigidArea(new Dimension(10, 10)));
//		initPlayerPaneFour.add(cancel);
//		initPlayerPaneFour.setBorder(new EmptyBorder(10,10,10,10));
		
		
		switcherPane.add(initAmountPane, INITPANEL);
    	switcherPane.add(initPlayerPaneTwo, PLAYERPANELTWO);
    	switcherPane.add(initPlayerPaneThree, PLAYERPANELTHREE);
    	switcherPane.add(initPlayerPaneFour, PLAYERPANELFOUR);
    	//switcherPane.add(initPlayerPaneThree, PLAYERPANELTHREE);
    	//switcherPane.add(initPlayerPaneFour, PLAYERPANELFOUR);
    	
    	setContentPane(switcherPane);
    	//pack();
		
		switcher = (CardLayout)(switcherPane.getLayout());
		start.setEnabled(false);
		p3start.setEnabled(false);
		p4start.setEnabled(false);
		
		
		
	}
	
	public void actionPerformed(ActionEvent event) {

	    if (event.getSource() instanceof JButton)
	    {
	    	source = (JButton)event.getSource();
	    	if (source == two) {
	    		
		    	sourcePane = (JPanel)source.getParent();
		 	    sourceSwitcherPane = (JPanel)sourcePane.getParent();
		 	    layout = (CardLayout)sourceSwitcherPane.getLayout();
		        layout.show(sourceSwitcherPane, PLAYERPANELTWO);
		        numofPlayers = 2;
		        
		    } else if (source == three){
		    	
		    	 sourcePane = (JPanel)source.getParent();
		 	     sourceSwitcherPane = (JPanel)sourcePane.getParent();
		 	     layout = (CardLayout)sourceSwitcherPane.getLayout();
		    	 layout.show(sourceSwitcherPane, PLAYERPANELTHREE);
		    	 numofPlayers = 3;
		    	
		    } else if (source == four){
		    	
		    	sourcePane = (JPanel)source.getParent();
		 	    sourceSwitcherPane = (JPanel)sourcePane.getParent();
		 	    layout = (CardLayout)sourceSwitcherPane.getLayout();
		    	layout.show(sourceSwitcherPane, PLAYERPANELFOUR); 
		    	numofPlayers = 4;
		    }
		    
		    else if (source == cancel) {
		    	
		    	dispose();
		    }
		    
		    else if (source == back || source == p3back || source == p4back) {
		    	
		    	layout.show(sourceSwitcherPane, INITPANEL);
		    	
		    }
		    
		    else if (source == start || source == p3start || source == p4start) {

		    	//switchHandler.switchTo(Sandbox.GAMEPANEL);
		    	if (numofPlayers == 2) {
		    		pOneName = playerOneName.getText();
		    		pTwoName = playerTwoName.getText();
		    		pThreeName = "";
		    		pFourName = "";
		    	}
		    	
		    	if (numofPlayers == 3) {
		    		pOneName = p3playerOneName.getText();
			    	pTwoName = p3playerTwoName.getText();
			    	pThreeName = p3playerThreeName.getText();
			    	pFourName = ""; 
		    	}
		    	
		    	if (numofPlayers == 4) {
		    		pOneName = p3playerOneName.getText();
			    	pTwoName = p3playerTwoName.getText();
			    	pThreeName = p3playerThreeName.getText();
			    	pFourName = playerFourName.getText(); 
		    	}
		    	GameHandler test = new GameHandler(pOneName, pTwoName, pThreeName, pFourName, pOneToken, pTwoToken, pThreeToken, pFourToken, switchHandler, numofPlayers);
		    	dispose();
		    	
		    }
	    }
	    
	    if (event.getSource() instanceof JComboBox)
	    {
			JComboBox cb = (JComboBox)event.getSource();
	        String tokenName = (String)cb.getSelectedItem();
	        int n = 0;
	        if (cb == oneTokenList || cb == p3oneTokenList || cb == p4oneTokenList)
	        {
	        	n = 1;
	        }
	        else if (cb == twoTokenList || cb == p3twoTokenList || cb == p4twoTokenList)
	        {
	        	n = 2;
	        }
	        else if (cb == threeTokenList || cb == p3threeTokenList || cb == p4threeTokenList)
	        {
	        	n = 3;
	        }
	        else if (cb == fourTokenList)
	        {
	        	n = 4;
	        }
	        if (tokenName.equals(""))
	        {
	        	start.setEnabled(false);
	        	p3start.setEnabled(false);
	        	p4start.setEnabled(false);
	        }
	        if (tokenName.equals("Boot"))
	        {
	        	PlayerInitMenu.setToken("/Boot.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("Car"))
	        {
	        	PlayerInitMenu.setToken("/Car.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("Dog"))
	        {
	        	PlayerInitMenu.setToken("/Dog.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("Iron"))
	        {
	        	PlayerInitMenu.setToken("/Iron.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("Thimble"))
	        {
	        	PlayerInitMenu.setToken("/Thimble.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("TopHat"))
	        {
	        	PlayerInitMenu.setToken("/TopHat.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	        if (tokenName.equals("WheelBarrow"))
	        {
	        	PlayerInitMenu.setToken("/Wheelbarrow.png", n);
	        	start.setEnabled(true);
	        	p3start.setEnabled(true);
	        	p4start.setEnabled(true);
	        }
	    }

	    

	    }
	
	public static void setToken(String source, int n)
	{
		switch (n) {
		case 1: pOneToken = source;
		break;
		case 2: pTwoToken = source;
		break;
		case 3: pThreeToken = source;
		break;
		case 4: pFourToken = source;
		break;
		}
	}

}
