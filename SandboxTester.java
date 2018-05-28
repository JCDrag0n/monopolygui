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
                jp.addBoard();
                jp.initUI();
                jp.imageUI();
                jp.addProperty();
                jp.addLog();
                jp.buttonUI();
                jp.addButtons();
                GameHandler.receiveLog(jp.getLog());
                Player.receiveLog(jp.getLog());
                GameHandler.receiveRoll(jp.getRoll());
                GameHandler.receiveBuy(jp.getBuy());
                GameHandler.receiveEndTurn(jp.getEndTurn());
                GameHandler.receiveChance(jp.getChance());
                GameHandler.receiveCommunity(jp.getCommunity());
                GameHandler.receiveFrame(jp.getFrame());
                GameHandler.receiveManage(jp.getManage());
            }
    });
}
}
