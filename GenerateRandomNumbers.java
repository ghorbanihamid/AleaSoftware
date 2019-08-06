package aleaSoftware;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class GenerateRandomNumbers {

    private final static int numbersSize = 1_000_000;

    //Get the file reference
    private final static Path approachTwoPath = Paths.get("d:/approachTwoNumbers.txt");
    private final static Path approachTwoSortedPath = Paths.get("d:/approachTwoSortedNumbers.txt");

    private final static Path approachThreePath = Paths.get("d:/approachThreeNumbers.txt");
    private final static Path approachThreeSortedPath = Paths.get("d:/approachThreeSortedNumbers.txt");

    public static void main(String[] args) {

        try {
            // Approach Two
            streamToArrayApproach();

            // Approach Three
            generateRandomWithoutStream();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Approach Two
    private static void streamToArrayApproach() {

        try {
            // get the current time in millisecond
            long startTime = System.currentTimeMillis();

            // generate random numbers as stream
            IntStream numberStream = NumberUtil.generateStreamOfRandomNumbers(numbersSize);

            // convert stream to array
            int[] intArray = numberStream.toArray();

            // calculate time of execution
            long randTime = System.currentTimeMillis() - startTime;
            System.out.println("generate numbers stream  and convert it to array time : " + randTime);

            // convert array to stream and write it to file
            FileUtil.writeToFile(approachTwoPath, Arrays.stream(intArray));

            // sort array
            Arrays.parallelSort(intArray);

            // convert array to stream
            IntStream numberStreamSorted = Arrays.stream(intArray);

            // write the sorted stream to file
            FileUtil.writeToFile(approachTwoSortedPath,numberStreamSorted.sorted());

            long time = System.currentTimeMillis() - startTime;
            System.out.println("stream To Collection Approach is successfully done with of : " + time);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Approach Three
    private static void generateRandomWithoutStream() {

        try {
            // get the current time in millisecond
            long startTime = System.currentTimeMillis();

            // generate random numbers as array
            int[] intArray = NumberUtil.generateArraysOfRandomNumbers(numbersSize);

            // write the stream to file
            FileUtil.writeToFile(approachThreePath, Arrays.stream(intArray));

            // sort array
            Arrays.parallelSort(intArray);

            // convert array to stream
            IntStream numberStreamSorted = Arrays.stream(intArray);

            // write the sorted stream to file
            FileUtil.writeToFile(approachThreeSortedPath,numberStreamSorted);

            long time = System.currentTimeMillis() - startTime;
            System.out.println("generate random without using stream is successfully done with of : " + time);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
