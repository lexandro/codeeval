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
                withoutRepetitions(fileLine);
            }
        }
    }

    private static void withoutRepetitions(String fileLine) {
        char lastChar = fileLine.charAt(0);
        lastChar++;
        StringBuilder result = new StringBuilder();
        for (char theChar : fileLine.toCharArray()) {
            if (theChar != lastChar) {
                lastChar = theChar;
                result.append(theChar);
            }
        }
        System.out.println(result.toString());
    }
}