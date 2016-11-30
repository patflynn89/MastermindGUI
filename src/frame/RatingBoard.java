package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import mastermind.model.Game;

/**
 * Class to set the ratingboard.
 */
public class RatingBoard extends JPanel {
    
    private static final long serialVersionUID = 4025090871511443087L;
    private Color color = Color.LIGHT_GRAY;
    private Game game;
    private boolean isActive = false;
    

    /**
     * Default constructor. A mouselistener is only following if boolean
     * "isActive" true is.
     */
    public RatingBoard() {
        if (isActive) {
            HandlerClass handleRating = new HandlerClass();
            this.addMouseListener(handleRating);
        }
        
    }
    
    /**
     * Change the value of the boolean "isActive".
     * @param isActive The delivered boolean value.
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;

    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fillOval(0, 15, 13, 13);    
        g2d.drawOval(0, 15, 13, 13);
   }
    
    /**
     * Set the color for the ratingboard.
     * @param color The delivered color.
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    
    private class HandlerClass implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            RatingBoard test = (RatingBoard) e.getSource();
            test.setColor(Color.BLACK);
            test.repaint();

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
  
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
 

        }

    }

}