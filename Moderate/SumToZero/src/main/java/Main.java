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
                sumToZero(fileLine);
            }
        }
    }

    private static void sumToZero(String fileLine) {
        String[] digits = fileLine.split(",");
        int[] numbers = stringsToIntArray(digits);
        //
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    for (int l = k + 1; l < numbers.length; l++) {
                        if (numbers[i] + numbers[j] + numbers[k] + numbers[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int[] stringsToIntArray(String[] numbers) {
        int[] result = new int[numbers.length];
        int count = 0;
        for (String number : numbers) {
            result[count++] = Integer.valueOf(number.trim());
        }
        return result;
    }
}