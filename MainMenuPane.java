import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPane extends JPanel implements ActionListener{
	
	private JButton play;
	private JButton settings;
	private JButton exit;
	
	private Image backgroundimg;
	
	private JLabel logo;
	
	private Dimension buttonD = new Dimension(500, 200);
	
	private Sandbox pView = new Sandbox();
	
	private JButton source;
	private JPanel sourcePane;
	private JPanel switcherPane;
	private CardLayout switcher;
	private CardLayout layout;
	
	private JFrame frame;
	private CardSwitcher switchHandler;
	
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();

	public MainMenuPane(JFrame frame, Dimension size)
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.frame = frame;
		boardLabel.setAllSizes(this, size);
		try {
		     backgroundimg = ImageIO.read(getClass().getResource("/Wood1.jpg"));
		    } catch (IOException ioe) {
		        ioe.printStackTrace();
		    }
	}
	
	public void addElements()
	{
		play = new JButton("PLAY");
		play.setAlignmentX(Component.CENTER_ALIGNMENT);
		settings = new JButton("SETTINGS");
		settings.setAlignmentX(Component.CENTER_ALIGNMENT);
		settings.setEnabled(false);
		exit = new JButton("EXIT");
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		logo = new JLabel(boardLabel.imgConversion("/monopoly-logo.png"));
		boardLabel.setAllSizes(logo, new Dimension (1271, 334));
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		play.addActionListener(this);
		settings.addActionListener(this);
		exit.addActionListener(this);
		
		boardLabel.setAllSizes(play, buttonD);
		boardLabel.setAllSizes(settings, buttonD);
		boardLabel.setAllSizes(exit, buttonD);
		
		add(Box.createRigidArea(new Dimension(10, 10)));
		add(logo);
		add(Box.createRigidArea(new Dimension(40, 40)));
		add(play);
		add(Box.createRigidArea(new Dimension(10, 10)));
		add(settings);
		add(Box.createRigidArea(new Dimension(10, 10)));
		add(exit);
		add(Box.createRigidArea(new Dimension(10, 10)));
	}
	
	
	public void actionPerformed(ActionEvent event) {

	    source = (JButton)event.getSource();
	    sourcePane = (JPanel)source.getParent();
	    switcherPane = (JPanel)sourcePane.getParent();
	   // JFrame frame = (JFrame)switcherPane.getParent();
	    layout = (CardLayout)switcherPane.getLayout();

	    if (source == play) {
	    
        	PlayerInitMenu playerDialog = new PlayerInitMenu(frame, "SELECT PLAYERS",
                    ModalityType.APPLICATION_MODAL, switchHandler);
        	playerDialog.initUI();
        	playerDialog.pack();
        	playerDialog.setLocationRelativeTo(switcherPane);
            playerDialog.setVisible(true);
	    	
	        //layout.show(switcherPane, Sandbox.GAMEPANEL);;
	    } else if (source == settings){
	    	
	    } else if (source == exit){
	    	
	    	System.exit(0); 
	    }
	    
	    else {
	    	layout.show(switcherPane, Sandbox.GAMEPANEL);
	    }

	    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundimg, 0, 0, width, height, null);
	}	
	
	public void passthrough(CardSwitcher switcher)
	{
		switchHandler = switcher;
	}
}

