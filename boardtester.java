
public class boardtester {
	public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	boardLabel test = new boardLabel();
            	test.initBoard();
            }
    	});
	}
}
