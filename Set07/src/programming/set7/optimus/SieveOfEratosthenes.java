package programming.set7.optimus;

import acm.program.ConsoleProgram;

/**
 * programs that lists prime number up to a given upper limit.
 * 
 * @author lukas
 *
 */
public class SieveOfEratosthenes extends ConsoleProgram {
	@Override
	public void run() {
		int n;

		// ask for input once
		do {
			n = readInt("n >= 2 plz: ");
		} while (n < 2); // and again if not valid

		int[] primes = new int[n - 1];

		// initializing the list
		for (int i = 0; i < n - 1; i++) {
			primes[i] = i + 2;
		}

		for (int i = 0; i < primes.length; i++) {
			for (int j = i; j < primes.length; j++) {
				// don't check factors for number thats already a non prime
				if (primes[i] == -1) {
					break;
				}

				if (primes[j] != primes[i] && primes[j] % primes[i] == 0) {
					primes[j] = -1;
				}
			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i] != -1) {
				println(primes[i]);
			}
		}
	}
}
