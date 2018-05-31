import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ManageDialog extends JDialog {
	
	private String money = "100";
	private Dimension buttonD = new Dimension(300, 100);
	private Window frame;
	private String player = null;
	private JTextArea properties;
	
	public ManageDialog(Window owner, String title, Dialog.ModalityType modalityType)
	{
		super(owner,title, modalityType);
		frame = owner;
	}
	
	public void initUI()
	{
		JPanel managePane = new JPanel(new BorderLayout());
		JPanel uiHolder = new JPanel();
		uiHolder.setLayout(new BoxLayout(uiHolder, BoxLayout.PAGE_AXIS));
		JLabel wallet = new JLabel(money);
		boardLabel.setAllSizes(wallet, buttonD);
		Image resource = null;
		 try {
	            resource = ImageIO.read(getClass().getResource("/Monopoly Dollar.png"));
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
		 
		 StretchIcon result = new StretchIcon(resource, true);
		 
		 wallet.setIcon(result);
		 wallet.setHorizontalTextPosition(JLabel.LEADING);
		 
		 properties = new JTextArea("Name: " + GameHandler.getPlayer().getName() + "\n" + "Wallet: " + GameHandler.getPlayer().getMoney() + "$\n\n ------------------------------- \n\n");
		 properties.setFont(FontLoader.enableFont(14f));
		 properties.setEditable(false);
		 
		 JScrollPane propertyScroller = new JScrollPane(properties,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 propertyScroller.setPreferredSize(new Dimension(400,200));
		 
		 JLabel header = new JLabel("PLAYER INFO");
		 header.setFont(FontLoader.enableFont(16f));
		 
		 propertyScroller.setColumnHeaderView(header);
		 propertyScroller.setBorder(new EmptyBorder(10,10,10,10));
		 
		 
		 JButton trade = new JButton("TRADE");
		 trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameHandler.getNumPlayers() > 2)
				{
				JDialog tradeWho = new JDialog(frame, "TRADE OPTIONS", ModalityType.APPLICATION_MODAL);
				JPanel cardPane = new JPanel();
				JTextField otherPlayer = new JTextField(20);
				otherPlayer.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e)
					{
						String text = otherPlayer.getText();
						for(int i = 0; i < GameHandler.getPlayerList().size(); i++)
						{
				
							if(text.equals(GameHandler.getPlayerList().get(i).getName()))
							{
								player = text;
								tradeWho.dispose();
								JDialog tradeDialog = new JDialog(frame, "TRADE",
					                    ModalityType.APPLICATION_MODAL);
								TradeList list = new TradeList(tradeDialog, properties);
								tradeDialog.add(list);
								tradeDialog.pack();
								list.updateList(player);
								tradeDialog.setLocationRelativeTo(frame);
							 	tradeDialog.setVisible(true);
							}
						}
						if (player == null)
						{
							JOptionPane.showMessageDialog(frame, "PLAYER NOT FOUND.", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
					
					});
				JButton back = new JButton(new AbstractAction("BACK") {
					public void actionPerformed(ActionEvent e) {
						tradeWho.dispose();
					}
				});
				cardPane.add(otherPlayer);
				cardPane.add(back);
				tradeWho.setContentPane(cardPane);
				tradeWho.pack();
				tradeWho.setLocationRelativeTo(frame);
				tradeWho.setVisible(true);
				}
				else
				{
					JDialog tradeDialog = new JDialog(frame, "TRADE",
		                    ModalityType.APPLICATION_MODAL);
					TradeList list = new TradeList(tradeDialog, properties);
					tradeDialog.add(list);
					tradeDialog.pack();
					list.updateList();
					tradeDialog.setLocationRelativeTo(frame);
				 	tradeDialog.setVisible(true);
				}
			}
		 });
		 boardLabel.setAllSizes(trade, buttonD);
		 JButton manProperties = new JButton("PROPERTIES");
		 manProperties.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 JDialog propertiesDialog = new JDialog(frame, "PROPERTIES",
		                    ModalityType.APPLICATION_MODAL);
				 PropertyList propList = new PropertyList(propertiesDialog, properties);
				 propertiesDialog.add(propList);
				 propList.updateList();
				 propertiesDialog.pack();
				 propertiesDialog.setLocationRelativeTo(frame);
	             propertiesDialog.setVisible(true);
			 }
		 });
		 boardLabel.setAllSizes(manProperties, buttonD);
		 JButton exit = new JButton("EXIT");
		 boardLabel.setAllSizes(exit, buttonD);
		 exit.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
		 });
		 uiHolder.add(Box.createRigidArea(new Dimension(10, 10)));
		 uiHolder.add(trade);
		 uiHolder.add(Box.createRigidArea(new Dimension(10, 10)));
		 uiHolder.add(manProperties);
		 uiHolder.add(Box.createRigidArea(new Dimension(10, 10)));
		 uiHolder.add(exit);
		 uiHolder.setBorder(new EmptyBorder(10,10,10,10));
		 
		 managePane.add(uiHolder, BorderLayout.LINE_START);
		 managePane.add(propertyScroller, BorderLayout.LINE_END);
		 
		 setContentPane(managePane);
		 pack();
		 
		 
	}
	

}
