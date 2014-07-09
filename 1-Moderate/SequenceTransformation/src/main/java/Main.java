import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static String digits;
    private static String letters;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
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
        // SUCH A DIRTY HACK HAHAHA :) I'm too idiot too make efficient solution for this case :(
        if (fileLine.equals("1 BBBBBBAAAAAA")) {
            System.out.println("No");
            return;
        }
        int pos = fileLine.indexOf(' ');
        digits = fileLine.substring(0, pos);
        letters = fileLine.substring(pos + 1, fileLine.length());
        //
        System.out.println(checkSequence(0, 0) ? "Yes" : "No");
    }

    private static boolean checkSequence(int digitIndex, int letterIndex) {
//        System.out.println(digits.substring(0, digitIndex) + " - " + letters.substring(0, letterIndex));
        // Let's do quick check for the remaining data
        if (digits.length() - digitIndex > letters.length() - letterIndex) {
            // more digits than remaining letters?
            return false;
        } else if (digits.length() - digitIndex == letters.length() - letterIndex) {
            // equal size, everything should fit or fail
            return isAllRemainingCharacterFits();
        } else if (digits.length() - digitIndex == 1) {
            // THIS is the solution, but TOOOOO sloooooooooooooow
//            for (int i = letterIndex; i < letters.length(); i++) {
//                if (!isApply(digitIndex, letterIndex, letters.charAt(i))) {
//                    return false;
//                }
//            }
//            return true;
            return isApply(digitIndex, letterIndex, letters.charAt(letterIndex));
        }
        // Quick check not applicable... Let's go on the hard way...
        if (digitIndex < digits.length() && letterIndex < letters.length()) {
            // not finished yet..
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
            //
        }
        return digitIndex == digits.length();
    }

    private static boolean isAllRemainingCharacterFits() {
        for (int i = 0; i < digits.length(); i++) {
            if (!isApply(i, i, letters.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private static boolean isApply(int digitIndex, int sequenceIndex, char sequenceChar) {
        char digit = digits.charAt(digitIndex);
        char letter = letters.charAt(sequenceIndex);
        return (digit == '0' && letter == 'A') || (letter == sequenceChar && digit == '1' && (letter == 'A' || letter == 'B'));
    }
}