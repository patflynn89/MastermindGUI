package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import mastermind.model.Game;

/**
 * 
 * Class to construct the colorslots.
 *
 */
public class ColorSlot extends JPanel {

    private static final long serialVersionUID = 2315406788433573154L;
    private Color color = Color.LIGHT_GRAY;
    private boolean isActive = true;
    private int row;
    private int column;
    private HashMap hashmap;

    /**
     * Default constructor for creating one colorslot. If isActive is true, then
     * a mouslistener is added to the colorslot.
     */
    public ColorSlot() {
        if (isActive) {
            HandlerClass handleSlot = new HandlerClass();
            this.addMouseListener(handleSlot);

        }

    }

    /**
     * Constructor with two parameters, to get the exact position of the slot.
     * 
     * @param row
     *            The row of the color in the gameboard.
     * @param column
     *            The column of the color in the gameboard.
     */
    public ColorSlot(int row, int column) {
        this.row = row;
        this.column = column;
        HandlerClass handleSlot = new HandlerClass();
        this.addMouseListener(handleSlot);
    }

    /**
     * Set the activation of the construktor.
     * 
     * @param isActive
     *            If it's true, then a mouselistener "listens" to the colorslot,
     *            otherwise not.
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;

    }

    /**
     * Set the row for the colorslot.
     * 
     * @param row
     *            The row where the colorslot should be stored.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Set the column for the colorslot.
     * 
     * @param column
     *            The column where the colorslot should be stored.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return The row of the current colorslot.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return The column of the current colorslot.
     */
    public int getColumn() {
        return this.column;
    }

    // public void compare() {
    // this.hashmap = new HashMap(row, this.color);
    //
    // }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fillOval(0, 17, 30, 30);
        g2d.drawOval(0, 17, 30, 30);
    }

    /**
     * Methode to get the color of the colorslot.
     * @return The color object.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the color of the current colorslot.
     * @param chosenColor The delivered color.
     */
    public void setColor(Color chosenColor) {
        this.color = chosenColor;
    }

    private class HandlerClass implements MouseListener {

        private ColorSlot colorSlot;
        private Game game;

        @Override
        public void mouseClicked(MouseEvent e) {
            this.colorSlot = (ColorSlot) e.getComponent();
            this.game = new Game(!(isActive));

            JPopupMenu popup = new JPopupMenu();
            popup.setPopupSize(80, 80);
            popup.setLayout(new GridLayout(7, 1));

            JMenuItem blue = new JMenuItem("Blue");
            blue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputBlue();
                    repaint();
                    removeAll();
                }

                private void handleInputBlue() {
                    colorSlot.setColor(Color.BLUE);
                    repaint();
                    removeAll();
                }
            });

            JMenuItem magenta = new JMenuItem("Magenta");
            magenta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputOrange();
                    repaint();
                    removeAll();
                }

                private void handleInputOrange() {
                    colorSlot.setColor(Color.MAGENTA);
                    repaint();
                    removeAll();
                }
            });

            JMenuItem pink = new JMenuItem("Pink");
            pink.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputPink();
                    repaint();
                    removeAll();
                }

                private void handleInputPink() {
                    colorSlot.setColor(Color.PINK);
                    repaint();
                    removeAll();
                }
            });

            JMenuItem yellow = new JMenuItem("Yellow");
            yellow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputYellow();
                    repaint();
                    removeAll();
                }

                private void handleInputYellow() {
                    colorSlot.setColor(Color.YELLOW);
                    repaint();
                    removeAll();
                }
            });

            JMenuItem red = new JMenuItem("Red");
            red.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputRed();
                    repaint();
                    removeAll();
                }

                private void handleInputRed() {
                    colorSlot.setColor(Color.RED);
                    repaint();
                    removeAll();
                }
            });

            JMenuItem green = new JMenuItem("Green");
            green.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    handleInputGreen();
                    repaint();
                    removeAll();
                }

                private void handleInputGreen() {
                    colorSlot.setColor(Color.GREEN);
                    repaint();
                    removeAll();
                }
            });

            popup.show(colorSlot, colorSlot.getX() + 10, colorSlot.getY() + 10);
            popup.add(red);
            popup.add(magenta);
            popup.add(yellow);
            popup.add(pink);
            popup.add(blue);
            popup.add(green);
            popup.show(e.getComponent(), e.getX(), e.getY());
            popup.setVisible(true);
            add(popup);

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