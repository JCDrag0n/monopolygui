import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

        protected static final Object UPDATE = new Object();
       // private static final int NO_DELAYS_PER_YIELD = 16;
        /* Number of frames with a delay of 0 ms before the
         animation thread yields to other running threads. */
       // private static int MAX_FRAME_SKIPS = 5;
// no. of frames that can be skipped in any one animation loop
// i.e the games state is updated but not rendered
        private Thread animator;
        private int x, y;
        //private final int frameCount = 8;
        BufferedImage flowers;
        //private int[][] fPos = {{232, 15}, {400, 200}, {335, 335}}; // flower coordinates 
        private static int bWIDTH = 1000; // width of window 
        private static int bHEIGHT = 1000;// height of window
        private Font font;
      //  private FontMetrics metrics;
//        private House house = new House();
//        private Flower flower = new Flower();
       // private int px = 200;
        //private int py = 400;
        private long period;
        private volatile boolean running = false;
        private volatile boolean gameOver = false;
        private volatile boolean isPaused = false;
//        private Graphics dbg;
        private BufferedImage activeBuffer = null;
        private BufferedImage scratchBuffer = null;
        
        private JLabel property, currentIcon, med, cchest, balt, tax1, rrail, ori, chance, ver, con, jail; 
    	private JLabel stc, ele, stat, virg, penn, stj, cchest2, tenn, ny, fpark;
    	private JLabel kent, chance2, ind, ill, bor, alta, vent, water, marvin, gtjail;
    	private JLabel pacific, north, cchest3, pennave, shortL, chance3, park, tax2, boardwalk, go, center;
    	
    	private static int medx, cchestx, baltx, tax1x, rrailx, orix, chancex, verx, conx, jailx;
    	private static int stcx, elex, statx, virgx, pennx, stjx, cchest2x, tennx, nyx, fparkx;
    	private static int kentx, chance2x, indx, illx, borx, altax, ventx, waterx, marvinx, gtjailx;
    	private static int pacificx, northx, cchest3x, pennavex, shortLx, chance3x, parkx, tax2x, boardwalkx, gox;
    	
    	private static int medy, cchesty, balty, tax1y, rraily, oriy, chancey, very, cony, jaily;
    	private static int stcy, eley, staty, virgy, penny, stjy, cchest2y, tenny, nyy, fparky;
    	private static int kenty, chance2y, indy, illy, bory, altay, venty, watery, marviny, gtjaily;
    	private static int pacificy, northy, cchest3y, pennavey, shortLy, chance3y, parky, tax2y, boardwalky, goy;
    	
    	private static ArrayList<Integer> xCods;
    	private static ArrayList<Integer> yCods;
       
        public Board(long period) {

            this.period = period;
    	//setPreferredSize(new Dimension(1000,1000));
    	setBounds(10, 20, 1000, 1000);
    	//setOpaque(false);
    	//setFocusable(true);
    	//requestFocus();
//    	
//    	board.setHorizontalAlignment(JLabel.CENTER);
//    	board.setVerticalAlignment(JLabel.CENTER);

    	//frame.pack();
            setPreferredSize(new Dimension(bWIDTH, bHEIGHT));
            //setOpaque(false);

            setFocusable(true);
            requestFocus();     //JPanel now receives key events
            //readyForTermination();

            // create game components
            
			setLayout(new GridBagLayout());
			//setPreferredSize(new Dimension(1000,1000));
			
			//board.add();
			
			GridBagConstraints propertyc = new GridBagConstraints();
			GridBagConstraints squarec = new GridBagConstraints();
			GridBagConstraints centerc = new GridBagConstraints();
			
			Dimension propertyr = new Dimension(82, 132);
			Dimension squared = new Dimension(132, 132);
			Dimension propertyl = new Dimension(132, 82);
			Dimension centerd = new Dimension(736, 736);
			
//			propertyc.ipadx = 82;
//			propertyc.ipady = 132;
//			
//			squarec.ipadx = 132;
//			squarec.ipady = 132;
			
			centerc.gridwidth = 9;
			centerc.gridheight = 9;
			
			StretchIcon propertyimg = boardLabel.imgConversion("/goPC.png");
			property = new JLabel(propertyimg);
			
			currentIcon = new JLabel();
			
			fpark = new JLabel(boardLabel.imgConversion("/freeparking.png"));
			boardLabel.setAllSizes(fpark, squared);
			squarec.gridx = 0;
			squarec.gridy = 0;
			add(fpark, squarec);
			boardLabel.setMouseListener(fpark, currentIcon, property, "/freeparkingPC.png");
			
			kent = new JLabel(boardLabel.imgConversion("/kentucky.png"));
			boardLabel.setAllSizes(kent, propertyr);
			propertyc.gridx = 1;
			propertyc.gridy = 0;
			add(kent, propertyc);
			boardLabel.setMouseListener(kent, currentIcon, property, "/KentuckyPC.png");
			
			chance2 = new JLabel(boardLabel.imgConversion("chanceu.png"));
			boardLabel.setAllSizes(chance2, propertyr);
			propertyc.gridx = 2;
			propertyc.gridy = 0;
			add(chance2, propertyc);
			boardLabel.setMouseListener(chance2, currentIcon, property, "/chancePC.png");
			
			ind = new JLabel(boardLabel.imgConversion("indiana.png"));
			boardLabel.setAllSizes(ind, propertyr);
			propertyc.gridx = 3;
			propertyc.gridy = 0;
			add(ind, propertyc);
			boardLabel.setMouseListener(ind, currentIcon, property, "/IndianaPC.png");
		
			ill = new JLabel(boardLabel.imgConversion("illinois.png"));
			boardLabel.setAllSizes(ill, propertyr);
			propertyc.gridx = 4;
			propertyc.gridy = 0;
			add(ill, propertyc);
			boardLabel.setMouseListener(ill, currentIcon, property, "/IllinoisPC.png");
			
			bor = new JLabel(boardLabel.imgConversion("borail.png"));
			boardLabel.setAllSizes(bor, propertyr);
			propertyc.gridx = 5;
			propertyc.gridy = 0;
			add(bor, propertyc);
			boardLabel.setMouseListener(bor, currentIcon, property, "/BORPC.png");
			
			alta = new JLabel(boardLabel.imgConversion("atlantic.png"));
			boardLabel.setAllSizes(alta, propertyr);
			propertyc.gridx = 6;
			propertyc.gridy = 0;
			add(alta, propertyc);
			boardLabel.setMouseListener(alta, currentIcon, property, "/AtlanticPC.png");
			
			vent = new JLabel(boardLabel.imgConversion("ventnor.png"));
			boardLabel.setAllSizes(vent, propertyr);
			propertyc.gridx = 7;
			propertyc.gridy = 0;
			add(vent, propertyc);
			boardLabel.setMouseListener(vent, currentIcon, property, "/VentnorPC.png");
			
			water = new JLabel(boardLabel.imgConversion("water.png"));
			boardLabel.setAllSizes(water, propertyr);
			propertyc.gridx = 8;
			propertyc.gridy = 0;
			add(water, propertyc);
			boardLabel.setMouseListener(water, currentIcon, property, "/WaterPC.png");
			
			marvin = new JLabel(boardLabel.imgConversion("marvin.png"));
			boardLabel.setAllSizes(marvin, propertyr);
			propertyc.gridx = 9;
			propertyc.gridy = 0;
			add(marvin, propertyc);
			boardLabel.setMouseListener(marvin, currentIcon, property, "/MarvinPC.png");
		
			gtjail = new JLabel(boardLabel.imgConversion("gotojail.png"));
			boardLabel.setAllSizes(gtjail, squared);
			squarec.gridx = 10;
			squarec.gridy = 0;
			add(gtjail, squarec);
			boardLabel.setMouseListener(gtjail, currentIcon, property, "/gotojailPC.png");
			
			pacific = new JLabel(boardLabel.imgConversion("pacific.png"));
			boardLabel.setAllSizes(pacific, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 1;
			add(pacific, propertyc);
			boardLabel.setMouseListener(pacific, currentIcon, property, "/PacificPC.png");
			
			north = new JLabel(boardLabel.imgConversion("northc.png"));
			boardLabel.setAllSizes(north, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 2;
			add(north, propertyc);
			boardLabel.setMouseListener(north, currentIcon, property, "/NorthCaroPC.png");
			
			cchest3 = new JLabel(boardLabel.imgConversion("communitycr.png"));
			boardLabel.setAllSizes(cchest3, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 3;
			add(cchest3, propertyc);
			boardLabel.setMouseListener(cchest3, currentIcon, property, "/cchestPC.png");
			
			pennave = new JLabel(boardLabel.imgConversion("pennave.png"));
			boardLabel.setAllSizes(pennave, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 4;
			add(pennave, propertyc);
			boardLabel.setMouseListener(pennave, currentIcon, property, "/PennAvePC.png");
			
			shortL = new JLabel(boardLabel.imgConversion("shortline.png"));
			boardLabel.setAllSizes(shortL, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 5;
			add(shortL, propertyc);
			boardLabel.setMouseListener(shortL, currentIcon, property, "/ShortPC.png");
			
			chance3 = new JLabel(boardLabel.imgConversion("chancer.png"));
			boardLabel.setAllSizes(chance3, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 6;
			add(chance3, propertyc);
			boardLabel.setMouseListener(chance3, currentIcon, property, "/chancePC.png");
			
			park = new JLabel(boardLabel.imgConversion("park.png"));
			boardLabel.setAllSizes(park, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 7;
			add(park, propertyc);
			boardLabel.setMouseListener(park, currentIcon, property, "/ParkPC.png");
			
			tax2 = new JLabel(boardLabel.imgConversion("luxtax.png"));
			boardLabel.setAllSizes(tax2, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 8;
			add(tax2, propertyc);
			boardLabel.setMouseListener(tax2, currentIcon, property, "/luxtaxPC.png");
			
			boardwalk = new JLabel(boardLabel.imgConversion("boardwalk.png"));
			boardLabel.setAllSizes(boardwalk, propertyl);
			propertyc.gridx = 10;
			propertyc.gridy = 9;
			add(boardwalk, propertyc);
			boardLabel.setMouseListener(boardwalk, currentIcon, property, "/BoardwalkPC.png");
			
			go = new JLabel(boardLabel.imgConversion("go.png"));
			boardLabel.setAllSizes(go, squared);
			squarec.gridx = 10;
			squarec.gridy = 10;
			add(go, squarec);
			boardLabel.setMouseListener(go, currentIcon, property, "/goPC.png");
			
			ny = new JLabel(boardLabel.imgConversion("ny.png"));
			boardLabel.setAllSizes(ny, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 1;
			add(ny, propertyc);
			boardLabel.setMouseListener(ny, currentIcon, property, "/NYaPC.png");
			
			tenn = new JLabel(boardLabel.imgConversion("tennessee.png"));
			boardLabel.setAllSizes(tenn, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 2;
			add(tenn, propertyc);
			boardLabel.setMouseListener(tenn, currentIcon, property, "/TennPC.png");
			
			cchest2 = new JLabel(boardLabel.imgConversion("communitycl.png"));
			boardLabel.setAllSizes(cchest2, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 3;
			add(cchest2, propertyc);
			boardLabel.setMouseListener(cchest2, currentIcon, property, "/cchestPC.png");
			
			stj = new JLabel(boardLabel.imgConversion("stjames.png"));
			boardLabel.setAllSizes(stj, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 4;
			add(stj, propertyc);
			boardLabel.setMouseListener(stj, currentIcon, property, "/JamesPC.png");
			
			penn = new JLabel(boardLabel.imgConversion("pennrail.png"));
			boardLabel.setAllSizes(penn, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 5;
			add(penn, propertyc);
			boardLabel.setMouseListener(penn, currentIcon, property, "/PennRailPC.png");
			
			virg = new JLabel(boardLabel.imgConversion("virginia.png"));
			boardLabel.setAllSizes(virg, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 6;
			add(virg, propertyc);
			boardLabel.setMouseListener(virg, currentIcon, property, "/VirginiaPC.png");
			
			stat = new JLabel(boardLabel.imgConversion("states.png"));
			boardLabel.setAllSizes(stat, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 7;
			add(stat, propertyc);
			boardLabel.setMouseListener(stat, currentIcon, property, "/StatesPC.png");
			
			ele = new JLabel(boardLabel.imgConversion("electric.png"));
			boardLabel.setAllSizes(ele, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 8;
			add(ele, propertyc);
			boardLabel.setMouseListener(ele, currentIcon, property, "/ElectricPC.png");
			
			stc = new JLabel(boardLabel.imgConversion("stcharles.png"));
			boardLabel.setAllSizes(stc, propertyl);
			propertyc.gridx = 0;
			propertyc.gridy = 9;
			add(stc, propertyc);
			boardLabel.setMouseListener(stc, currentIcon, property, "/CharlesPC.png");
			
			con = new JLabel(boardLabel.imgConversion("connecticut.png"));
			boardLabel.setAllSizes(con, propertyr);
			propertyc.gridx = 1;
			propertyc.gridy = 10;
			add(con, propertyc);
			boardLabel.setMouseListener(con, currentIcon, property, "/ConnPC.png");
			
			ver = new JLabel(boardLabel.imgConversion("vermont.png"));
			boardLabel.setAllSizes(ver, propertyr);
			propertyc.gridx = 2;
			propertyc.gridy = 10;
			add(ver, propertyc);
			boardLabel.setMouseListener(ver, currentIcon, property, "/VermontPC.png");
			
			chance = new JLabel(boardLabel.imgConversion("chanced.png"));
			boardLabel.setAllSizes(chance, propertyr);
			propertyc.gridx = 3;
			propertyc.gridy = 10;
			add(chance, propertyc);
			boardLabel.setMouseListener(chance, currentIcon, property, "/chancePC.png");
			
			ori = new JLabel(boardLabel.imgConversion("oriental.png"));
			boardLabel.setAllSizes(ori, propertyr);
			propertyc.gridx = 4;
			propertyc.gridy = 10;
			add(ori, propertyc);
			boardLabel.setMouseListener(ori, currentIcon, property, "/OrientalPC.png");
			
			rrail = new JLabel(boardLabel.imgConversion("readingrail.png"));
			boardLabel.setAllSizes(rrail, propertyr);
			propertyc.gridx = 5;
			propertyc.gridy = 10;
			add(rrail, propertyc);
			boardLabel.setMouseListener(rrail, currentIcon, property, "/ReadingRailPC.png");
			
			tax1 = new JLabel(boardLabel.imgConversion("inctax.png"));
			boardLabel.setAllSizes(tax1, propertyr);
			propertyc.gridx = 6;
			propertyc.gridy = 10;
			add(tax1, propertyc);
			boardLabel.setMouseListener(tax1, currentIcon, property, "/inctaxPC.png");
			
			balt = new JLabel(boardLabel.imgConversion("baltic.png"));
			boardLabel.setAllSizes(balt, propertyr);
			propertyc.gridx = 7;
			propertyc.gridy = 10;
			add(balt, propertyc);
			boardLabel.setMouseListener(balt, currentIcon, property, "/BalticPC.png");
			
			cchest = new JLabel(boardLabel.imgConversion("communitycd.png"));
			boardLabel.setAllSizes(cchest, propertyr);
			propertyc.gridx = 8;
			propertyc.gridy = 10;
			add(cchest, propertyc);
			boardLabel.setMouseListener(cchest, currentIcon, property, "/cchestPC.png");
			
			med = new JLabel(boardLabel.imgConversion("mediterranean.png"));
			boardLabel.setAllSizes(med, propertyr);
			propertyc.gridx = 9;
			propertyc.gridy = 10;
			add(med, propertyc);
			boardLabel.setMouseListener(med, currentIcon, property, "/MedPC.png");
			
			jail = new JLabel(boardLabel.imgConversion("jail.png"));
			boardLabel.setAllSizes(jail, squared);
			squarec.gridx = 0;
			squarec.gridy = 10;
			add(jail, squarec);
			boardLabel.setMouseListener(jail, currentIcon, property, "/jailPC.png");
			
			center = new JLabel(boardLabel.imgConversion("center.png"));
			boardLabel.setAllSizes(center, centerd);
			centerc.gridx = 1;
			centerc.gridy = 1;
			add(center, centerc);

            // listen for mouse presses
//            addMouseListener(new MouseAdapter() {
//                public void mousePressed(MouseEvent e) {
//                    System.out.println("Clicked");
//                    player.setDestination(e.getX(), e.getY());
//                }
//            });

            // set up message font
            //font = new Font("SansSerif", Font.BOLD, 24);
            //metrics = this.getFontMetrics(font);

            x = 950;
            y = 950;
           
            property.setPreferredSize(new Dimension(320, 408));
        	property.setVisible(true);
        	
        	//revalidate();
        	//initPoints();
//            
        }   // end of 'Board()'
        
//        public void setScratchBuffer(BufferedImage image)
//        {
//        	scratchBuffer = image;
//        	dbg = scratchBuffer.createGraphics();
//        }

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

//        private void readyForTermination() {
//            addKeyListener(new KeyAdapter() {
//                public void keyPressed(KeyEvent e) {
//
//                    // listen for escape, q, or ctrl-c
//                    int keyCode = e.getKeyCode();
//                    if ((keyCode == KeyEvent.VK_ESCAPE)
//                                    || (keyCode == KeyEvent.VK_Q)
//                                    || (keyCode == KeyEvent.VK_END)
//                                    || ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
//                        running = false;
//                    }
//                }
//            });
//        }

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

                    // clearing the background
                    //dbg.setColor(Color.BLACK);
                    //dbg.fillRect(0, 0, scratchBuffer.getWidth(), scratchBuffer.getHeight());

                    //drawing game elements....
                    dbg.setColor(new Color(0, 0, 0 , 0));
                    dbg.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
                    dbg.fillRect(0,0, scratchBuffer.getWidth(), scratchBuffer.getHeight());
                    paintChildren(dbg);
                    //player.draw(dbg, this);

                    if (gameOver) {
                       gameOverMessage(dbg);
                    } // end of gameRender()
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
                GameHandler.getPlayer(0).getIcon().move();
                GameHandler.getPlayer(1).getIcon().move();
            }
        }

        private void gameOverMessage(Graphics g) // center the game-over message
        { // code to calculate x and y...
            String msg = "Game Over";
            g.drawString(msg, x, y);
        }  // end of gameOverMessage( )

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
                sleep = (period - timeDiff); // - overSleepTime; // time left in this loop

                if (sleep > 0) { // some time left in this cycle
                    try {
                        Thread.sleep(sleep); // nano -> ms
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                } else {      // sleep <= 0; frame took longer than the delay
                    System.out.println("Over...");
                }

                beforeTime = System.currentTimeMillis();
            }
            System.exit(0);
        } // end of run();
        
        public JLabel getProperty()
        {
        	return property;
        }
        
        public void paintChildren(Graphics g)
        {
        	super.paintChildren(g);
        	GameHandler.getPlayer(0).getIcon().draw(g, this);
        	GameHandler.getPlayer(1).getIcon().draw(g, this);
        }
        
//        public void initPoints()
//        {
//        	medx = med.getX(); xCods.add(medx);
//        	cchestx = cchest.getX(); xCods.add(cchestx);
//        	baltx = balt.getX(); xCods.add(baltx);
//        	tax1x = tax1.getX(); xCods.add(tax1x);
//        	rrailx = rrail.getX(); xCods.add(rrailx);
//        	orix = ori.getX(); xCods.add(orix);
//        	chancex = chance.getX(); xCods.add(chancex);
//        	verx = ver.getX(); xCods.add(verx);
//        	conx = con.getX(); xCods.add(conx);
//        	jailx = jail.getX(); xCods.add(jailx);
//        	stcx = stc.getX(); xCods.add(stcx);
//        	elex = ele.getX(); xCods.add(elex);
//        	statx = stat.getX(); xCods.add(statx);
//        	virgx = virg.getX(); xCods.add(virgx);
//        	pennx = penn.getX(); xCods.add(pennx);
//        	stjx = stj.getX(); xCods.add(stjx);
//        	cchest2x = cchest2.getX(); xCods.add(cchest2x);
//        	tennx = tenn.getX(); xCods.add(tennx);
//        	nyx = ny.getX(); xCods.add(nyx);
//        	fparkx = fpark.getX(); xCods.add(fparkx);
//        	kentx = kent.getX(); xCods.add(kentx);
//        	chance2x = chance2.getX(); xCods.add(chance2x);
//        	indx = ind.getX(); xCods.add(indx);
//        	illx = ill.getX(); xCods.add(illx);
//        	borx = bor.getX(); xCods.add(borx);
//        	altax = alta.getX(); xCods.add(altax);
//        	ventx = vent.getX(); xCods.add(ventx);
//        	waterx = water.getX(); xCods.add(waterx);
//        	marvinx = marvin.getX(); xCods.add(marvinx);
//        	gtjailx = gtjail.getX(); xCods.add(gtjailx);
//        	pacificx = pacific.getX(); xCods.add(pacificx);
//        	northx = north.getX(); xCods.add(northx);
//        	cchest3x = cchest3.getX(); xCods.add(cchest3x);
//        	pennavex = pennave.getX(); xCods.add(pennavex);
//        	shortLx = shortL.getX(); xCods.add(shortLx);
//        	chance3x = chance3.getX(); xCods.add(chance3x);
//        	parkx = park.getX(); xCods.add(parkx);
//        	tax2x = tax2.getX(); xCods.add(tax2x);
//        	boardwalkx = boardwalk.getX(); xCods.add(boardwalkx);
//        	gox = go.getX(); xCods.add(gox);
//        	
//        	medy = med.getY(); yCods.add(medy);
//        	cchesty = cchest.getY(); yCods.add(cchesty);
//        	balty = balt.getY(); yCods.add(balty);
//        	tax1y = tax1.getY(); yCods.add(tax1y);
//        	rraily = rrail.getY(); yCods.add(rraily);
//        	oriy = ori.getY(); yCods.add(oriy);
//        	chancey = chance.getY(); yCods.add(chancey);
//        	very = ver.getY(); yCods.add(very);
//        	cony = con.getY(); yCods.add(cony);
//        	jaily = jail.getY(); yCods.add(jaily);
//        	stcy = stc.getY(); yCods.add(stcy);
//        	eley = ele.getY(); yCods.add(eley);
//        	staty = stat.getY(); yCods.add(staty);
//        	virgy = virg.getY(); yCods.add(virgy);
//        	penny = penn.getY(); yCods.add(penny);
//        	stjy = stj.getY(); yCods.add(stjy);
//        	cchest2y = cchest2.getY(); yCods.add(cchest2y);
//        	tenny = tenn.getY(); yCods.add(tenny);
//        	nyy = ny.getY(); yCods.add(nyy);
//        	fparky = fpark.getY(); yCods.add(fparky);
//        	kenty = kent.getY(); yCods.add(kenty);
//        	chance2y = chance2.getY(); yCods.add(chance2y);
//        	indy = ind.getY(); yCods.add(indy);
//        	illy = ill.getY(); yCods.add(illy);
//        	bory = bor.getY(); yCods.add(bory);
//        	altay = alta.getY(); yCods.add(altay);
//        	venty = vent.getY(); yCods.add(venty);
//        	watery = water.getY(); yCods.add(watery);
//        	marviny = marvin.getY(); yCods.add(marviny);
//        	gtjaily = gtjail.getY(); yCods.add(gtjaily);
//        	pacificy = pacific.getY(); yCods.add(pacificy);
//        	northy = north.getY(); yCods.add(northy);
//        	cchest3y = cchest3.getY(); yCods.add(cchest3y);
//        	pennavey = pennave.getY(); yCods.add(pennavey);
//        	shortLy = shortL.getY(); yCods.add(shortLy);
//        	chance3y = chance3.getY(); yCods.add(chance3y);
//        	parky = park.getY(); yCods.add(parky);
//        	tax2y = tax2.getY(); yCods.add(tax2y);
//        	boardwalky = boardwalk.getY(); yCods.add(boardwalky);
//        	goy = go.getY(); yCods.add(goy);
//        	
//        
//        }
        
        public static int getPropertyX(int n)
        {
        	return xCods.get(n);
        }
        
        public static int getPropertyY(int n)
        {
        	return yCods.get(n);
        }
    }
