import java.awt.Font;
import java.awt.GraphicsEnvironment;

public final class FontLoader {
	
	private FontLoader()
	{
		
	}
	
	static Font quicksand;
	
	public static void initFont(String file)
	{
		try {
		 quicksand = Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(file));
   	     GraphicsEnvironment ge = 
   	         GraphicsEnvironment.getLocalGraphicsEnvironment();
   	     ge.registerFont(quicksand);
		}	 
		catch (Exception e) {
   		e.printStackTrace();
		}
	}
	
	public static Font enableFont(float size)
	{
		Font result = quicksand.deriveFont(size);
		return result;
	}

}
