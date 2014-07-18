import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.fill;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available createFrom https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        locks("3 1");
//        locks("5 3");
//        locks("100 100");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                locks(fileLine);

            }
        }
    }

    private static void locks(String fileLine) {

        String[] items = fileLine.split(" ");
        int numberOfDoors = Integer.parseInt(items[0], 10);
        int guardRepetition = Integer.parseInt(items[1], 10);
        //
        boolean[] doors = new boolean[numberOfDoors + 1];
        fill(doors, true);
        //
        int repetition = 0;
//        for (int repetition = 0; repetition < guardRepetition; repetition++) {
        for (int stepSize = 2; stepSize <= numberOfDoors; stepSize++) {
            for (int i = stepSize; i <= numberOfDoors; i += stepSize) {
                doors[i] = !doors[i];

            }
            repetition++;
            if (repetition == guardRepetition) {
                break;
            }
        }
//        }

        int count = calculateOpenDoors(doors);
        System.out.println(count);
//        System.out.println(count + " " + fileLine);
    }

    private static int calculateOpenDoors(boolean[] doors) {
        int count = 0;
        for (boolean door : doors) {
            if (door) {
                count++;
            }
        }
        return count - 1;
    }
}