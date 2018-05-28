import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PropertyList extends JPanel implements ListSelectionListener, ActionListener{

	private JList list;
	private DefaultListModel listModel;
	private JPanel buttonPane;
	
	private JButton mortgage;
	private JButton unmortgage;
	private JButton addHouses;
	private JButton sellHouses;
	private JButton back;
	
	private JDialog source;
	
	private Dimension buttonD = new Dimension(130, 50);
	private String property;
	private String mProperty;
	
	public PropertyList(JDialog source)
	{
		super(new BorderLayout());
		this.source = source;
	
		listModel = new DefaultListModel();
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setFont(FontLoader.enableFont(16f));
		list.setCellRenderer(new DefaultListCellRenderer() {
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
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Utility)
            	{
	      			Utility temp = (Utility)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
            		}
            	}
	      		if (GameHandler.getSpaces().get(spaceIndex) instanceof Property)
            	{
	      			Property temp = (Property)GameHandler.getSpaces().get(spaceIndex);
	      			if(temp.getMortgageState())
            		{
	      				setBackground(Color.PINK);
            		}
            	}
				return this;
			}
		});
		JScrollPane listScrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("LIST OF PROPERTIES")));
		
		mortgage = new JButton("MORTGAGE");
		mortgage.addActionListener(this);
		unmortgage = new JButton("UNMORTGAGE");
		unmortgage.addActionListener(this);
		addHouses = new JButton("ADD HOUSES");
		addHouses.addActionListener(this);
		sellHouses = new JButton("SELL HOUSES");
		sellHouses.addActionListener(this);
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 source.dispose();
			 }
		});
	    mortgage.setEnabled(false);
        unmortgage.setEnabled(false);
        addHouses.setEnabled(false);
        sellHouses.setEnabled(false);
		boardLabel.setAllSizes(mortgage, buttonD);
		boardLabel.setAllSizes(unmortgage, buttonD);
		boardLabel.setAllSizes(addHouses, buttonD);
		boardLabel.setAllSizes(sellHouses, buttonD);
		boardLabel.setAllSizes(back, buttonD);
		boardLabel.setAllSizes(listScrollPane, new Dimension(300, 360));
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(mortgage);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(unmortgage);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(addHouses);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(sellHouses);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(back);
		buttonPane.setBorder(new EmptyBorder(10,10,10,10));
		
		add(listScrollPane, BorderLayout.LINE_START);
		add(buttonPane, BorderLayout.LINE_END);
	}
	
	public void updateList()
	{
		listModel.removeAllElements();
		for (int i = 0; i < GameHandler.getPlayer().getProperties().size(); i++)
		{	
			listModel.addElement(GameHandler.getPlayer().getProperties().get(i));
		}
	}
	
	  public void valueChanged(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting() == false) {
	            if (list.getSelectedIndex() == -1) {
	                mortgage.setEnabled(false);
	                unmortgage.setEnabled(false);
	                addHouses.setEnabled(false);
	                sellHouses.setEnabled(false);
	            } else {
	            	property = list.getSelectedValue().toString();
	            	int spaceIndex = 0;
	            	for (int i = 0; i < 40; i++)
	            	{
	            		if (GameHandler.getSpaces().get(i).getName().equals(property))
	            		{
	            			spaceIndex = i;
	            		}
	            	}
	            	
	            	if (GameHandler.getSpaces().get(spaceIndex) instanceof Railroad)
	            	{
	            		addHouses.setEnabled(false);
		                sellHouses.setEnabled(false);
		                Railroad temp = (Railroad)GameHandler.getSpaces().get(spaceIndex);
	            		if(temp.getMortgageState())
	            		{
	            			mortgage.setEnabled(false);
	            			unmortgage.setEnabled(true);
	            		}
	            		else {
	            			mortgage.setEnabled(true);
	            			unmortgage.setEnabled(false);
	            		}
	            	}
	            	if (GameHandler.getSpaces().get(spaceIndex) instanceof Utility)
	            	{
	            		addHouses.setEnabled(false);
		                sellHouses.setEnabled(false);
		                Utility temp = (Utility)GameHandler.getSpaces().get(spaceIndex);
	            		if(temp.getMortgageState())
	            		{
	            			mortgage.setEnabled(false);
	            			unmortgage.setEnabled(true);
	            		}
	            		else {
	            			mortgage.setEnabled(true);
	            			unmortgage.setEnabled(false);
	            		}
	            	}
	            	if (GameHandler.getSpaces().get(spaceIndex) instanceof Property)
	            	{
	            		Property temp = (Property)GameHandler.getSpaces().get(spaceIndex);
	            		if(temp.getMortgageState())
	            		{
	            			mortgage.setEnabled(false);
	            			unmortgage.setEnabled(true);
	            		}
	            		else {
	            			mortgage.setEnabled(true);
	            			unmortgage.setEnabled(false);
	            		}
	            		
	            		if(temp.getOwner().hasMonopoly(temp.getColor()))
	            		{
	            			if(temp.getHouses() > 0 && temp.getHouses() < 5)
	            			{
	            				if(temp.getHouses() == 4)
	            				{
	            					addHouses.setText("ADD HOTEL");
	            				}
	            				else { addHouses.setText("ADD HOUSES"); sellHouses.setText("SELL HOUSES");}
	            				addHouses.setEnabled(true);
	            				sellHouses.setEnabled(true);
	            			}
	            			else if (temp.getHouses() == 5)
	            			{
	            				addHouses.setEnabled(false);
	            				sellHouses.setText("SELL HOTEL");
	            				sellHouses.setEnabled(true);
	            			}
	            			else if (temp.getHouses() == 0)
	            			{
	            				addHouses.setEnabled(true);
	            				sellHouses.setEnabled(false);
	            			}
	            		}
	            	}
	            }
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton sourceEvent = (JButton)e.getSource();
		int spaceIndex = 0;
		for (int i = 0; i < 40; i++)
    	{
    		if (GameHandler.getSpaces().get(i).getName().equals(property))
    		{
    			spaceIndex = i;
    		}
    	}
		if (sourceEvent == mortgage)
		{
			GameHandler.getSpaces().get(spaceIndex).mortgage();
			updateList();
		}
		if (sourceEvent == unmortgage)
		{
			GameHandler.getSpaces().get(spaceIndex).unmortgage();
			updateList();
		}
		if (sourceEvent == addHouses)
		{
			GameHandler.getSpaces().get(spaceIndex).addHouse();
			JOptionPane.showMessageDialog(this, "HOUSE/HOTEL ADDED");
			updateList();
			source.dispose();
		}
		if (sourceEvent == sellHouses)
		{
			GameHandler.getSpaces().get(spaceIndex).removeHouse();
			JOptionPane.showMessageDialog(this, "HOUSE/HOTEL REMOVED");
			updateList();
			source.dispose();
		}
	}
}
