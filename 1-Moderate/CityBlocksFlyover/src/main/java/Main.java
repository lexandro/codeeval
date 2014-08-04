import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.Math.*;

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
                cityBlocksFlyover(fileLine);
            }
        }
    }

    private static void cityBlocksFlyover(String fileLine) {
        String[] items = fileLine.split(" ");
        double[] streets = convertStringToIntArray(items[0]);
        double[] avenues = convertStringToIntArray(items[1]);
        //
        double helicopterRatio = avenues[avenues.length - 1] / streets[streets.length - 1];
        //
        int count = 0;
        for (int x = 0; x < streets.length - 1; x++) {
            for (int y = 0; y < avenues.length - 1; y++) {
                if (isBetween(streets[x], streets[x + 1], avenues[y] / helicopterRatio, avenues[y + 1] / helicopterRatio)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isBetween(double x1, double x2, double y1, double y2) {
        return max(x1, y1) < min(x2, y2);
    }

    private static double[] convertStringToIntArray(String numberList) {
        numberList = numberList.replaceAll("[(|)]", "");
        String[] numberStrings = numberList.split(",");
        double[] result = new double[numberStrings.length];
        //
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.valueOf(numberStrings[i]);
        }
        return result;
    }
}