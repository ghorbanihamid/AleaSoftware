package aleaSoftware;

import java.util.SplittableRandom;
import java.util.stream.IntStream;

public class NumberUtil {

    // Generating a million random numbers and return as stream
    public static IntStream generateStreamOfRandomNumbers(int dataSize) {

        return new SplittableRandom().ints(dataSize, 0, 10);

    }

    // Generating a million random numbers
    public static int[] generateArraysOfRandomNumbers(int dataSize) {

        // get the current time in millisecond
        long startTime = System.currentTimeMillis();

        SplittableRandom splittableRandom = new SplittableRandom();
        int[] rands = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            rands[i] = splittableRandom.nextInt(0, 10);

        long randTime = System.currentTimeMillis() - startTime;
        System.out.println("Generate Random Directly to array time : " + randTime);
        return rands;

    }


}
