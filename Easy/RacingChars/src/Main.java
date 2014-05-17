import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static int carPos = 0;
    private static int preCarPos = 0;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(racingChars(fileLine));
        }
    }

    private static String racingChars(String fileLine) throws ParseException {
        preCarPos = carPos;
        carPos = getPreferredPos(fileLine);
        char carDirection;
        if (carPos == preCarPos || preCarPos == 0) {
            carDirection = '|';
        } else if (preCarPos < carPos) {
            carDirection = '\\';
        } else {
            carDirection = '/';
        }
        return fileLine.substring(0, carPos) + carDirection + fileLine.substring(carPos + 1, 12);
    }

    private static int getPreferredPos(String raceLine) {
        int result = raceLine.indexOf("C");
        return result != -1 ? result : raceLine.indexOf("_");
    }
}
