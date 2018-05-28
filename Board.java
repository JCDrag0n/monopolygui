import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

        protected static final Object UPDATE = new Object();
        private Thread animator;
        private int x, y;
        private static int bWIDTH = 1000; // width of window 
        private static int bHEIGHT = 1000;// height of window
        private long period;
        private volatile boolean running = false;
        private volatile boolean gameOver = false;
        private volatile boolean isPaused = false;
        private BufferedImage activeBuffer = null;
        private BufferedImage scratchBuffer = null;
        
        private JLabel property, currentIcon, med, cchest, balt, tax1, rrail, ori, chance, ver, con, jail; 
    	private JLabel stc, ele, stat, virg, penn, stj, cchest2, tenn, ny, fpark;
    	private JLabel kent, chance2, ind, ill, bor, alta, vent, water, marvin, gtjail;
    	private JLabel pacific, north, cchest3, pennave, shortL, chance3, park, tax2, boardwalk, go, center, hCount;
    	
    	private JPanel propertyPane;
    	
    	private static ArrayList<Integer> xCods;
    	private static ArrayList<Integer> yCods;
       
        public Board(long period) {

            this.period = period;
    	setBounds(10, 20, 1000, 1000);

            setPreferredSize(new Dimension(bWIDTH, bHEIGHT));


            setFocusable(true);
            requestFocus(); 

            
			setLayout(new GridBagLayout());

			
			GridBagConstraints propertyc = new GridBagConstraints();
			GridBagConstraints squarec = new GridBagConstraints();
			GridBagConstraints centerc = new GridBagConstraints();
			
			Dimension propertyr = new Dimension(82, 132);
			Dimension squared = new Dimension(132, 132);
			Dimension propertyl = new Dimension(132, 82);
			Dimension centerd = new Dimension(736, 736);
			
			centerc.gridwidth = 9;
			centerc.gridheight = 9;
			
			StretchIcon propertyimg = boardLabel.imgConversion("/goPC.png");
			property = new JLabel(propertyimg);
			
			currentIcon = new JLabel();
			
            hCount = new JLabel();
            hCount.setFont(FontLoader.enableFont(14f));
			
			fpark = new JLabel(boardLabel.imgConversion("/freeparking.png"));
			boardLabel.setAllSizes(fpark, squared);
			squarec.gridx = 0;
			squarec.gridy = 0;
			add(fpark, squarec);
			boardLabel.setMouseListener(fpark, currentIcon, property, hCount, -1, "/freeparkingPC.png");
			
			kent = new JLabel(boardLabel.imgConversion("/kentucky.png"));
			boardLabel.setAllSizes(kent, propertyr);
			propertyc.gridx = 1;
			propertyc.gridy = 0;
			add(kent, propertyc);
			boardLabel.setMouseListener(kent, currentIcon, property, hCount, 21, "/KentuckyPC.png");
			
			chance2 = new JLabel(boardLabel.imgConversion("chanceu.png"));
			boardLabel.setAllSizes(chance2, propertyr);
			propertyc.gridx = 2;
			propertyc.gridy = 0;
			add(chance2, propertyc);
			boardLabel.setMouseListener(chance2, currentIcon, property, hCount, -1, "/chancePC.png");
			
			ind = new JLabel(boardLabel.imgConversion("indiana.png"));
			boardLabel.setAllSizes(ind, propertyr);
			propertyc.gridx = 3;
			propertyc.gridy = 0;
			add(ind, propertyc);
			boardLabel.setMouseListener(ind, currentIcon, property, hCount, 23, "/IndianaPC.png");
		
			ill = new JLabel(boardLabel.imgConversion("illinois.png"));
			boardLabel.setAllSizes(ill, propertyr);
			propertyc.gridx = 4;
			propertyc.gridy = 0;
			add(ill, propertyc);
			boardLabel.setMouseListener(ill, currentIcon, property, hCount, 24, "/IllinoisPC.png");
			
			bor = new JLabel(boardLabel.imgConversion("borail.png"));
			boardLabel.setAllSizes(bor, propertyr);
			propertyc.gridx = 5;
			propertyc.gridy = 0;
			add(bor, propertyc);
			boardLabel.setMouseListener(bor, currentIcon, property, hCount, -1, "/BORPC.png");
			
			alta = new JLabel(boardLabel.imgConversion("atlantic.png"));
			boardLabel.setAllSizes(alta, propertyr);
			propertyc.gridx = 6;
			propertyc.gridy = 0;
			add(alta, propertyc);
			boardLabel.setMouseListener(alta, currentIcon, property, hCount, 26, "/AtlanticPC.png");
			
			vent = new JLabel(boardLabel.imgConversion("ventnor.png"));
			boardLabel.setAllSizes(vent, propertyr);
			propertyc.gridx = 7;
			propertyc.gridy = 0;
			add(vent, propertyc);
			boardLabel.setMouseListener(vent, currentIcon, property, hCount, 27, "/VentnorPC.png");
			
			water = new JLabel(boardLabel.imgConversion("water.png"));
			boardLabel.setAllSizes(water, propertyr);
			propertyc.gridx = 8;
			propertyc.gridy = 0;
			add(water, propertyc);
			boardLabel.setMouseListener(water, currentIcon, property, hCount, -1, "/WaterPC.png");
			
			marvin = new JLabel(boardLabel.imgConversion("marvin.png"));
			boardLabel.setAllSizes(marvin, propertyr);
			propertyc.gridx = 9;
			propertyc.gridy = 0;
			add(marvin, propertyc);
			boardLabel.setMouseListener(marvin, currentIcon, property, hCount, 29, "/MarvinPC.png");
		
			gtjail = new JLabel(boardLabel.imgConversion("gotojail.png"));
			boardLabel.setAllSizes(gtjail, squared);
			squarec.gridx = 10;
			squarec.gridy = 0;
			add(gtjail, squarec);
			boardLabel.setMouseListener(gtjail, currentIcon, property, hCount, -1, "/gotojailPC.png");
			
			pacific = new JLabel(boardLabel.imgConversion("pacific.png"));
			boardLabel.setAllSizes(pacific, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 1;
			add(pacific, propertyc);
			boardLabel.setMouseListener(pacific, currentIcon, property, hCount, 31, "/PacificPC.png");
			
			north = new JLabel(boardLabel.imgConversion("northc.png"));
			boardLabel.setAllSizes(north, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 2;
			add(north, propertyc);
			boardLabel.setMouseListener(north, currentIcon, property, hCount, 32, "/NorthCaroPC.png");
			
			cchest3 = new JLabel(boardLabel.imgConversion("communitycr.png"));
			boardLabel.setAllSizes(cchest3, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 3;
			add(cchest3, propertyc);
			boardLabel.setMouseListener(cchest3, currentIcon, property, hCount, -1, "/cchestPC.png");
			
			pennave = new JLabel(boardLabel.imgConversion("pennave.png"));
			boardLabel.setAllSizes(pennave, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 4;
			add(pennave, propertyc);
			boardLabel.setMouseListener(pennave, currentIcon, property, hCount, 34, "/PennAvePC.png");
			
			shortL = new JLabel(boardLabel.imgConversion("shortline.png"));
			boardLabel.setAllSizes(shortL, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 5;
			add(shortL, propertyc);
			boardLabel.setMouseListener(shortL, currentIcon, property, hCount, -1, "/ShortPC.png");
			
			chance3 = new JLabel(boardLabel.imgConversion("chancer.png"));
			boardLabel.setAllSizes(chance3, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 6;
			add(chance3, propertyc);
			boardLabel.setMouseListener(chance3, currentIcon, property, hCount, -1, "/chancePC.png");
			
			park = new JLabel(boardLabel.imgConversion("park.png"));
			boardLabel.setAllSizes(park, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 7;
			add(park, propertyc);
			boardLabel.setMouseListener(park, currentIcon, property, hCount, 37, "/ParkPC.png");
			
			tax2 = new JLabel(boardLabel.imgConversion("luxtax.png"));
			boardLabel.setAllSizes(tax2, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 8;
			add(tax2, propertyc);
			boardLabel.setMouseListener(tax2, currentIcon, property, hCount, -1, "/luxtaxPC.png");
			
			boardwalk = new JLabel(boardLabel.imgConversion("boardwalk.png"));
			boardLabel.setAllSizes(boardwalk, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 9;
			add(boardwalk, propertyc);
			boardLabel.setMouseListener(boardwalk, currentIcon, property, hCount, 39, "/BoardwalkPC.png");
			
			go = new JLabel(boardLabel.imgConversion("go.png"));
			boardLabel.setAllSizes(go, squared);
			squarec.gridx = 10;
			squarec.gridy = 10;
			add(go, squarec);
			boardLabel.setMouseListener(go, currentIcon, property, hCount, -1, "/goPC.png");
			
			ny = new JLabel(boardLabel.imgConversion("ny.png"));
			boardLabel.setAllSizes(ny, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 1;
			add(ny, propertyc);
			boardLabel.setMouseListener(ny, currentIcon, property, hCount, 19, "/NYaPC.png");
			
			tenn = new JLabel(boardLabel.imgConversion("tennessee.png"));
			boardLabel.setAllSizes(tenn, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 2;
			add(tenn, propertyc);
			boardLabel.setMouseListener(tenn, currentIcon, property, hCount, 18, "/TennPC.png");
			
			cchest2 = new JLabel(boardLabel.imgConversion("communitycl.png"));
			boardLabel.setAllSizes(cchest2, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 3;
			add(cchest2, propertyc);
			boardLabel.setMouseListener(cchest2, currentIcon, property, hCount, -1, "/cchestPC.png");
			
			stj = new JLabel(boardLabel.imgConversion("stjames.png"));
			boardLabel.setAllSizes(stj, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 4;
			add(stj, propertyc);
			boardLabel.setMouseListener(stj, currentIcon, property, hCount, 16, "/JamesPC.png");
			
			penn = new JLabel(boardLabel.imgConversion("pennrail.png"));
			boardLabel.setAllSizes(penn, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 5;
			add(penn, propertyc);
			boardLabel.setMouseListener(penn, currentIcon, property, hCount, -1, "/PennRailPC.png");
			
			virg = new JLabel(boardLabel.imgConversion("virginia.png"));
			boardLabel.setAllSizes(virg, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 6;
			add(virg, propertyc);
			boardLabel.setMouseListener(virg, currentIcon, property, hCount, 14, "/VirginiaPC.png");
			
			stat = new JLabel(boardLabel.imgConversion("states.png"));
			boardLabel.setAllSizes(stat, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 7;
			add(stat, propertyc);
			boardLabel.setMouseListener(stat, currentIcon, property, hCount, 13, "/StatesPC.png");
			
			ele = new JLabel(boardLabel.imgConversion("electric.png"));
			boardLabel.setAllSizes(ele, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 8;
			add(ele, propertyc);
			boardLabel.setMouseListener(ele, currentIcon, property, hCount, -1, "/ElectricPC.png");
			
			stc = new JLabel(boardLabel.imgConversion("stcharles.png"));
			boardLabel.setAllSizes(stc, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 9;
			add(stc, propertyc);
			boardLabel.setMouseListener(stc, currentIcon, property, hCount, 11, "/CharlesPC.png");
			
			con = new JLabel(boardLabel.imgConversion("connecticut.png"));
			boardLabel.setAllSizes(con, propertyr);
			propertyc.gridx = 1;
			propertyc.gridy = 10;
			add(con, propertyc);
			boardLabel.setMouseListener(con, currentIcon, property, hCount, 9, "/ConnPC.png");
			
			ver = new JLabel(boardLabel.imgConversion("vermont.png"));
			boardLabel.setAllSizes(ver, propertyr);
			propertyc.gridx = 2;
			propertyc.gridy = 10;
			add(ver, propertyc);
			boardLabel.setMouseListener(ver, currentIcon, property, hCount, 8, "/VermontPC.png");
			
			chance = new JLabel(boardLabel.imgConversion("chanced.png"));
			boardLabel.setAllSizes(chance, propertyr);
			propertyc.gridx = 3;
			propertyc.gridy = 10;
			add(chance, propertyc);
			boardLabel.setMouseListener(chance, currentIcon, property, hCount, -1, "/chancePC.png");
			
			ori = new JLabel(boardLabel.imgConversion("oriental.png"));
			boardLabel.setAllSizes(ori, propertyr);
			propertyc.gridx = 4;
			propertyc.gridy = 10;
			add(ori, propertyc);
			boardLabel.setMouseListener(ori, currentIcon, property, hCount, 6, "/OrientalPC.png");
			
			rrail = new JLabel(boardLabel.imgConversion("readingrail.png"));
			boardLabel.setAllSizes(rrail, propertyr);
			propertyc.gridx = 5;
			propertyc.gridy = 10;
			add(rrail, propertyc);
			boardLabel.setMouseListener(rrail, currentIcon, property, hCount, -1, "/ReadingRailPC.png");
			
			tax1 = new JLabel(boardLabel.imgConversion("inctax.png"));
			boardLabel.setAllSizes(tax1, propertyr);
			propertyc.gridx = 6;
			propertyc.gridy = 10;
			add(tax1, propertyc);
			boardLabel.setMouseListener(tax1, currentIcon, property, hCount, -1, "/inctaxPC.png");
			
			balt = new JLabel(boardLabel.imgConversion("baltic.png"));
			boardLabel.setAllSizes(balt, propertyr);
			propertyc.gridx = 7;
			propertyc.gridy = 10;
			add(balt, propertyc);
			boardLabel.setMouseListener(balt, currentIcon, property, hCount, 3, "/BalticPC.png");
			
			cchest = new JLabel(boardLabel.imgConversion("communitycd.png"));
			boardLabel.setAllSizes(cchest, propertyr);
			propertyc.gridx = 8;
			propertyc.gridy = 10;
			add(cchest, propertyc);
			boardLabel.setMouseListener(cchest, currentIcon, property, hCount, -1, "/cchestPC.png");
			
			med = new JLabel(boardLabel.imgConversion("mediterranean.png"));
			boardLabel.setAllSizes(med, propertyr);
			propertyc.gridx = 9;
			propertyc.gridy = 10;
			add(med, propertyc);
			boardLabel.setMouseListener(med, currentIcon, property, hCount, 1, "/MedPC.png");
			
			jail = new JLabel(boardLabel.imgConversion("jail.png"));
			boardLabel.setAllSizes(jail, squared);
			squarec.gridx = 0;
			squarec.gridy = 10;
			add(jail, squarec);
			boardLabel.setMouseListener(jail, currentIcon, property, hCount, -1, "/jailPC.png");
			
			center = new JLabel(boardLabel.imgConversion("center.png"));
			boardLabel.setAllSizes(center, centerd);
			centerc.gridx = 1;
			centerc.gridy = 1;
			add(center, centerc);

            x = 950;
            y = 950;
            
            propertyPane = new JPanel(new BorderLayout());
            propertyPane.setPreferredSize(new Dimension(330, 420));
            property.setPreferredSize(new Dimension(330, 420));
            propertyPane.add(property, BorderLayout.CENTER);
            propertyPane.setVisible(true);
            propertyPane.add(hCount, BorderLayout.PAGE_END);
        	property.setVisible(true);

        }  
        


        public void addNotify() {
            super.addNotify();
            startGame();
        }
        
        public Dimension getMaximumSize()
        {
        	return new Dimension(bWIDTH, bHEIGHT);
        }
        
        public Dimension getMinimumSize()
        {
        	return new Dimension(bWIDTH, bHEIGHT);
        }
        
        public Dimension getPreferredSize()
        {
        	return new Dimension(bWIDTH, bHEIGHT);
        }

        public void startGame() {
            if (animator == null || !running) {
                animator = new Thread(this);
                animator.start();
            }
        }

        public void pauseGame() {
            isPaused = true;
        }

        public void resumeGame() {
            isPaused = false;
        }

        public void stopGame() {
            running = false;
        }

        @Override
        public void invalidate() {
            synchronized (UPDATE) {
                activeBuffer = null;
                scratchBuffer = null;
            }
            super.invalidate();
        }

        private void gameRender() {
        	if(GameHandler.isReady()) {
            synchronized (UPDATE) {
               if (getWidth() > 0 && getHeight() > 0) {
            	   
                    if (scratchBuffer == null) {

                       scratchBuffer = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
                    }

                    Graphics2D dbg = scratchBuffer.createGraphics();
                    dbg.setColor(new Color(0, 0, 0 , 0));
                    dbg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
                    dbg.fillRect(0,0, scratchBuffer.getWidth(), scratchBuffer.getHeight());
                    paintChildren(dbg);

                    if (gameOver) {
                       gameOverMessage(dbg);
                    }
                    dbg.dispose();
                }

                BufferedImage tmp = activeBuffer;
                activeBuffer = scratchBuffer;
                scratchBuffer = tmp;
            }
        }
        }

        private void gameUpdate() {
            if (!isPaused && !gameOver && GameHandler.isReady()) {
            	for (int i = 0; i < GameHandler.getNumPlayers(); i++) {
                GameHandler.getPlayer(i).getIcon().move();
            }
            }
        }

        private void gameOverMessage(Graphics g) 
        { 
            String msg = "Game Over";
            g.drawString(msg, x, y);
        }  

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (activeBuffer != null) {
                g.drawImage(activeBuffer, 0, 0, null);
            }
        }

        public void run() {

            long beforeTime, afterTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();

            running = true;
            while (running) {
                gameUpdate();
                gameRender();

                repaint();

                afterTime = System.currentTimeMillis();
                timeDiff = afterTime - beforeTime;
                sleep = (period - timeDiff);

                if (sleep > 0) {
                    try {
                        Thread.sleep(sleep); // nano -> ms
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                } else {      
                    System.out.println("Over...");
                }

                beforeTime = System.currentTimeMillis();
            }
            System.exit(0);
        }
        
        public JPanel getProperty()
        {
        	return propertyPane;
        }
        
        public void paintChildren(Graphics g)
        {
        	super.paintChildren(g);
        	for (int i = 0; i < GameHandler.getNumPlayers(); i++) {
                GameHandler.getPlayer(i).getIcon().draw(g, this);
            }
        }

        public static int getPropertyX(int n)
        {
        	return xCods.get(n);
        }
        
        public static int getPropertyY(int n)
        {
        	return yCods.get(n);
        }
    }
