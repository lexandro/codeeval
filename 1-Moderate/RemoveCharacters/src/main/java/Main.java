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
                removeCharacters(fileLine);
            }
        }
    }

    // Using building up the new string via an array instead of heavyweight
    // string/stringbuilder manipulation
    public static void removeCharacters(String fileLine) {
        int separatorPos = fileLine.indexOf(",");
        //
        CharSequence removalPattern = fileLine.subSequence(separatorPos + 2, fileLine.length());
        char[] result = new char[separatorPos];
        int nextPos = 0;
        for (int i = 0; i < separatorPos; i++) {
            boolean found = false;
            char currentChar = fileLine.charAt(i);
            for (int j = 0; j < removalPattern.length(); j++) {
                if (removalPattern.charAt(j) == currentChar) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[nextPos++] = currentChar;
            }
        }
        System.out.println(String.valueOf(result).trim());
    }
}
