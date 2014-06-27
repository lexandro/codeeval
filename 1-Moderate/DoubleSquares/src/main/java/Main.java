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
        int count = Integer.parseInt(reader.readLine());
        while ((fileLine = reader.readLine()) != null && count-- > 0) {
            if (!fileLine.isEmpty()) {
                doubleSquares(fileLine);
            }
        }
    }

    private static void doubleSquares(String fileLine) {
        long number = Long.valueOf(fileLine);
        long first = Double.valueOf(Math.sqrt(number)).longValue() + 1;
        int count = 0;
        while (first >= 0) {
            if (first * first == number) {
                count++;
            } else {
                Double second = Math.sqrt(number - (first * first));
                if ((second == Math.floor(second)) && !Double.isInfinite(second) && first > second) {
                    count++;
                }
            }
            first--;
        }
        System.out.println(count);
    }
}