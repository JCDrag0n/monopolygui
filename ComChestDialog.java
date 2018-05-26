import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComChestDialog extends JDialog{
	
	private String action;
	private Dimension imgD = new Dimension(500, 300);

	public ComChestDialog(Window owner, String title, Dialog.ModalityType modalityType, String action)
	{
		super(owner,title, modalityType);
		this.action = action;
	}
	
	public void initUI()
	{
		JPanel cardPane = new JPanel();
		
		Image resource = null;
		 try {
            resource = ImageIO.read(getClass().getResource("/ComChest.jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		 
		 StretchIcon result = new StretchIcon(resource, true);
		JLabel comChestImg = new JLabel(result);
		JLabel comChestDialog = new JLabel(action);
		
		boardLabel.setAllSizes(comChestImg, imgD);
		
		cardPane.add(comChestImg);
		cardPane.add(comChestDialog);

		setContentPane(cardPane);
	}
}