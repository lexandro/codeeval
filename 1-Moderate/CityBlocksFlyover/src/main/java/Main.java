import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("\\d+");

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        cityBlocksFlyover("(0,2,4,8,10,13,14,18,22,23,24,33,40,42,44,47,49,53,55,63,66,81,87,91)");
        cityBlocksFlyover("(0,147,220)");
        cityBlocksFlyover("(0,1,2,4) (0,1,3,4,5)");
        cityBlocksFlyover("(0,1,3,4,6) (0,1,2,4)");
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
        int[] streets = convertStringToIntArray(items[0]);
        int[] avenues = items.length > 1 ? convertStringToIntArray(items[1]) : new int[]{1};
        //
        float helicopterRatio = Float.valueOf(avenues[avenues.length - 1]) / streets[streets.length - 1];
        //
        for (int streetIndex = 0; streetIndex < streets.length - 1; streetIndex++) {
            for (int avenueIndex = 0; avenueIndex < avenues.length - 1; avenueIndex++) {

            }
        }
    }

    private static int[] convertStringToIntArray(String numberList) {
        numberList = numberList.replaceAll("[(|)]", "");
        String[] numberStrings = numberList.split(",");
        int[] result = new int[numberStrings.length];
        //
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numberStrings[i], 10);
        }
        return result;
    }
}