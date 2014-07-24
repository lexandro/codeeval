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
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                locks(fileLine);
            }
        }
    }

    protected static void locks(String fileLine) {
        String[] items = fileLine.split(" ");
        int numberOfDoors = Integer.parseInt(items[0], 10);
        int requiredRepetitions = Integer.parseInt(items[1], 10);
        //
        boolean[] doors = new boolean[numberOfDoors];
        //
        if (requiredRepetitions > 1) {
            boolean isEven = (requiredRepetitions & 1) == 0;
            for (int i = 1; i <= doors.length; i++) {
                if (i % 3 != 0 && i % 2 == 0) {
                    doors[i - 1] = true;
                } else if (i % 3 == 0 && i % 2 != 0) {
                    doors[i - 1] = isEven;
                }
            }
            doors[numberOfDoors - 1] = !doors[numberOfDoors - 1];
            int count = calculateOpenDoors(doors);
            System.out.println(count);
        } else {
            System.out.println(numberOfDoors - 1);
        }
    }

    private static int calculateOpenDoors(boolean[] doors) {
        int count = 0;
        for (boolean door : doors) {
            if (!door) {
                count++;
            }
        }
        return count;
    }
}