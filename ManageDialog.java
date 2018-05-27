import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ManageDialog extends JDialog {
	
	private String money = "100";
	private Dimension buttonD = new Dimension(300, 100);
	private Window frame;
	
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
		 
		 JTextArea properties = new JTextArea("Name: " + GameHandler.getPlayer().getName() + "\n" + "Token: Car\n" + "Wallet: " + GameHandler.getPlayer().getMoney() + "$\n\n ------------------------------- \n\n");
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
			 JDialog tradeDialog = new JDialog(frame, "TRADE",
	                    ModalityType.APPLICATION_MODAL);
			 TradeList list = new TradeList(tradeDialog);
			 tradeDialog.add(list);
			 tradeDialog.pack();
			 list.updateList();
			 tradeDialog.setLocationRelativeTo(frame);
			 tradeDialog.setVisible(true);
			}
		 });
		 boardLabel.setAllSizes(trade, buttonD);
		 //trade.setBorder(new EmptyBorder(10, 10, 20, 20));
		 JButton manProperties = new JButton("PROPERTIES");
		 manProperties.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 JDialog propertiesDialog = new JDialog(frame, "PROPERTIES",
		                    ModalityType.APPLICATION_MODAL);
				 PropertyList propList = new PropertyList(propertiesDialog);
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
		 //exit.setBorder(new EmptyBorder(10, 10, 20, 20));
		 
		 //uiHolder.add(wallet);
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
		 
//		 JList properties = new JList();
//		 properties.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		 
//		 JScrollPane propertyScroller = new JScrollPane(properties);
//		 propertyScroller.setPreferredSize(new Dimension(500, 200));
		 
		 
	}

}
