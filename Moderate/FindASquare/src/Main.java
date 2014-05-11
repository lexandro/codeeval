import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.pow;

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
            System.out.println(findASquare(fileLine));
        }
    }

    private static boolean findASquare(String fileLine) {
        //
        int[][] coords = convertToCoordinates(fileLine);
        //
        return isSquare(coords);
    }

    private static boolean isSquare(int[][] coords) {
        return isNoOverlap(coords) && hasEqualDiagonals(coords) && hasEqualSides(coords);
    }

    private static boolean hasEqualSides(int[][] coords) {
        return pythagoras(coords[0], coords[1]) == pythagoras(coords[0], coords[2]);
    }

    private static boolean hasEqualDiagonals(int[][] coords) {
        return pythagoras(coords[0], coords[3]) == pythagoras(coords[1], coords[2]);
    }

    private static double pythagoras(int[] point1, int[] point2) {
        double aSide = pow(point1[0] - point2[0], 2);
        double bSide = pow(point1[1] - point2[1], 2);
        return Math.sqrt(aSide + bSide);
    }

    private static boolean isNoOverlap(int[][] coords) {
        boolean result = false;
        for (int i = 0; i < 3 && !result; i++) {
            result = Arrays.equals(coords[i], coords[i + 1]);
        }
        return !result;
    }

    private static int[][] convertToCoordinates(String fileLine) {
        String[] positions = extractPositionsFrom(fileLine);
        //
        Arrays.sort(positions);
        //
        return convertStringCoordsToArrays(positions);

    }

    private static String[] extractPositionsFrom(String fileLine) {
        String[] result = new String[4];
        for (int i = 0; i < 4; i++) {
            result[i] = extractPosFrom(fileLine, (i * 7) + 1);
        }
        return result;
    }

    private static String extractPosFrom(String fileLine, int start) {
        return String.valueOf(fileLine.charAt(start)) + fileLine.charAt(start + 2);
    }

    private static int[][] convertStringCoordsToArrays(String[] positions) {
        int[][] result = new int[4][2];
        for (int i = 0; i < 4; i++) {
            result[i][0] = Integer.valueOf(positions[i].substring(0, 1));
            result[i][1] = Integer.valueOf(positions[i].substring(1, 2));
        }
        return result;
    }

}
