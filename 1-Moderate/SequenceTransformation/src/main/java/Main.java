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
//        sequenceTransformation("1010 AAAAABBBBAAAA");
//        sequenceTransformation("01001110 AAAABAAABBBBBBAAAAAAA");
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
        System.out.println(checkSequence(0, 0));
        System.out.println(fileLine);
    }

    private static boolean checkSequence(int digitIndex, int sequenceIndex) {
        char sequenceChar = sequenceIndex < letters.length() ? letters.charAt(sequenceIndex) : ' ';
        //
        if (digitIndex < digits.length()) {
            while (sequenceIndex < letters.length()) {
                if (isApply(digitIndex, sequenceIndex, sequenceChar)) {
                    if (checkSequence(digitIndex + 1, sequenceIndex + 1)) {
                        return true;
                    }
                } else {
                    return false;
                }
                sequenceIndex++;
            }
        }
        return digitIndex == digits.length();
    }


    private static boolean isApply(int digitIndex, int sequenceIndex, char sequenceChar) {
        char digit = digits.charAt(digitIndex);
        char letter = letters.charAt(sequenceIndex);
        return (letter == sequenceChar) && (digit == '0' && letter == 'A') || (digit == '1' && (letter == 'A' || letter == 'B'));
    }
}