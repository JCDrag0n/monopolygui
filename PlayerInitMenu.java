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
	private JPanel buttonUI;
	
	private JPanel switcherPane;
	
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton cancel;
	private JButton source;
	private JButton back;
	private JButton start;
	
	private JRadioButton boot, boot2;
	private JRadioButton car, car2;
	private JRadioButton dog, dog2;
	private JRadioButton iron, iron2;
	private JRadioButton thimble, thimble2;
	private JRadioButton topHat, topHat2;
	private JRadioButton wheelbarrow, wheelbarrow2;
	
	private ButtonGroup icons, icons2;
	
	private JPanel sourcePane, sourcePane2;
	private JPanel sourceSwitcherPane;
	
	private JTextField playerOneName, playerTwoName, playerThreeName, playerFourName;
	private JLabel textFieldLabel1, textFieldLabel2, textFieldLabel3, textFieldLabel4;
	
	
	private CardLayout switcher;
	private CardLayout layout;
			
	private CardSwitcher switchHandler;
	
	private Dimension buttonD = new Dimension(300, 100);
	private Dimension labelD = new Dimension(150, 20);
	private Dimension fieldD = new Dimension(200, 20);
	
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
		buttonUI = new JPanel();
		buttonUI.setLayout(new BoxLayout(buttonUI, BoxLayout.PAGE_AXIS));
		switcherPane = new JPanel();
		switcherPane.setLayout(new CardLayout());
		
		
		
		two = new JButton("TWO PLAYERS");
		three = new JButton("THREE PLAYERS");
		four = new JButton("FOUR PLAYERS");
		cancel = new JButton("CANCEL");
		start = new JButton("START");
		back = new JButton("BACK");
		
		icons = new ButtonGroup();
		icons2 = new ButtonGroup();
		
		boot = new JRadioButton("BOOT");
		icons.add(boot);
		car = new JRadioButton("CAR");
		icons.add(car);
		dog = new JRadioButton("DOG");
		icons.add(dog);
		iron = new JRadioButton("IRON");
		icons.add(iron);
		thimble = new JRadioButton("THIMBLE");
		icons.add(thimble);
		topHat = new JRadioButton("TOPHAT");
		icons.add(topHat);
		wheelbarrow = new JRadioButton("WHEELBARROW");
		icons.add(wheelbarrow);
		
		boot2 = new JRadioButton("BOOT");
		icons2.add(boot2);
		car2 = new JRadioButton("CAR");
		icons2.add(car2);
		dog2 = new JRadioButton("DOG");
		icons2.add(dog2);
		iron2 = new JRadioButton("IRON");
		icons2.add(iron2);
		thimble2 = new JRadioButton("THIMBLE");
		icons2.add(thimble2);
		topHat2 = new JRadioButton("TOPHAT");
		icons2.add(topHat2);
		wheelbarrow2 = new JRadioButton("WHEELBARROW");
		icons2.add(wheelbarrow2);
		
//		two.setVisible(true);
//		three.setVisible(true);
//		four.setVisible(true);
//		cancel.setVisible(true);
//		back.setVisible(true);
//		
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		cancel.addActionListener(this);
		start.addActionListener(this);
		back.addActionListener(this);
		
		two.setAlignmentX(Component.CENTER_ALIGNMENT);
		three.setAlignmentX(Component.CENTER_ALIGNMENT);
		four.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		boardLabel.setAllSizes(two, buttonD);
		boardLabel.setAllSizes(three, buttonD);
		boardLabel.setAllSizes(four, buttonD);
		boardLabel.setAllSizes(cancel, buttonD);
		boardLabel.setAllSizes(start, buttonD);
		boardLabel.setAllSizes(back, buttonD);
		
		playerOneName = new JTextField(15);
		playerTwoName = new JTextField(15);
		playerThreeName = new JTextField(15);
		playerFourName = new JTextField(15);
		
		boardLabel.setAllSizes(playerOneName, fieldD);
		boardLabel.setAllSizes(playerTwoName, fieldD);
		boardLabel.setAllSizes(playerThreeName, fieldD);
		boardLabel.setAllSizes(playerFourName, fieldD);
		
		textFieldLabel1 = new JLabel("PLAYER ONE NAME:");
		textFieldLabel2 = new JLabel("PLAYER TWO NAME:");
		textFieldLabel3 = new JLabel("PLAYER THREE NAME:");
		textFieldLabel4 = new JLabel("PLAYER FOUR NAME:");
		
		boardLabel.setAllSizes(textFieldLabel1, labelD);
		boardLabel.setAllSizes(textFieldLabel2, labelD);
		boardLabel.setAllSizes(textFieldLabel3, labelD);
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
		playerPane2.add(textFieldLabel2);
		playerPane2.add(playerTwoName);
		playerPane.add(boot);
		playerPane.add(car);
		playerPane.add(dog);
		playerPane.add(iron);
		playerPane.add(thimble);
		playerPane.add(topHat);
		playerPane.add(wheelbarrow);
		playerPane2.add(boot2);
		playerPane2.add(car2);
		playerPane2.add(dog2);
		playerPane2.add(iron2);
		playerPane2.add(thimble2);
		playerPane2.add(topHat2);
		playerPane2.add(wheelbarrow2);
		initPlayerPaneTwo.add(playerPane, BorderLayout.LINE_START);
		initPlayerPaneTwo.add(Box.createRigidArea(new Dimension(10,10)), BorderLayout.CENTER);
		initPlayerPaneTwo.add(playerPane2, BorderLayout.LINE_END);
		buttonUI.add(start);
		buttonUI.add(back);
		initPlayerPaneTwo.add(buttonUI, BorderLayout.PAGE_END);
		initPlayerPaneTwo.setBorder(new EmptyBorder(10,10,10,10));
		
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
    	//switcherPane.add(initPlayerPaneThree, PLAYERPANELTHREE);
    	//switcherPane.add(initPlayerPaneFour, PLAYERPANELFOUR);
    	
    	setContentPane(switcherPane);
    	//pack();
		
		switcher = (CardLayout)(switcherPane.getLayout());
		
		
		
	}
	
	public void actionPerformed(ActionEvent event) {

	    source = (JButton)event.getSource();

	    if (source == two) {
	    	sourcePane = (JPanel)source.getParent();
	 	    sourceSwitcherPane = (JPanel)sourcePane.getParent();
	 	    layout = (CardLayout)sourceSwitcherPane.getLayout();
	        layout.show(sourceSwitcherPane, PLAYERPANELTWO);
	    } else if (source == three){
	    	 sourcePane = (JPanel)source.getParent();
	 	    sourceSwitcherPane = (JPanel)sourcePane.getParent();
	 	    layout = (CardLayout)sourceSwitcherPane.getLayout();
	    	 layout.show(sourceSwitcherPane, PLAYERPANELTHREE);
	    	
	    } else if (source == four){
	    	 sourcePane = (JPanel)source.getParent();
	 	    sourceSwitcherPane = (JPanel)sourcePane.getParent();
	 	    layout = (CardLayout)sourceSwitcherPane.getLayout();
	    	
	    	 layout.show(sourceSwitcherPane, PLAYERPANELFOUR); 
	    }
	    
	    else if (source == cancel) {
	    	
	    	dispose();
	    }
	    
	    else if (source == back) {
	    	
	    	layout.show(sourceSwitcherPane, INITPANEL);
	    	
	    }
	    
	    else if (source == start) {

	    	switchHandler.switchTo(Sandbox.GAMEPANEL);
	    	dispose();
	    }

	    }

}
