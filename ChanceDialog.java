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

public class ChanceDialog extends JDialog{
	
	private String action;
	private Dimension imgD = new Dimension(300, 194);

	public ChanceDialog(Window owner, String title, Dialog.ModalityType modalityType, String action)
	{
		super(owner,title, modalityType);
		this.action = action;
	}
	
	public void initUI()
	{
		JPanel cardPane = new JPanel(new BorderLayout());
		
		Image resource = null;
		 try {
            resource = ImageIO.read(getClass().getResource("/Chance.jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		 
		StretchIcon result = new StretchIcon(resource, true);
		JLabel chanceImg = new JLabel(result);
		JLabel chanceDialog = new JLabel(action);
		chanceDialog.setBorder(new EmptyBorder(10,10,10,10));
		chanceDialog.setFont(FontLoader.enableFont(20f));
		
		boardLabel.setAllSizes(chanceImg, imgD);
		
		cardPane.add(chanceImg, BorderLayout.LINE_START);
		cardPane.add(chanceDialog, BorderLayout.LINE_END);
		pack();

		setContentPane(cardPane);
	}
}
