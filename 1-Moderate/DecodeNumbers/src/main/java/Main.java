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
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                decodeNumbers(fileLine);
            }
        }
    }

    private static void decodeNumbers(String fileLine) {
        digits = fileLine.toCharArray();
        int variations = getVariations(0);
        System.out.println(variations);
    }

    private static int getVariations(int index) {
        int result = 0;
        if (index == digits.length - 1) {
            return 1;
        } else if (canBeTwoNumbers(index)) {
            result += getVariations(index + 1);
            //
            if (index < digits.length - 2) {
                result += getVariations(index + 2);
            } else {
                result++;
            }
        } else {
            result += getVariations(index + 1);
        }
        return result;
    }

    private static boolean canBeTwoNumbers(int index) {
        return (digits[index] == '1') || (digits[index] == '2' && digits[index + 1] >= '0' && digits[index + 1] <= '6');
    }
}