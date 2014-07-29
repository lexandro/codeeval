import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static final int MIN_DISTANCE_FROM_BUILDINGS = 6;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                batsChallenge(fileLine);
            }
        }
    }

    private static void batsChallenge(String fileLine) {
        String[] elements = fileLine.split(" ");
        int length = Integer.parseInt(elements[0], 10);
        int distance = Integer.parseInt(elements[1], 10);
        int existingBatAmount = Integer.parseInt(elements[2], 10);
        //
        int existingBatCounter = 0;
        int position = MIN_DISTANCE_FROM_BUILDINGS;
        int nextBatPos = existingBatAmount > 0 ? Integer.parseInt(elements[3 + existingBatCounter], 10) : Integer.MIN_VALUE;
        int newBatCounter = 0;
        while (position <= length - MIN_DISTANCE_FROM_BUILDINGS) {
            if (nextBatPos == Integer.MIN_VALUE) {
                // no more existing bats
                newBatCounter++;
            } else {
                // is there a bat within the distance?
                if (position + distance <= nextBatPos) {
                    newBatCounter++;
                } else {
                    position = nextBatPos;
                    existingBatCounter++;
                    nextBatPos = existingBatCounter < existingBatAmount ? Integer.parseInt(elements[3 + existingBatCounter], 10) : Integer.MIN_VALUE;
                }
            }
            position += distance;
        }
        System.out.println(newBatCounter);

    }
}

