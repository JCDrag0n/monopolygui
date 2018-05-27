import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
//import javax.tools.Tool;

public class Icon {

        private int positionX;
        private int positionY;
        private int destinationX;//Used when moving from place to place
        private int destinationY;
        //private Tool currentTool;
        //private int direction; //Position the image is facing
        private int dx;
        private int dy;
        private String spriteSource;
        private ImageIcon spriteIcon;
        private Image sprite;
        private boolean visible = true;
        //private Image playerImage;

        public Icon(String source) {
            positionX = 950;
            positionY = 950;
            dx = 4;
            dy = 4;
            destinationX = (int) positionX;
            destinationY = (int) positionY;
            spriteSource = source;
            spriteIcon = new ImageIcon(this.getClass().getResource(source));
            sprite = spriteIcon.getImage();

            //this.playerImage=playerImage;
        }

        public void doAction() {
            //currentTool.getNum();
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(Boolean visible) {
            this.visible = visible;
        }

        public Image getImage() {
            return sprite;
        }

        public void move() {
            if (destinationX != positionX || destinationY != positionY) {
                //MOVE LEFT AND RIGHT
                if (destinationX < positionX) {
                    positionX -= dx;
                }
                if (destinationX > positionX) {
                    positionX += dx;
                }

                //MOVE UP AND DOWN
                if (destinationY < positionY) {
                    positionY -= dy;
                }
                if (destinationY > positionY) {
                    positionY += dy;
                }
            }
        }

        public void setDestination(int x, int y) {
            destinationX = x;
            destinationY = y;
        }

        public void draw(Graphics g, ImageObserver io) {
            g.drawImage(sprite, (int) positionX, (int) positionY, io);
        }
    }