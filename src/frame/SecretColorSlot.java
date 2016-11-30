package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Class for the secret colorcode of the game.
 */
public class SecretColorSlot extends JPanel {

    private static final long serialVersionUID = -8185018496505358335L;   
    private Color color = Color.LIGHT_GRAY;
    private boolean isActive = false;

    /**
     * Default constructor 
     */
    public SecretColorSlot() {
        if (isActive) {
            HandlerClass handleSecretCode = new HandlerClass();
            this.addMouseListener(handleSecretCode);
        }
        

    }
    
    /**
     * Methode to activate the mouselistener.
     * @param isActive The boolean which is going to change.
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;

    }
    
    /**
     * Set the color of the current secretColorSlot.
     * @param color The delivered color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fillOval(0, 28, 30, 30);
        g2d.drawOval(0, 28, 30, 30);
    }

    private class HandlerClass implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            SecretColorSlot test = (SecretColorSlot) e.getSource();
            test.setColor(Color.green);
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