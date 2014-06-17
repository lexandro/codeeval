import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

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
                jollyJumpers(fileLine);
            }
        }
    }

    private static void jollyJumpers(String fileLine) {
        int[] numbers = convertStringToIntArray(fileLine);
        int[] jolly = new int[numbers.length - 1];
        //
        for (int i = 0; i < jolly.length; i++) {
            jolly[i] = Math.abs(numbers[i] - numbers[i + 1]);
        }
        Arrays.sort(jolly);
        //
        for (int i = 0; i < jolly.length; i++) {
            if (jolly[i] != i + 1) {
                System.out.println("Not jolly");
                return;
            }
        }
        System.out.println("Jolly");
    }

    private static int[] convertStringToIntArray(String numberList) {
        String[] numberStrings = numberList.split(" ");
        int numbersAmount = Integer.parseInt(numberStrings[0], 10);
        int[] result = new int[numbersAmount];
        //
        for (int i = 0; i < numbersAmount; i++) {
            result[i] = Integer.parseInt(numberStrings[i + 1], 10);
        }
        return result;
    }
}