import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final int GRID_SIZE = 100;
    private static final int FULL_SIZE = GRID_SIZE + 2;
    private static final int NUMBER_OF_ITERATIONS = 10;
    private static char[][] GRID = new char[FULL_SIZE][FULL_SIZE];
    private static char[][] WORK_GRID = new char[FULL_SIZE][FULL_SIZE];

    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        int line = 1;
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                prepareGameOfLife(line++, fileLine);
            }
        }
        playGameOfLife();
        showResults();
    }

    private static void playGameOfLife() {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            WORK_GRID = new char[FULL_SIZE][FULL_SIZE];
            //
            calculateIteration();
            //
            GRID = WORK_GRID;
        }
    }

    private static void calculateIteration() {
        for (int y = 1; y <= GRID_SIZE; y++) {
            for (int x = 1; x <= GRID_SIZE; x++) {
                int neighbours = countNeighbours(x, y);
                char cellState = GRID[y][x];
                //
                if (cellState == '*') {
                    if (neighbours < 2 || neighbours > 3) {
                        killCell(x, y);
                    } else {
                        createCell(x, y);
                    }
                } else {
                    if (neighbours == 3) {
                        createCell(x, y);
                    } else {
                        killCell(x, y);
                    }
                }
            }
        }
    }

    private static int countNeighbours(int x, int y) {
        int result = 0;
        for (int posY = -1; posY < 2; posY++) {
            for (int posX = -1; posX < 2; posX++) {
                int currentPosY = posY + y;
                int currentPosX = posX + x;
                if (!(posX == 0 && posY == 0) && GRID[currentPosY][currentPosX] == '*') {
                    result++;
                }
            }
        }

        return result;
    }

    private static void createCell(int x, int y) {
        WORK_GRID[y][x] = '*';
    }

    private static void killCell(int x, int y) {
        WORK_GRID[y][x] = '.';
    }

    private static void prepareGameOfLife(int line, String fileLine) {

        for (int i = 1; i <= fileLine.length(); i++) {
            GRID[line][i] = fileLine.charAt(i - 1);
        }


    }

    private static void showResults() {
        for (int i = 1; i <= GRID_SIZE; i++) {
            System.out.println(String.valueOf(GRID[i]).substring(1, GRID_SIZE+1));
        }
    }
}