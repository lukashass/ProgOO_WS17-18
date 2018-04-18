package programming.set6.quiz;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * a program to teach people to calculate sums and differences of numbers.
 * 
 * @author lukas
 *
 */
public class MathQuiz extends ConsoleProgram {

	@Override
	public void run() {
		println("G'Day");
		for (int i = 0; i < 5; i++) {

			RandomGenerator rnd = RandomGenerator.getInstance();
			int op1 = rnd.nextInt(0, 20);
			String operator;
			int op2;
			int res;
			boolean plus = rnd.nextBoolean();
			if (plus) {
				op2 = rnd.nextInt(0, 20 - op1);
				res = op1 + op2;
				operator = "+";
			} else {
				op2 = rnd.nextInt(0, op1);
				res = op1 - op2;
				operator = "-";
			}
			int input = readInt("What is " + op1 + " " + operator + " " + op2 + "? ");
			if (isCorrect(op1, operator, op2, input)) {
				println(generateSuccessMessage());
			} else {
				println(generateFailMessage(res));
			}
		}
	}

	/**
	 * Checks whether the given result is really the result of the operation on the
	 * two operands.
	 * 
	 * @param operand1
	 *            the first operand.
	 * @param operator
	 *            the operator, given as a String. This must be either {@code "+"}
	 *            or {@code "-"}. Otherwise, this method will always return
	 *            {@code false}.
	 * @param operand2
	 *            the second operand.
	 * @param result
	 *            the proposed result.
	 * @return {@code true} if {@code result} is really the result of the
	 *         calculation, {@code false} otherwise.
	 */
	public boolean isCorrect(int operand1, String operator, int operand2, int result) {
		if (operator.equals("+")) {
			return operand1 + operand2 == result;
		}
		if (operator.equals("-")) {
			return operand1 - operand2 == result;
		}
		return false;
	}

	/**
	 * Returns a message that can be displayed to the user after successfully
	 * solving a problem. There are at least four messages the method randomly
	 * chooses from to keep it interesting.
	 * 
	 * @return randomly selected success message.
	 */
	private String generateSuccessMessage() {
		String msg;
		RandomGenerator rnd = RandomGenerator.getInstance();
		int randomNumber = rnd.nextInt(3);
		switch (randomNumber) {
		case 0:
			msg = "Fantastic!";
			break;
		case 1:
			msg = "Wonderful!";
			break;
		case 2:
			msg = "Well done!";
			break;
		case 3:
			msg = "Great!";
			break;
		default:
			msg = "";
			break;
		}
		return msg;
	}

	/**
	 * Returns a message that can be displayed to the user after failing to solve a
	 * problem correctly. There are at least four messages the method randomly
	 * chooses from to keep it interesting. The correct result is included in the
	 * message somewhere to teach the user a lesson.
	 * 
	 * @param correctResult
	 *            the number that would have been the correct result. This number is
	 *            included somehow in the returned message.
	 * @return randomly selected fail message.
	 */
	private String generateFailMessage(int correctResult) {
		String msg;
		RandomGenerator rnd = RandomGenerator.getInstance();
		int randomNumber = rnd.nextInt(3);
		switch (randomNumber) {
		case 0:
			msg = "Wrong! " + correctResult;
			break;
		case 1:
			msg = "Better luck next time! " + correctResult;
			break;
		case 2:
			msg = "Do better! " + correctResult;
			break;
		case 3:
			msg = "Common m8! " + correctResult;
			break;
		default:
			msg = "";
			break;
		}
		return msg;
	}
}
