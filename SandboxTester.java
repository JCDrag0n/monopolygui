import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SandboxTester {
	public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
                    // Set System L&F
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } 
            catch (UnsupportedLookAndFeelException e) {
               // handle exception
            }
            catch (ClassNotFoundException e) {
               // handle exception
            }
            catch (InstantiationException e) {
               // handle exception
            }
            catch (IllegalAccessException e) {
               // handle exception
            }
            	
            	FontLoader.initFont("Quicksand-Regular.ttf");	

                Sandbox jp = new Sandbox();

				try {
					jp.createFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jp.initBoard();
                jp.addBoard();
                jp.initUI();
                jp.imageUI();
                jp.addProperty();
                jp.addLog();
                jp.buttonUI();
                jp.addButtons();
            }
    });
}
}
