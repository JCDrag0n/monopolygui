import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuDialog extends JDialog {
	
	Dimension area = new Dimension(0, 10);
	Dimension size = new Dimension(250, 50);
	JButton continued;
	JButton quit;
	
	public MenuDialog(Window owner, String title, Dialog.ModalityType modalityType)
	{
		super(owner,title, modalityType);
		
	}
	
	public void initUI()
	{
		JPanel menuPane = new JPanel();
		continued = new JButton("CONTINUE");
		continued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		continued.setPreferredSize(size);
		continued.setMaximumSize(size);
		continued.setMinimumSize(size);
		menuPane.setLayout(new BoxLayout(menuPane, BoxLayout.PAGE_AXIS));
		menuPane.add(continued);
		menuPane.add(Box.createRigidArea(area));
		quit = new JButton(new AbstractAction("QUIT") {

		public void actionPerformed(ActionEvent evt) {
			 int n = JOptionPane.showConfirmDialog(
                     null, "Are you sure?",
                     "QUIT",
                     JOptionPane.YES_NO_OPTION);
             if (n == JOptionPane.YES_OPTION) {
            	 System.exit(0);
            	
             }
           
     }});
		quit.setPreferredSize(size);
		quit.setMaximumSize(size);
		quit.setMinimumSize(size);
		menuPane.add(quit);
		
		setContentPane(menuPane);
	}
	
	

}
