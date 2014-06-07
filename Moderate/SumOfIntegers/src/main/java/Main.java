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
                sumOfIntegers(fileLine);
            }
        }
    }

    private static void sumOfIntegers(String fileLine) {
        String[] numbers = fileLine.split(",");
        int[] integers = createIntegerArrayFrom(numbers);
        int maxSum = integers[0];
        int position = 0;
        //
        while (position < integers.length) {
            int sectionSum = 0;
            //
            for (int count = position; count < integers.length; count++) {
                sectionSum += integers[count];
                if (sectionSum > maxSum) {
                    maxSum = sectionSum;
                }
            }
            position++;
        }
        System.out.println(maxSum);
    }

    private static int[] createIntegerArrayFrom(String[] numbers) {
        int[] result = new int[numbers.length];
        int count = 0;
        for (String number : numbers) {
            result[count++] = Integer.valueOf(number.trim());
        }
        return result;
    }
}