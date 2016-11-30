package frame;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Class to create the rating board at a stroke.
 */
public class RatingBoardCompilation extends JPanel {

    private static final long serialVersionUID = -4098967039827217057L;
    private RatingBoard rate;

    /**
     * The default constructor.
     */
    public RatingBoardCompilation() {

        setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            rate = new RatingBoard();
            add(rate);
        }
    }
}