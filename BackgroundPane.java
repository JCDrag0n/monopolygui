import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPane extends JPanel {
	
	private Image backgroundimg;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	
	public BackgroundPane(String fileName) throws IOException {
		
		try {
	     backgroundimg = ImageIO.read(getClass().getResource(fileName));
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundimg, 0, 0, width, height, null);
	}
   

}
