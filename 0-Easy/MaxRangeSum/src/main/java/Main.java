import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available on https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            maxRangeSum(fileLine);
        }
    }

    private static void maxRangeSum(String inputLine) {
        String[] elements = inputLine.split(";");
        int range = Integer.valueOf(elements[0]);
        String[] gainLossElements = elements[1].split(" ");
        int[] gainLoss = new int[gainLossElements.length];
        //
        convertToIntArray(gainLossElements, gainLoss);
        //
        int maxSum = 0;
        for (int i = 0; i < gainLossElements.length - range + 1; i++) {
            int sum = 0;
            for (int j = 0; j < range; j++) {
                sum += gainLoss[i + j];
            }
            //
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

    private static void convertToIntArray(String[] gainLossElements, int[] gainLoss) {
        for (int i = 0; i < gainLossElements.length; i++) {
            gainLoss[i] = Integer.valueOf(gainLossElements[i]);
        }
    }
}
