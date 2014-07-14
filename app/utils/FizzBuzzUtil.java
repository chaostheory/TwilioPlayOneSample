package utils;

import exceptions.InterviewException;

public class FizzBuzzUtil {
	public static final String FIZZBUZZ = "fizzbuzz";
	public static final String FIZZ = "fizz";
	public static final String BUZZ = "buzz";

	/**
	 * Outputs a series of numbers with words (with details below)
	 * 
	 * If a number is both divisible by 5 and 3, then that number is replaced
	 * with the word 'fizzbuzz'. If a number is only divisible by 3, then that
	 * number is replaced with the word 'fizz'. If a number is only divisible by
	 * 5, then that number is replaced with the word 'buzz'.
	 * 
	 * @param lastNumberInSequence
	 *            The end of a fizzbuzz sequence. It must be 1 or greater.
	 * @return
	 * @throws InterviewException
	 */
	public static String fizzBuzz(Long lastNumberInSequence)
			throws InterviewException {
		if (lastNumberInSequence < 1) { throw new InterviewException(
				"The given number cannot be less than 1."); }
		StringBuilder result = new StringBuilder();
		// Fizzbuzz calculations start at 1 and not zero
		for (int i = 1; i <= lastNumberInSequence; i++) {
			if ((i % 15) == 0) {
				result.append(FIZZBUZZ).append("\n");
			} else if ((i % 3) == 0) {
				result.append(FIZZ).append("\n");
			} else if ((i % 5) == 0) {
				result.append(BUZZ).append("\n");
			} else {
				result.append(i).append("\n");
			}
		}
		return result.toString();
	}
}
