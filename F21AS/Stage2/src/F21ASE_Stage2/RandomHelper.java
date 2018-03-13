package F21ASE_Stage2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomHelper {

    /**
     * return a integer in the range, but doesn't return any number in the excludes list
     * List<Integer> excludes has to be sorted ASC
     * @param start start of range (inclusive)
     * @param end end of range (exclusive)
     * @param excludes numbers to exclude (= numbers you do not want)
     * @return the random number within start-end but not one of excludes
     */
    public static int getRandomIntExclude(int start, int end, List<Integer> excludes){
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

    public static int[] getRandomDimensions() {
        Random random = new Random();
        int length = random.nextInt(200);
        int width = random.nextInt(200);
        int height = random.nextInt(200);

        return new int[]{length, width, height};
    }

    public static double getRandomWeight() {
        Random random = new Random();
        return random.nextDouble() * 200;
    }

    public static void main(String args[]) {

        /////// TEST getRandomIntExclude()
        List<Integer> exclusive = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++){
            int number = getRandomIntExclude(0, 10, exclusive);
            exclusive.add(number);
            Collections.sort(exclusive);
            System.out.println(number);
        }

    }
}
