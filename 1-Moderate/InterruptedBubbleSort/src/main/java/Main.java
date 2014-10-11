import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                interruptedBubbleSort(fileLine);
            }
        }
    }

    private static void interruptedBubbleSort(String fileLine) {
        String[] elements = fileLine.split("\\|");
        long maxSteps = Long.valueOf(elements[1].trim());
        long[] numbers = convertStringToIntArray(elements[0]);
        //
        intterruptedShortArray(maxSteps, numbers);
        //
        printArray(numbers);
    }

    private static void printArray(long[] numbers) {
        System.out.print(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println();
    }

    private static void intterruptedShortArray(long maxSteps, long[] numbers) {
        boolean swapped = true;
        int steps = 0;
        while (swapped) {
            swapped = false;
            for (int j = 0; j + 1 < numbers.length; j++) {
                if (numbers[j + 1] < numbers[j]) {
                    numbers[j] = numbers[j] + numbers[j + 1];
                    numbers[j + 1] = numbers[j] - numbers[j + 1];
                    numbers[j] = numbers[j] - numbers[j + 1];
                    swapped = true;
                }
            }
            if (++steps == maxSteps) {
                break;
            }
        }
    }

    private static long[] convertStringToIntArray(String numberList) {
        String[] numberStrings = numberList.split(" ");
        long[] result = new long[numberStrings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.valueOf(numberStrings[i]);
        }
        return result;
    }
}