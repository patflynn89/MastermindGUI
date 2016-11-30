package mastermind.model;

/**
 * Class to rate the guessed {@code ColorCode}.
 */
public class Rating {
	private int black;
	private int white;

	/**
	 * Constructor to store the number of black and white spikes.
	 * 
	 * @param black
	 *            Amount of black spikes.
	 * @param white
	 *            Amount of white spikes.
	 */
	public Rating(int black, int white) {
		this.black = black;
		this.white = white;
	}

	/**
	 * Getter for the number of white spikes.
	 * 
	 * @return The count of white spikes.
	 */
	public int getWhite() {
		return this.white;
	}

	/**
	 * Getter for the number of black spikes.
	 * 
	 * @return The count of black spikes.
	 */
	public int getBlack() {
		return this.black;
	}

	@Override
	public boolean equals(Object otherObject) {
		Rating otherRating = (Rating) otherObject;
		return (this.black == otherRating.black && this.white == otherRating.white);
	}

	@Override
	public int hashCode() {
		return hashCode();
	}
}