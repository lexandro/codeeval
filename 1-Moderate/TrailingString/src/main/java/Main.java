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
                trailingString(fileLine);
            }
        }
    }

    public static void trailingString(String fileLine) {
        if (!fileLine.isEmpty()) {
            String[] elements = fileLine.split(",");
            int patternLength = elements[1].length();
            int textLength = elements[0].length();
            if (textLength >= patternLength && elements[0].substring(textLength - patternLength, textLength).equals(elements[1])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
