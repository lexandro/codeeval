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
                reverseGroups(fileLine);
            }
        }
    }

    private static void reverseGroups(String fileLine) {
        String[] elements = fileLine.split(";");
        String[] digits = elements[0].split(",");
        int reverseGroupSize = Integer.valueOf(elements[1]);
        //
        for (int blockStartIndex = 0; blockStartIndex + reverseGroupSize <= digits.length; blockStartIndex += reverseGroupSize) {
            reverseBlock(digits, reverseGroupSize, blockStartIndex);
        }
        System.out.print(digits[0]);
        for (int i = 1; i < digits.length; i++) {
            System.out.print("," + digits[i]);
        }
        System.out.println();
    }

    private static void reverseBlock(String[] numbers, int reverseGroupSize, int blockStartIndex) {
        for (int reverseConter = 0; reverseConter < reverseGroupSize / 2; reverseConter++) {
            String backup = numbers[blockStartIndex + reverseConter];
            numbers[blockStartIndex + reverseConter] = numbers[blockStartIndex + reverseGroupSize - reverseConter - 1];
            numbers[blockStartIndex + reverseGroupSize - reverseConter - 1] = backup;

        }
    }
}