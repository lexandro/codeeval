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
                reverseAndAdd(fileLine);
            }
        }
    }

    public static void reverseAndAdd(String fileLine) {
        long number = Integer.valueOf(fileLine);
        long iterations = 0;
        while (!isPalindrome(number)) {
            long reverse = Long.valueOf((new StringBuilder(String.valueOf(number))).reverse().toString());
            iterations++;
            number += reverse;
        }
        System.out.printf("%d %d\n", iterations, number);
    }

    private static boolean isPalindrome(long theNumber) {
        String numberString = String.valueOf(theNumber);
        int i = 0;
        int j = numberString.length() - 1;
        while (i <= j) {
            if (numberString.charAt(i++) != numberString.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
