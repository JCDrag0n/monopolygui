import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PropertyList extends JPanel implements ListSelectionListener{

	private JList list;
	private DefaultListModel listModel;
	private JPanel buttonPane;
	
	private JButton mortgage;
	private JButton unmortgage;
	private JButton sell;
	private JButton addHouses;
	private JButton sellHouses;
	private JButton back;
	
	private JDialog source;
	
	private Dimension buttonD = new Dimension(130, 50);
	
	public PropertyList(JDialog source)
	{
		super(new BorderLayout());
		this.source = source;
	
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.addListSelectionListener(this);
		list.setFont(FontLoader.enableFont(16f));
		JScrollPane listScrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("LIST OF PROPERTIES")));
		
		mortgage = new JButton("MORTGAGE");
		unmortgage = new JButton("UNMORTGAGE");
		sell = new JButton("SELL");
		addHouses = new JButton("ADD HOUSES");
		sellHouses = new JButton("SELL HOUSES");
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 source.dispose();
			 }
		});
		boardLabel.setAllSizes(mortgage, buttonD);
		boardLabel.setAllSizes(unmortgage, buttonD);
		boardLabel.setAllSizes(sell, buttonD);
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
		buttonPane.add(sell);
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
		for (int i = 0; i < GameHandler.getPlayer().getProperties().size(); i++)
		{
			listModel.addElement(GameHandler.getPlayer().getProperties().get(i));
		}
	}
	
	  public void valueChanged(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting() == false) {
	 
	            if (list.getSelectedIndex() == -1) {
	            //No selection, disable fire button.
	                mortgage.setEnabled(false);
	                unmortgage.setEnabled(false);
	                sell.setEnabled(false);
	                addHouses.setEnabled(false);
	                sellHouses.setEnabled(false);
	                
	            } else {
	            //Selection, enable the fire button.
	            	mortgage.setEnabled(true);
	                unmortgage.setEnabled(true);
	                sell.setEnabled(true);
	                addHouses.setEnabled(true);
	                sellHouses.setEnabled(true);
	            }
	        }
	    }
}
