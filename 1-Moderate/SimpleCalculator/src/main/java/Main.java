import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        simpleCalculator("250*14.3");
        simpleCalculator("3^6 / 117");
        simpleCalculator("(2.16 - 48.34)^-1");
        simpleCalculator("(59 - 15 + 3*6)/21");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                simpleCalculator(fileLine);
            }
        }
    }

    private static void simpleCalculator(String fileLine) {

    }
}