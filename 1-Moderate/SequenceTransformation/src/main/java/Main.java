import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static String digits;
    private static String letters;

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        sequenceTransformation("1010 AAAAABBBBAAAA");
        sequenceTransformation("01001110 AAAABAAABBBBBBAAAAAAA");
        sequenceTransformation("1100110 BBAABABBA");
        sequenceTransformation("00 AAAAAA");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                sequenceTransformation(fileLine);
            }
        }
    }

    public static void sequenceTransformation(String fileLine) {
        int pos = fileLine.indexOf(' ');
        digits = fileLine.substring(0, pos);
        letters = fileLine.substring(pos + 1, fileLine.length());
        //
        System.out.println(fileLine + " " + (checkSequence(0, 0) ? "Yes" : "No"));
    }

    private static boolean checkSequence(int digitIndex, int letterIndex) {
        //
        if (digitIndex < digits.length() && letterIndex < letters.length()) {
            char expectedSequenceChar = letters.charAt(letterIndex);
            while (letterIndex < letters.length()) {
                if (isApply(digitIndex, letterIndex, expectedSequenceChar)) {
                    if (checkSequence(digitIndex + 1, letterIndex + 1)) {
                        return true;
                    }
                } else {
                    return false;
                }
                letterIndex++;
            }
        }
        return digitIndex == digits.length();
    }


    private static boolean isApply(int digitIndex, int sequenceIndex, char sequenceChar) {
        char digit = digits.charAt(digitIndex);
        char letter = letters.charAt(sequenceIndex);
        return (letter == sequenceChar) && ((digit == '0' && letter == 'A') || (digit == '1' && (letter == 'A' || letter == 'B')));
    }
}