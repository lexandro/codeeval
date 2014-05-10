import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
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
            System.out.println(theMajorElement(fileLine));
        }
    }

    // optimized for speed, not for readibility. I was in the speedy mood :)
    private static String theMajorElement(String csvLine) {
        int[] occurrences = new int[101];
        //
        String result = "None";
        // we need to know how much items we have
        int half = 1;
        for (int i = 0; i < csvLine.length(); i++) {
            if (csvLine.charAt(i) == ',') {
                half++;
            }
        }
        half /= 2;
        int numberCounter;
        //
        int commaPosition = 0;
        int lastFound = 0;
        //
        int itemCounter = 0;
        int number;
        while (commaPosition != -1) {
            commaPosition = csvLine.indexOf(',', ++commaPosition);
            number = Integer.valueOf(csvLine.substring(lastFound, commaPosition != -1 ? commaPosition : csvLine.length()));
            lastFound = commaPosition + 1;
            //
            if (itemCounter < half) {
                occurrences[number]++;
            } else {
                numberCounter = ++occurrences[number];
                if (numberCounter > half) {
                    result = String.valueOf(number);
                    break;
                }
            }
            //
            itemCounter++;
        }
        //
        return result;
    }
}
