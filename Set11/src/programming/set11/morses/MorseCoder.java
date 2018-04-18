package programming.set11.morses;

import programming.set11.brownies.BrownieMap;

/**
 * Implementation of a morse code decoder.
 * 
 * @author lukas
 *
 */
public class MorseCoder {

	private BrownieMap<String, Integer> alphabet;
	private BrownieMap<String, Integer> numbers;
	private static final String[] ALPHABET = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };
	private static final String[] NUMBERS = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
			"---..", "----." };

	/**
	 * Creates a new MorseCoder.
	 */
	public MorseCoder() {
		alphabet = new BrownieMap<>(1);
		for (int i = 0; i < ALPHABET.length; i++) {
			alphabet.put(ALPHABET[i], i);
		}
		numbers = new BrownieMap<>(1);
		for (int i = 0; i < NUMBERS.length; i++) {
			numbers.put(NUMBERS[i], i);
		}
	}

	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in morse code format. It does not have leading
	 * or trailing whitespace and exactly a single space character between
	 * consecutive words.
	 * 
	 * @param input
	 *            Morse code input string.
	 * @return natural language version or {@code null} if the input string could
	 *         not be properly parsed.
	 */
	public String decode(String input) {
		String result = "";

		String[] lines = input.split("\\n");

		// convert each lines to one word
		for (String line : lines) {

			String[] morses = line.split("\\s+");

			// convert each morse code to one character
			for (String morse : morses) {
				boolean match = false;

				// letters
				if (alphabet.get(morse) != null) {
					result += Character.toString((char) (alphabet.get(morse) + 'A'));
					match = true;
				}

				// digits
				if (numbers.get(morse) != null) {
					result += Character.toString((char) (numbers.get(morse) + '0'));
					match = true;
				}

				// check for wrong morse codes
				if (!match) {
					return null;
				}
			}

			result += " ";

		}

		return result.trim();
	}
}
