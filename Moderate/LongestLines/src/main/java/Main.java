import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static int lastLinesIndex = 0;

    private static String[] lastLines;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                longestLines(fileLine);
            }
        }
        listLongestLines();
    }

    private static void listLongestLines() {
        for (String line : lastLines) {
            System.out.println(line);
        }
    }

    private static void longestLines(String fileLine) throws ParseException {
        ensureRequiredAmountOfLinesRequired(fileLine);
        //
        for (int i = 0; i < lastLinesIndex; i++) {
            if (lastLines[i] == null) {
                lastLines[i] = fileLine;
                break;
            } else if (fileLine.length() > lastLines[i].length()) {
                String helper = lastLines[i];
                lastLines[i] = fileLine;
                fileLine = helper;
            }
        }
    }

    private static void ensureRequiredAmountOfLinesRequired(String fileLine) {
        if (lastLinesIndex == 0) {
            lastLinesIndex = Integer.valueOf(fileLine);
            lastLines = new String[lastLinesIndex];
        }
    }
}
