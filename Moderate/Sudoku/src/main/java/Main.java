import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static char[] digits;

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        sudoku("4;1,4,2,3,2,3,1,4,4,2,3,1,3,1,4,2");
        sudoku("4;2,1,3,2,3,2,1,4,1,4,2,3,2,3,4,1");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                sudoku(fileLine);
            }
        }
    }

    private static void sudoku(String fileLine) {
        String[] items = fileLine.split(";");
        String[] digits = items[1].split(",");
        int size = Integer.parseInt(items[0], 10);
        int[] numbers = stringsToIntArray(digits);
        //
        if (isValidSudoku(size, numbers)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    private static boolean isValidSudoku(int size, int[] numbers) {
        if (size * size == numbers.length) {
            // "You may assume that N will be either 4 or 9."
            int expectedSum = size == 4 ? 10 : 45;
            // gridcheck
            int actualSum = 0;
            for (int i = 0; i < size; i++) {
                actualSum = 0;
                for (int j = 0; j < size; j++) {
                    int number = numbers[i * size + j];
                    if (number > 0 && number <= size) {
                        actualSum += number;
                    } else {
                        return false;
                    }
                }
                if (actualSum != expectedSum) {
                    return false;
                }
            }


            // verticalcheck

            // horizontalcheck


            return true;
        } else {
            return false;
        }
    }

    private static int[] stringsToIntArray(String[] numbers) {
        int[] result = new int[numbers.length];
        int count = 0;
        for (String number : numbers) {
            result[count++] = Integer.parseInt(number, 10);
        }
        return result;
    }
}