package mastermind.model;

import java.util.Arrays;

/**
 * Class to create, set and compare a {@code ColorCode}.
 */
public class ColorCode {
    private int[] colors;
    
    /**
     * Constructor with no paramters. The {@code ColorCode} has the size of 4
     * slots.
     */
    public ColorCode() {
        this.colors = new int[MastermindGame.NUMBER_SLOTS];
    }

    /**
     * Constructor with an given parameter.
     * 
     * @param colors
     *            Create a {@code ColorCode} with these {@code colors}.
     */
    public ColorCode(int[] colors) {
        this.colors = colors;
    } 
    
    
    /**
     * Help methode to realize the container for all choices of the {@code 
     * ColorCode}.
     * 
     * @param position
     *            Set on {@code position} this given {@code} value.
     * @param value
     *            The given {@code value}.
     */
    public void set(int position, int value) {
        this.colors[position] = value;
    }

    /**
     * Compare the {@code ColorCode secretCode} with the given code
     * to compute the white spikes.
     * 
     * @param secretCode
     *            The given {@code ColorCode secretCode}.
     * @return The number of white spikes.
     */

    public int getWhite(ColorCode secretCode) {
        int white = 0;
        int[] potsA = new int[6];
        int[] potsB = new int[6];
        int black = getBlack(secretCode);

        for (int i = 0; i < secretCode.colors.length; i++) {
            potsA[secretCode.colors[i]]++;
            potsB[this.colors[i]]++;
        }
        int result = 0;
        for (int j = 0; j < 6; j++) {
            result += Math.min(potsA[j], potsB[j]);
        }
        white = result - black;
        return white;
    }

    /**
     * Compare the {@code ColorCode secretCode} with the given code to compute
     * the black spikes.
     * 
     * @param secretCode
     *            The given {@code secretCode}.
     * @return The number of black spikes.
     */
    public int getBlack(ColorCode secretCode) {
        int black = 0;
        
        for (int i = 0; i < colors.length; i++) {
            if ((this.colors[i]) == (secretCode.colors[i])) {
                black++;
            }
        }
        return black;
    }


    @Override
    public boolean equals(Object o) {
        ColorCode otherCode = (ColorCode) o;
        return Arrays.equals(this.colors, otherCode.colors);
    }
    
    @Override
    public int hashCode() {
        return colors.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        for (int color : colors) {
            c.append(color).append(" ");
        }
        return c.toString();
    }

}