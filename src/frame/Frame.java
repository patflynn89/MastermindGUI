package frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mastermind.model.Game;

/**
 * Class for the mainframe of the program.
 */
public class Frame extends JFrame {

    private static final long serialVersionUID = -2593592374420706948L;
    private JLabel notification;
    private GameBoard gameBoard;
    private JPanel buttons;
    private int moveNo;
    private Game game;

    /**
     * The main methode of the frame.
     * @param args The delivered components.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame();
                frame.setVisible(true);
            }
        });
        
    }

    /**
     * The constructor of the frame.
     */
    public Frame() {
        super("Mastermind");        
        createFrame(300, 600);
        this.game = new Game(false);
        this.notification = new JLabel();       
        add(manageNotification(), BorderLayout.NORTH);
        moveNo = this.game.getMoveCount();
            
        this.gameBoard = new GameBoard();
        add(gameBoard, BorderLayout.CENTER);
  
        this.buttons = new JPanel(new FlowLayout());
        addNew();
        addMove();
        addSwitch();
        add(this.buttons, BorderLayout.SOUTH);       

    }
  
    /**
     * Add the switch button onto the gameboard.
     */
    private void addSwitch() {
        JButton switchButton = new JButton("Switch");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                switchInput();
            }

        });
        this.buttons.add(switchButton);

    }

    private void switchInput() {
        
        if (this.game.isMachineGuessing()) {
            this.moveNo = 0;     
            this.game.switchGuesser();
            this.notification.setText("Human guess. Select a color.");
            add(this.notification, BorderLayout.NORTH);
            repaint();
            return;
        }
        
        if (!(this.game.isMachineGuessing())) {
            this.moveNo = 0;            
            this.game.switchGuesser();
            this.notification.setText("Machine guess. Please select"
                    + " black/white.");
            add(this.notification, BorderLayout.NORTH);
            repaint();
            return;
        }
    }

    

    private void addMove() {
        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                moveInput();
            }

        });
        this.buttons.add(moveButton);
    }

    private void moveInput() {
        if (this.moveNo < 7) {
            //to do..-> only if there is a valid choice then moveNo++, otherwise
            //not increment
            if (this.game.isMachineGuessing()) {
                this.moveNo++;
                return;                
            }
            if (!(this.game.isMachineGuessing())) {
                this.moveNo++;
                return;
            }
        } else {
             String errorMessage = "Error! Game over.";
             JOptionPane.showMessageDialog(null, errorMessage,
             "Error", JOptionPane.ERROR_MESSAGE);
        }

    } 

    private void addNew() {
        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                newInput();
            }

        });
        this.buttons.add(newButton);
    }

    private void newInput() {       
        if (this.game.isMachineGuessing()) {
            this.moveNo = 0; 
            repaint();          
            return;     
        } 
        if (!(this.game.isMachineGuessing())) {
            this.moveNo = 0; 
            repaint();           
            return;           
        } else {
            String errorMessage = "Error!";
            JOptionPane.showMessageDialog(null, errorMessage, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
     

    private JLabel manageNotification() {
        
        if (this.game.isMachineGuessing()) {
            this.notification.setText("Machine guess. Please select"
                    + " black/white.");
            return this.notification;
        }
        if (!(this.game.isMachineGuessing())) {
            this.notification.setText("Human guess. Select a color.");
            return this.notification;
        }
        if ((this.game.getMoveCount() > 7)) {
            this.notification.setText("No more moves - Game over.");
            return this.notification;
        }
        if ((this.game.getGameState(moveNo)) == (this.game.getSecret())) {
            this.notification.setText("Congratulations! You've made it !");
            return this.notification;
        } else {
            this.notification.setText("Error!");
            return this.notification;
        }

    }

    /**
     * Methode to create the whole frame.
     * @param breadth The breadth of the frame.
     * @param height The height of the frame.
     */
    public void createFrame(int breadth, int height) {
        setSize(breadth, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

}