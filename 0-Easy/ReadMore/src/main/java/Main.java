import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

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
                readMore(fileLine);
            }
        }
    }

    private static void readMore(String fileLine) throws ParseException {
        int lineSize = fileLine.length();
        if (lineSize <= 55) {
            System.out.println(fileLine);
        } else {
            int spaceIndex = lineSize > 40 ? 40 : lineSize;
            int original = spaceIndex;
            for (; spaceIndex > 0; spaceIndex--) {
                if (fileLine.charAt(spaceIndex) == ' ') {
                    break;
                }
            }
            System.out.printf("%s... <Read More>\n", fileLine.substring(0, spaceIndex > 0 ? spaceIndex : original));
        }
    }
}