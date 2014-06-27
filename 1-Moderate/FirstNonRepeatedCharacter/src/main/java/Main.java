import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static char[] letters;
    private static int[] counters;
    private static int arrayIndex;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                firstNonRepeatedCharacters(fileLine);
            }
        }
    }

    private static void firstNonRepeatedCharacters(String fileLine) {
        letters = new char[26];
        counters = new int[26];
        arrayIndex = 0;
        //
        for (int i = 0; i < fileLine.length(); i++) {
            char letter = fileLine.charAt(i);
            if (!isLetterExists(letter)) {
                letters[arrayIndex] = letter;
                counters[arrayIndex++]++;
            }

        }
        //
        for (int i = 0; i < arrayIndex; i++) {
            if (counters[i] == 1) {
                System.out.println(letters[i]);
                break;
            }
        }
    }

    private static boolean isLetterExists(char letter) {
        for (int j = 0; j < arrayIndex; j++) {
            if (letters[j] == letter) {
                counters[j]++;
                return true;
            }
        }
        return false;
    }
}
