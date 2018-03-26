package F21ASE_Stage2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomHelper {

	/**
	 * return a integer in the range, but doesn't return any number in the excludes
	 * list List<Integer> excludes has to be sorted ASC
	 * 
	 * @param start
	 *            start of range (inclusive)
	 * @param end
	 *            end of range (exclusive)
	 * @param excludes
	 *            numbers to exclude (= numbers you do not want)
	 * @return the random number within start-end but not one of excludes
	 */
	public static int getRandomIntExclude(int start, int end, List<Integer> excludes) {
		Random random = new Random();
		int rangeLength = end - start - excludes.size();
		int randomInt = random.nextInt(rangeLength) + start;

		for (Integer exclude : excludes) {
			if (exclude > randomInt) {
				return randomInt;
			}

			randomInt++;
		}

		return randomInt;
	}

	/**
	 * Gets random dimension
	 * 
	 * @return an array containing a random length, width and height
	 */
	public static double[] getRandomDimensions() {
		Random random = new Random();
		double length = random.nextDouble() * 4 + 1;
		double width = random.nextDouble() * 4 + 1;
		double height = random.nextDouble() * 4 + 1;

		length = Math.round(length * 100d) / 100d;
		width = Math.round(width * 100d) / 100d;
		height = Math.round(height * 100d) / 100d;
		return new double[] { length, width, height };
	}

	/**
	 * Gets a random weight
	 * 
	 * @return a random value
	 */
	public static double getRandomWeight() {
		Random random = new Random();
		return random.nextDouble() * 50;
	}
}
