import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TradeList extends JPanel implements ListSelectionListener, ActionListener{
	
	private JList mainList;
	private DefaultListModel mainListModel;
	private JList secondList;
	private DefaultListModel secondListModel;
	
	private JTextArea mainArea;
	private JTextArea secondArea;
	
	private JPanel buttonPane;
	private JPanel listPane;
	private JPanel areaPane;
	
	private JButton add;
	private JButton reset;
	private JButton add2;
	private JButton reset2;
	private JButton back;
	private JButton trade;
	
	private JDialog source;
	
	private Dimension buttonD = new Dimension(130, 50);
	
	private String mProperty;
	
	private String oProperty;
	private String tProperty;
	private ArrayList<String> oPropertyTrade = new ArrayList<String>();
	private ArrayList<String> tPropertyTrade = new ArrayList<String>();
	
	private Player otroPlayer;
	
	public TradeList(JDialog source)
	{
		super(new BorderLayout());
		this.source = source;
		mainListModel = new DefaultListModel();
		
		mainList = new JList(mainListModel);
		mainList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		mainList.addListSelectionListener(this);
		mainList.setFont(FontLoader.enableFont(14f));
		mainList.setCellRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				mProperty = value.toString();
			 	int spaceIndex = 0;
	      		for (int i = 0; i < 40; i++)
	      		{
	      			if (GameHandler.getSpaces().get(i).getName().equals(mProperty))
	      			{
	      				spaceIndex = i;
	      			}
	      		}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Railroad)
            	{
	      			Railroad temp = (Railroad)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Utility)
            	{
	      			Utility temp = (Utility)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Property)
            	{
	      			Property temp = (Property)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
	      			else if (temp.getHouses() > 0){
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
	      			}
            	}
				return this;
			}
		});
		JScrollPane mainListScrollPane = new JScrollPane(mainList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainListScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("YOUR INVENTORY")));
		
		secondListModel = new DefaultListModel();
		
		secondList = new JList(secondListModel);
		secondList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		secondList.addListSelectionListener(this);
		secondList.setFont(FontLoader.enableFont(14f));
		secondList.setCellRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				mProperty = value.toString();
			 	int spaceIndex = 0;
	      		for (int i = 0; i < 40; i++)
	      		{
	      			if (GameHandler.getSpaces().get(i).getName().equals(mProperty))
	      			{
	      				spaceIndex = i;
	      			}
	      		}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Railroad)
            	{
	      			Railroad temp = (Railroad)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Utility)
            	{
	      			Utility temp = (Utility)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Property)
            	{
	      			Property temp = (Property)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
            		}
	      			else if (temp.getHouses() > 0){
	      				setBackground(Color.PINK);
	      				add.setEnabled(false);
	      				add2.setEnabled(false);
	      				reset.setEnabled(false);
	      				reset2.setEnabled(false);
	      			}
            	}
				return this;
			}
		});
		JScrollPane secondListScrollPane = new JScrollPane(secondList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		secondListScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("OTHER INVENTORY")));
		
		add = new JButton("ADD");
		reset = new JButton("RESET");
		add2 = new JButton("ADD");
		reset2 = new JButton("RESET");
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 source.dispose();
			 }
		});
		trade = new JButton("TRADE");
		add.setEnabled(false);
        reset.setEnabled(false);
        add2.setEnabled(false);
        reset2.setEnabled(false);
        trade.setEnabled(false);
		boardLabel.setAllSizes(add, buttonD);
		boardLabel.setAllSizes(reset, buttonD);
		boardLabel.setAllSizes(add2, buttonD);
		boardLabel.setAllSizes(reset2, buttonD);
		boardLabel.setAllSizes(back, buttonD);
		boardLabel.setAllSizes(trade, buttonD);
		boardLabel.setAllSizes(mainListScrollPane, new Dimension(300, 360));
		boardLabel.setAllSizes(secondListScrollPane, new Dimension(300,360));
		
		add.addActionListener(this);
		reset.addActionListener(this);
		add2.addActionListener(this);
		reset2.addActionListener(this);
		trade.addActionListener(this);

		
		 mainArea = new JTextArea("");
		 mainArea.setFont(FontLoader.enableFont(14f));
		 mainArea.setEditable(false);
		 
		 JScrollPane mainAreaScroller = new JScrollPane(mainArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 mainAreaScroller.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("ITEMS GIVEN:")));
		 
		 secondArea = new JTextArea("");
		 secondArea.setFont(FontLoader.enableFont(14f));
		 secondArea.setEditable(false);
		 
		 JScrollPane secondAreaScroller = new JScrollPane(secondArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 secondAreaScroller.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("ITEMS TAKEN:")));
		 
		boardLabel.setAllSizes(mainAreaScroller, new Dimension(300, 360));
		boardLabel.setAllSizes(secondAreaScroller, new Dimension(300,360));
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
		buttonPane.add(Box.createRigidArea(new Dimension(30, 30)));
		buttonPane.add(add);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(reset);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 300)));
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(add2);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(reset2);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(back);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(trade);
		buttonPane.setBorder(new EmptyBorder(10,10,10,10));
		
		listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
		listPane.add(Box.createRigidArea(new Dimension(10,10)));
		listPane.add(mainListScrollPane);
		listPane.add(Box.createRigidArea(new Dimension(10,10)));
		listPane.add(secondListScrollPane);
		listPane.setBorder(new EmptyBorder(10,10,10,10));
		
		areaPane = new JPanel();
		areaPane.setLayout(new BoxLayout(areaPane, BoxLayout.PAGE_AXIS));
		areaPane.add(Box.createRigidArea(new Dimension(10,10)));
		areaPane.add(mainAreaScroller);
		areaPane.add(Box.createRigidArea(new Dimension(10,10)));
		areaPane.add(secondAreaScroller);
		areaPane.setBorder(new EmptyBorder(10,10,10,10));
		
		add(listPane, BorderLayout.LINE_START);
		add(buttonPane, BorderLayout.CENTER);
		add(areaPane, BorderLayout.LINE_END);
	}
	
	public void updateList(String player)
	{
		int requestPlayer = 0;
		for (int i = 0; i < GameHandler.getPlayerList().size(); i++)
		{
			if (player.equals(GameHandler.getPlayerList().get(i).getName()))
			{
				requestPlayer = i;
			}
		}
		otroPlayer = GameHandler.getPlayer(requestPlayer);
		for (int i = 0; i < GameHandler.getPlayer().getProperties().size(); i++)
		{
			mainListModel.addElement(GameHandler.getPlayer().getProperties().get(i));
		}
		for (int i = 0; i < GameHandler.getPlayer(requestPlayer).getProperties().size(); i++)
		{
			secondListModel.addElement(GameHandler.getPlayer(requestPlayer).getProperties().get(i));
		}
	}
	
	public void updateList()
	{
		otroPlayer = GameHandler.getNextPlayer();
		for (int i = 0; i < GameHandler.getPlayer().getProperties().size(); i++)
		{
			mainListModel.addElement(GameHandler.getPlayer().getProperties().get(i));
		}
		for (int i = 0; i < GameHandler.getNextPlayer().getProperties().size(); i++)
		{
			secondListModel.addElement(GameHandler.getNextPlayer().getProperties().get(i));
		}
	}
	
	  public void valueChanged(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting() == false) {
	 
	            if (mainList.getSelectedIndex() == -1 && secondList.getSelectedIndex() == -1) {
	            //No selection, disable fire button.
	                add.setEnabled(false);
	                reset.setEnabled(false);
	                add2.setEnabled(false);
	                reset2.setEnabled(false);
	                
	            } else if (mainList.getSelectedIndex() != -1 && secondList.getSelectedIndex() == -1){
	            	add.setEnabled(true);
	                reset.setEnabled(true);
	                add2.setEnabled(false);
	                reset2.setEnabled(false);
	            } else if (mainList.getSelectedIndex() == -1 && secondList.getSelectedIndex() != -1) {
	            	add2.setEnabled(true);
	                reset2.setEnabled(true);
	                add.setEnabled(false);
	                reset.setEnabled(false);
	            } else {
	            	add.setEnabled(true);
	                reset.setEnabled(true);
	                add2.setEnabled(true);
	                reset2.setEnabled(true);
	            }
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton source = (JButton)e.getSource();
		
		if (source == add)
		{
			oProperty = mainList.getSelectedValue().toString();
			mainArea.append(oProperty);
			oPropertyTrade.add(oProperty);
			trade.setEnabled(true);
		}
		
		if (source == reset)
		{
			mainArea.setText("");
			oPropertyTrade.clear();
			trade.setEnabled(false);
		}
		
		if (source == add2)
		{
			tProperty = secondList.getSelectedValue().toString();
			secondArea.append(tProperty);
			tPropertyTrade.add(tProperty);
			trade.setEnabled(true);
		}
		
		if (source == reset2)
		{
			secondArea.setText("");
			tPropertyTrade.clear();
			trade.setEnabled(false);
		}
		
		if (source == trade)
		{
			for (int i = 0; i < oPropertyTrade.size(); i++)
			{
				for (int j = 0; j < 40; j++)
				{
					if (oPropertyTrade.get(i) == GameHandler.getSpaces().get(j).getName())
					{
						GameHandler.getSpaces().get(j).setOwner(otroPlayer);
					}
				}
			}
			mainArea.setText("");
			oPropertyTrade.clear();
			for (int i = 0; i < tPropertyTrade.size(); i++)
			{
				for (int j = 0; j < 40; j++)
				{
					if (tPropertyTrade.get(i) == GameHandler.getSpaces().get(j).getName())
					{
						GameHandler.getSpaces().get(j).setOwner(GameHandler.getPlayer());
					}
				}
			}
			secondArea.setText("");
			tPropertyTrade.clear();
			
			JOptionPane.showMessageDialog(this, "PROPERTY TRADE PROCESSED");
		}
		
	}
	  

}


