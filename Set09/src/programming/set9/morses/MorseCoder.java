package programming.set9.morses;

/**
 * Implementation of morse conversion.
 * 
 * @author lukas
 *
 */
public class MorseCoder {

	private static final String[] ALPHABET = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };
	private static final String[] NUMBERS = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
			"---..", "----." };

	/**
	 * Returns a new string which is the Morse code version of the input string.
	 * Each word is on a separate line. The morse representation of each character
	 * of the input string is separated from the next by one or more space
	 * characters in the output string.
	 * 
	 * @param input
	 *            the input string.
	 * @return the Morse code version of the input string, ignoring all characters
	 *         in the input string that cannot be represented in international morse
	 *         code.
	 */
	public static String encode(String input) {
		String[] words = input.toLowerCase().split("\\s");
		String result = "";

		// covert each word
		for (String word : words) {

			// convert each character
			for (int i = 0; i < word.length(); i++) {

				// handle letters
				if (Character.toString(word.charAt(i)).matches("[a-z]")) {
					result += ALPHABET[word.charAt(i) - 'a'] + " ";
				}

				// handle digits
				if (Character.isDigit(word.charAt(i))) {
					result += NUMBERS[word.charAt(i) - '0'] + " ";
				}
			}

			result += "\n";

		}

		return result;
	}

	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in Morse code format as produced by the encode
	 * method.
	 * 
	 * @param input
	 *            Morse code input string.
	 * @return natural language version or {@code null} if the input string could
	 *         not be properly parsed.
	 */
	public static String decode(String input) {
		String result = "";

		String[] lines = input.split("\\n");

		// convert each lines to one word
		for (String line : lines) {

			String[] morses = line.split("\\s+");

			// convert each morse code to one character
			for (String morse : morses) {
				boolean match = false;

				// letters
				for (int i = 0; i < ALPHABET.length; i++) {
					if (ALPHABET[i].equals(morse)) {
						result += Character.toString((char) (i + 'A'));
						match = true;
					}
				}

				// digits
				for (int i = 0; i < NUMBERS.length; i++) {
					if (NUMBERS[i].equals(morse)) {
						result += Character.toString((char) (i + '0'));
						match = true;
					}
				}

				// check for wrong morse codes
				if (!match) {
					return null;
				}
			}

			result += " ";

		}

		return result;
	}
}
