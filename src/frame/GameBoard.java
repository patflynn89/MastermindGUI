package frame;

import java.awt.GridLayout;

import javax.swing.JPanel;

import mastermind.model.Game;

/**
 * Class to create the gameboard of the game.
 */
public class GameBoard extends JPanel {

    private static final long serialVersionUID = 929709010723950943L;
    private RatingBoardCompilation[] rating;
    private int counter;
    private ColorSlot colorSlot;
    private SecretColorSlot secretCodeSlot;
    private HashMap hashmap;

    /**
     * Default constructor of the game.
     */
    public GameBoard() {
        
        setLayout(new GridLayout(8, 2));
        colorSlot = new ColorSlot();
        colorSlot.setLayout(new GridLayout(1, 4));
        rating = new RatingBoardCompilation[Game.MAX_MOVES];
        int row = 1;
        int column = 1;
        counter = 0;
        while (counter < Game.MAX_MOVES) {                        
            column = 1;
            for (int i = 0; i < 4; i++) {           
                colorSlot = new ColorSlot(row, column);
                add(colorSlot);     
                ++column;
            }
            ++row;

            rating[counter] = new RatingBoardCompilation();
            add(rating[counter]);
            counter++;

        }

        secretCodeSlot = new SecretColorSlot();
        secretCodeSlot.setLayout(new GridLayout(1, 4));
        for (int i = 0; i < 4; i++) {
            secretCodeSlot = new SecretColorSlot();
            add(secretCodeSlot);
        }
    }
    

}