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
//        aPileOfBricks("[4,3] [3,-3]|(1 [10,9,4] [9,4,2])");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                aPileOfBricks(fileLine);

            }
        }
    }

    private static void aPileOfBricks(String fileLine) {
        System.out.println(fileLine);
        String[] items = fileLine.split("|");
        Hole hole = Hole.from(items[0]);
        String[] brickData = items[1].split(";");
        //

    }

    private static class Hole {
        public static Hole from(String item) {
            return null;
        }
    }

}