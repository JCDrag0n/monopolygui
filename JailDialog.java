import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JailDialog extends JDialog{
	private String action;
	private Dimension imgD = new Dimension(500, 300);

	public JailDialog(Window owner, String title, Dialog.ModalityType modalityType)
	{
		super(owner,title, modalityType);
	}
	
	public void initUI()
	{
		JPanel cardPane = new JPanel();
		
//		Image resource = null;
//		 try {
//            resource = ImageIO.read(getClass().getResource("/cchest.jpg"));
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//		 
//		StretchIcon result = new StretchIcon(resource, true);
		JButton pay = new JButton("PAY FINE");
		JButton roll = new JButton("ROLL DOUBLE");
		JButton useCard = new JButton("GET OUT OF JAIL FREE");
//		JLabel comChestDialog = new JLabel(action);
//		comChestDialog.setBorder(new EmptyBorder(10,10,10,10));
//		comChestDialog.setFont(FontLoader.enableFont(20f));
		
		//boardLabel.setAllSizes(comChestImg, imgD);
		
		cardPane.add(pay);
		cardPane.add(roll);
		cardPane.add(useCard);
		pack();

		setContentPane(cardPane);
	}
}
