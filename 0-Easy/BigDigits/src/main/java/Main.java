import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final int DIGIT_HEIGTH = 6;
    private static final int DIGIT_WIDTH = 5;
    private static final int DIGIT_LINE_SIZE = 50;
    private static String DIGITS =
            "-**----*--***--***---*---****--**--****--**---**--" +
                    "*--*--**-----*----*-*--*-*----*-------*-*--*-*--*-" +
                    "*--*---*---**---**--****-***--***----*---**---***-" +
                    "*--*---*--*-------*----*----*-*--*--*---*--*----*-" +
                    "-**---***-****-***-----*-***---**---*----**---**--" +
                    "--------------------------------------------------";

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                bigDigits(fileLine);
            }
        }
    }

    private static void bigDigits(String fileLine) {
        String digits = fileLine.replaceAll("[^\\d]", "");
        //
        for (int line = 0; line < DIGIT_HEIGTH; line++) {
            for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
                int digitValue = Integer.valueOf(digits.substring(digitIndex, digitIndex + 1));
                //
                int beginIndex = digitValue * DIGIT_WIDTH + line * DIGIT_LINE_SIZE;
                System.out.print(DIGITS.substring(beginIndex, beginIndex + DIGIT_WIDTH));
            }
            System.out.println();
        }
    }
}