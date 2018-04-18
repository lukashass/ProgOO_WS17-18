package programming.set10.dna;

/**
 * Implementation of String based DNA matching.
 * 
 * @author lukas
 *
 */
public class DNAMatcher {

	String base;

	/**
	 * Creates a new base DNA.
	 * 
	 * @param base
	 *            String representing the new DNA.
	 */
	public DNAMatcher(String base) {
		validate(base);
		this.base = base;
	}

	/**
	 * Returns the index of the first position in the base DNA string where
	 * candidateDNA can bind, if any.
	 * 
	 * @param candidate
	 *            the DNA string to try to bind to the base DNA.
	 * @return index of the first binding position or {@code -1} if the candidate
	 *         DNA string cannot bind to the base string.
	 * @throws IllegalArgumentException
	 *             if {@code candidateDNA} is {@code null}, empty, or contains
	 *             characters other than A, C, G, and T.
	 */
	public int findFirstBindingPosition(String candidate) {
		validate(candidate);

		// all indices able to match the candidate.
		int matchingLength = base.length() - candidate.length() + 1;

		for (int i = 0; i < matchingLength; i++) {

			// if first char of candidate matches
			if (isMatch(base.charAt(i), candidate.charAt(0))) {

				// check if the rest of candidate matches as well.
				if (isMatchRest(i, candidate)) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * Check whether whole candidate matches at a position in the base.
	 * 
	 * @param i
	 *            Position in the base DNA.
	 * @param candidate
	 *            the DNA string to try to bind to the base DNA.
	 * @return {@code true} when whole candidate matches at position {@code i} in
	 *         base DNA, otherwise {@code false}.
	 */
	private boolean isMatchRest(int i, String candidate) {
		for (int j = 0; j < candidate.length(); j++) {

			// only no match if one char doesn't match.
			if (!isMatch(base.charAt(i + j), candidate.charAt(j))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if input is valid.
	 * 
	 * @param dna
	 *            The DNA String to check.
	 */
	private void validate(String dna) {
		if (dna == null || dna.isEmpty() || !isValidDNA(dna)) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Checks if input String only contains valid DNA bases.
	 * 
	 * @param dna
	 *            The DNA String to check.
	 * @return {@code true} when is valid DNA string, otherwise {@code false}.
	 */
	private boolean isValidDNA(String dna) {
		for (int i = 0; i < dna.length(); i++) {

			// only invalid if one base is not A, C, G or T.
			if (dna.charAt(i) != 'A' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G' && dna.charAt(i) != 'T') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if two bases match each other by applying science.
	 * 
	 * @param x
	 *            First base to match.
	 * @param y
	 *            Second base to match.
	 * @return {@code true} when bases match, otherwise {@code false}.
	 */
	private boolean isMatch(char x, char y) {
		return x == 'A' && y == 'T' || x == 'T' && y == 'A' || x == 'C' && y == 'G' || x == 'G' && y == 'C';
	}
}
