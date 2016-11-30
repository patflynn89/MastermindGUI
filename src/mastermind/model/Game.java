package mastermind.model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The {@code Game} class which implements the interface {@code MastermindGame}
 * and is responsible for a logical game.
 */
public class Game implements MastermindGame {

    private int noPossibilities;
    private ColorCode[] allGuesses;
    private ArrayList<ColorCode> possibilities;
    private ColorCode secretMachineCode;
    private boolean isMachineGuessing;
    private int moveCount;
    private int attempts;

    /**
     * Constructor for the {@code Game} with no parameters. It creates instantly
     * a {@code ColorCode secretMachineCode} and it also generates a container
     * with all color choices for the machine.
     * 
     * @param machineGuessing
     *            Initial false.
     */
    public Game(boolean machineGuessing) {
        this.isMachineGuessing = machineGuessing;
        this.allGuesses = new ColorCode[MAX_MOVES + 2];
        countOfAttempts();

        if (isMachineGuessing) {
            this.possibilities = generateContainer();
            machineMove();
        } else {
            this.secretMachineCode = createSecretMachineCode();
        }
        this.moveCount = 0;
    }

    /**
     * Methode to get the count of the maximal moves.
     * @return The amount of attempts you have.
     */
    public int countOfAttempts() {
        this.attempts = 6;
        return attempts;
    }

    /**
     * Generate a container for all choices.
     * 
     * @return The container with all the color choices of the computer.
     */
    private ArrayList<ColorCode> generateContainer() {
        this.noPossibilities = (int) Math.pow(NUMBER_COLORS, NUMBER_SLOTS);
        ArrayList<ColorCode> container = new ArrayList<ColorCode>();
        for (int i = 0; i < noPossibilities; ++i) {
            ColorCode colorCode = new ColorCode();
            int current = i;
            for (byte j = MastermindGame.NUMBER_SLOTS - 1; j >= 0; --j) {
                colorCode.set(j,
                        (byte) (current % (int) MastermindGame.NUMBER_COLORS));
                current = current / MastermindGame.NUMBER_COLORS;
            }
            container.add(colorCode);
        }

        return container;
    }

    /**
     * Methode to generate the secret {@code code}.
     * 
     * @return The secret {@code code}, stored in an array.
     */
    private ColorCode generateCode() {
        int[] code = new int[NUMBER_SLOTS];
        for (int i = 0; i < 4; i++) {
            code[i] = (int) (Math.random() * 6);
        }

        ColorCode tmp = new ColorCode(code);
        return tmp;
    }

    /**
     * Create the secret {@code secretMachineCode}.
     * 
     * @return The secret {@code secretMachineCode}.
     */
    private ColorCode createSecretMachineCode() {
        secretMachineCode = generateCode();
        return secretMachineCode;
    }

    @Override
    public void switchGuesser() {
        isMachineGuessing = !isMachineGuessing;
        this.moveCount = 0;
        this.allGuesses = new ColorCode[MAX_MOVES];
        if (isMachineGuessing) {
            this.possibilities = generateContainer();
            machineMove();
        } else {
            this.secretMachineCode = createSecretMachineCode();
        }
    }

    /**
     * Help methode to find out, if the game is over.
     * 
     * @return True, if the six move of the game is reached, otherwise false.
     */
    private boolean gameOver() {
        return (moveCount >= attempts);
    }

    @Override
    public boolean isMachineGuessing() {
        return isMachineGuessing;
    }

    @Override
    public int getMoveCount() {
        return this.moveCount;
    }

    @Override
    public ColorCode getGameState(int moveNo) {
        return allGuesses[moveNo];
    }

    // to do..
    @Override
    public Rating getRating(int moveNo) {
        Rating machineRating = new Rating(getGameState(moveNo).getBlack(
                this.secretMachineCode), getGameState(moveNo).getWhite(
                this.secretMachineCode));
        return machineRating;
    }

    @Override
    public ColorCode getSecret() {
        return this.secretMachineCode;
    }

    @Override
    public void humanMove(ColorCode move) {
        if (!gameOver()) {
            if (!winner(move)) {
                this.moveCount++;
                setGuess(moveCount, move);
                int black = move.getBlack(secretMachineCode);
                int white = move.getWhite(secretMachineCode);
                System.out.println("black: " + black + " white: " + white);
            } else {
                System.out.println("Wow you did it in only " + moveCount
                        + " moves !");
            }
        } else if (winner(move)) {
            System.out.println("Wow you did it !");
        } else if (moveCount == attempts) {
            System.out.println("No more move - solution: " + secretMachineCode);

        } else {
            System.out.println("Error! Game over.");
        }
    }

    /**
     * Compare the guessed color choice of the human with the secret
     * {@code secretMachineCode}.
     * 
     * @param move
     *            The human guess.
     * @return True, if both {@code ColorCode}s are equal, otherwise it's false.
     */
    private boolean winner(ColorCode move) {
        return (move.equals(secretMachineCode));
    }

    /**
     * Help methode to set a ColorCode.
     * 
     * @param pos
     *            The moveCount of the game.
     * @param value
     *            The value of the ColorCode.
     */
    private void setGuess(int pos, ColorCode value) {
        this.allGuesses[pos] = value;
    }

    @Override
    public ColorCode machineMove() {
        if (possibilities.size() == 0 && !gameOver()) {
            System.out.print("Error! Wrong evaluation of the ");
            return getGameState(moveCount);
        } else if (possibilities.equals(null)) {
            System.out.println("Error! The game is over.");
            return getGameState(moveCount);
        } else if (possibilities.size() == 1 && moveCount < 7) {
            this.moveCount++;
            setGuess(moveCount, possibilities.get(0));
            System.out.println("Wow you did it! - ");
            return getGameState(moveCount);
        } else if (moveCount < 7 && possibilities.size() > 0) {
            this.moveCount++;
            setGuess(moveCount, possibilities.get(0));
            // this.moveCount++;
            return getGameState(moveCount);
        } else {
            // ++moveCount;
            System.out.print("Game over - last guessed code: ");
            return getGameState(moveCount);
        }
    }

    @Override
    public void processEval(ColorCode move, Rating humanRating) {
        Rating tmpRating;
        ColorCode currentCC;
        LinkedList<ColorCode> choicesToDelete = new LinkedList<ColorCode>();
        for (int i = 0; i < possibilities.size(); i++) {
            currentCC = possibilities.get(i);
            tmpRating = new Rating(move.getBlack(currentCC),
                    move.getWhite(currentCC));

            if (!tmpRating.equals(humanRating)) {
                choicesToDelete.add(currentCC);
            }
        }

        possibilities.removeAll(choicesToDelete);
    }
}