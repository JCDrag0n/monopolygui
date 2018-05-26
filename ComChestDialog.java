import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		JPanel cardPane = new JPanel(new BorderLayout());
		
		Image resource = null;
		 try {
            resource = ImageIO.read(getClass().getResource("/ComChest.jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		 
		StretchIcon result = new StretchIcon(resource, true);
		JLabel comChestImg = new JLabel(result);
		JLabel comChestDialog = new JLabel(action);
		comChestDialog.setBorder(new EmptyBorder(10,10,10,10));
		comChestDialog.setFont(FontLoader.enableFont(20f));
		
		boardLabel.setAllSizes(comChestImg, imgD);
		
		cardPane.add(comChestImg, BorderLayout.LINE_START);
		cardPane.add(comChestDialog, BorderLayout.LINE_END);
		pack();

		setContentPane(cardPane);
	}
}