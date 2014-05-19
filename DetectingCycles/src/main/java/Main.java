import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        detectingCycles("2 0 6 3 1 6 3 1 6 3 1");
        detectingCycles("3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49");
        detectingCycles("1 2 3 1 2 3 1 2 3");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                detectingCycles(fileLine);
            }
        }
    }

    private static void detectingCycles(String fileLine) {
        String[] items = fileLine.split(" ");

    }
}
