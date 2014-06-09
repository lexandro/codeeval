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
                numberPairs(fileLine);
            }
        }
    }

    private static void numberPairs(String fileLine) {
        String[] elements = fileLine.split(";");
        String[] items = elements[0].split(",");
        int[] numbers = stringToIntArray(items);
        //
        int expectedSum = Integer.valueOf(elements[1]);
        StringBuilder result = new StringBuilder();
        //
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] + numbers[i] == expectedSum) {
                    // reuse strings to avoid conversion ;)
                    result.append(items[i]).append(',').append(items[j]).append(';');
                }
            }
        }
        System.out.println(result.length() > 0 ? result.deleteCharAt(result.length() - 1).toString() : "NULL");
    }

    private static int[] stringToIntArray(String[] items) {
        int[] result = new int[items.length];
        for (int count = 0; count < items.length; count++) {
            result[count] = Integer.valueOf(items[count]);
        }
        return result;
    }
}