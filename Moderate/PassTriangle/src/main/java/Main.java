import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;


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
        LinkedList<String> fileLines = new LinkedList<>();
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                fileLines.add(fileLine);
            }
        }
        passTriangle(fileLines);
    }

    private static void passTriangle(LinkedList<String> fileLines) {
        Iterator<String> iterator = fileLines.descendingIterator();
        String fileLine = iterator.next();
        int[] sums = stringToIntArray(fileLine);
        //
        while (iterator.hasNext()) {
            fileLine = iterator.next();
            int[] numbers = stringToIntArray(fileLine);
            sums = sumUpWith(sums, numbers);
        }
        System.out.println(findMax(sums));
    }

    private static int[] stringToIntArray(String fileLine) {
        String[] items = fileLine.split(" ");
        int[] result = new int[items.length];
        for (int count = 0; count < items.length; count++) {
            result[count] = Integer.valueOf(items[count]);
        }
        return result;
    }

    private static int[] sumUpWith(int[] sums, int[] numbers) {
        for (int count = 0; count < numbers.length; count++) {
            if (numbers[count] + sums[count] > numbers[count] + sums[count + 1]) {
                numbers[count] += sums[count];
            } else {
                numbers[count] += sums[count + 1];
            }
        }
        return numbers;
    }

    private static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int count = 1; count < numbers.length; count++) {
            if (numbers[count] > max) {
                max = numbers[count];
            }
        }
        return max;
    }
}