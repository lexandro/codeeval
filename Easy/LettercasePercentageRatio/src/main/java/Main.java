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
                lettercasePercentageRatio(fileLine);
            }
        }
    }

    public static void lettercasePercentageRatio(String fileLine) {
        byte[] lineAsBytes = fileLine.getBytes();
        int counter = 0;
        for (byte theLetter : lineAsBytes) {
            if (theLetter > 64 && theLetter < 91) {
                counter++;
            }
        }
        double floatCounter = counter;
        System.out.format(" lowercase: %.2f uppercase: %.2f\n", (fileLine.length() - floatCounter) * 100 / fileLine.length(), floatCounter * 100 / fileLine.length());
    }
}
