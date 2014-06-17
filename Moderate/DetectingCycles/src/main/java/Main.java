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
                detectingCycles(fileLine);
            }
        }
    }

    private static void detectingCycles(String fileLine) {
        String[] items = fileLine.split(" ");
        int[] numbers = stringsToIntArray(items);
        //
        for (int cycleStartIndex = 0; cycleStartIndex < numbers.length - 1; cycleStartIndex++) {
            for (int length = 1; length < (numbers.length - cycleStartIndex) / 2; length++) {
                if (isCycle(cycleStartIndex, length, numbers)) {
                    printCycle(cycleStartIndex, length, numbers);
                    return;
                }
            }
        }
    }

    private static boolean isCycle(int pos, int length, int[] numbers) {
        for (int i = pos; i < pos + length; i++) {
            if (numbers[i] != numbers[i + length]) {
                return false;
            }
        }
        return true;
    }

    private static void printCycle(int cycleStartIndex, int length, int[] numbers) {
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[cycleStartIndex + i] + " ");
        }
        System.out.println();
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