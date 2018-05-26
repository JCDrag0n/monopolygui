import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TradeList extends JPanel implements ListSelectionListener{
	
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
	private JButton delete;
	private JButton add2;
	private JButton delete2;
	private JButton back;
	
	private JDialog source;
	
	private Dimension buttonD = new Dimension(130, 50);
	
	public TradeList(JDialog source)
	{
		super(new BorderLayout());
		this.source = source;
		mainListModel = new DefaultListModel();
		
		mainList = new JList(mainListModel);
		mainList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		mainList.addListSelectionListener(this);
		mainList.setFont(FontLoader.enableFont(14f));
		JScrollPane mainListScrollPane = new JScrollPane(mainList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainListScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("YOUR INVENTORY")));
		
		secondListModel = new DefaultListModel();
		
		secondList = new JList(secondListModel);
		secondList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		secondList.addListSelectionListener(this);
		secondList.setFont(FontLoader.enableFont(14f));
		JScrollPane secondListScrollPane = new JScrollPane(secondList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		secondListScrollPane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("OTHER INVENTORY")));
		
		add = new JButton("ADD");
		delete = new JButton("DELETE");
		add2 = new JButton("ADD");
		delete2 = new JButton("DELETE");
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 source.dispose();
			 }
		});
		add.setEnabled(false);
        delete.setEnabled(false);
        add2.setEnabled(false);
        delete2.setEnabled(false);
		boardLabel.setAllSizes(add, buttonD);
		boardLabel.setAllSizes(delete, buttonD);
		boardLabel.setAllSizes(add2, buttonD);
		boardLabel.setAllSizes(delete2, buttonD);
		boardLabel.setAllSizes(back, buttonD);
		boardLabel.setAllSizes(mainListScrollPane, new Dimension(300, 360));
		boardLabel.setAllSizes(secondListScrollPane, new Dimension(300,360));

		
		 mainArea = new JTextArea("");
		 mainArea.setFont(FontLoader.enableFont(14f));
		 mainArea.setEditable(false);
		 
		 JScrollPane mainAreaScroller = new JScrollPane(mainArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 //mainAreaScroller.setPreferredSize(new Dimension(400,200));
		 mainAreaScroller.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("ITEMS GIVEN:")));
		 
		 secondArea = new JTextArea("");
		 secondArea.setFont(FontLoader.enableFont(14f));
		 secondArea.setEditable(false);
		 
		 JScrollPane secondAreaScroller = new JScrollPane(secondArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 //mainAreaScroller.setPreferredSize(new Dimension(400,200));
		 secondAreaScroller.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), BorderFactory.createTitledBorder("ITEMS TAKEN:")));
//		 JLabel header = new JLabel("PLAYER INFO");
//		 header.setFont(FontLoader.enableFont(16f));
//		 propertyScroller.setColumnHeaderView(header);
//		 propertyScroller.setBorder(new EmptyBorder(10,10,10,10));
		 
		boardLabel.setAllSizes(mainAreaScroller, new Dimension(300, 360));
		boardLabel.setAllSizes(secondAreaScroller, new Dimension(300,360));
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
		buttonPane.add(Box.createRigidArea(new Dimension(30, 30)));
		buttonPane.add(add);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(delete);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 300)));
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(add2);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(delete2);
		buttonPane.add(Box.createRigidArea(new Dimension(10,10)));
		buttonPane.add(back);
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
	
	public void updateList()
	{
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
	                delete.setEnabled(false);
	                add2.setEnabled(false);
	                delete2.setEnabled(false);
	                
	            } else if (mainList.getSelectedIndex() != -1 && secondList.getSelectedIndex() == -1){
	            //Selection, enable the fire button.
	            	add.setEnabled(true);
	                delete.setEnabled(true);
	                add2.setEnabled(false);
	                delete2.setEnabled(false);
	            } else if (mainList.getSelectedIndex() == -1 && secondList.getSelectedIndex() != -1) {
	            	add2.setEnabled(true);
	                delete2.setEnabled(true);
	                add.setEnabled(false);
	                delete.setEnabled(false);
	            } else {
	            	add.setEnabled(true);
	                delete.setEnabled(true);
	                add2.setEnabled(true);
	                delete2.setEnabled(true);
	            }
	        }
	    }
}


