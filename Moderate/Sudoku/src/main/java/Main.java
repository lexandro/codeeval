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
                sudoku(fileLine);
            }
        }
    }

    private static void sudoku(String fileLine) {
        String[] items = fileLine.split(";");
        String[] digits = items[1].split(",");
        int size = Integer.parseInt(items[0], 10);
        if (!isValidSudoku(size, digits)) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    private static boolean isValidSudoku(int size, String[] digits) {
        int[][] sudokuBoard = stringsToSudokuBoard(digits);
        int cubeSize = Double.valueOf(Math.sqrt(size)).intValue();
        int expectedSum = sudokuBoard[0].length == 4 ? 10 : 45;
        //
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            int columnSum = 0;
            int gridSum = 0;
            //
            for (int j = 0; j < size; j++) {
                rowSum += sudokuBoard[j][i];
                columnSum += sudokuBoard[i][j];
                // Huhhh. That wasn't easy...
                gridSum += sudokuBoard[i * cubeSize % size + j % cubeSize][(i / cubeSize) * cubeSize + j / cubeSize];
            }
            //
            if (!(rowSum == expectedSum) || (columnSum != expectedSum) || (gridSum != expectedSum)) {
                return false;
            }
        }
        return true;
    }

    private static int[][] stringsToSudokuBoard(String[] numbers) {
        int size = Double.valueOf(Math.sqrt(numbers.length)).intValue();
        int[][] result = new int[size][size];
        int count = 0;
        for (String number : numbers) {
            result[count / size][count++ % size] = Integer.parseInt(number, 10);
        }
        return result;
    }
}