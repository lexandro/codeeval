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
                pascalsTriangle(fileLine);
            }
        }
    }

    private static void pascalsTriangle(String fileLine) {
        int size = Integer.valueOf(fileLine);
        int[][] triangle = new int[size][size];
        //
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j - 1];
                }
            }
        }
        //
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(triangle[i - j][j] + " ");
            }
        }
        System.out.println();
    }
}