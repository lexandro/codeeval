import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static final int MATRIX_SIZE = 256;
    private static final int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
//        runDsl("SetCol 32 20");
//        runDsl("SetRow 15 7");
//        runDsl("SetRow 16 31");
//        System.out.println(runDsl("QueryCol 32"));
//        runDsl("SetCol 2 14");
//        System.out.println(runDsl("QueryRow 10"));
//        runDsl("SetCol 14 0");
//        System.out.println(runDsl("QueryRow 15"));
//        runDsl("SetRow 10 1");
//        System.out.println(runDsl("QueryCol 2"));
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            int queryResult = runDsl(fileLine);
            if (queryResult > 0) {
                System.out.println(queryResult);
            }
        }
    }

    private static int runDsl(String dsl) {
        int result = 0;
        String[] elements = dsl.split(" ");
        if (elements.length == 2) {
            // we have query
            result = querySumFor(elements);
        } else {
            setValuesFor(elements);
        }
        return result;
    }

    private static int querySumFor(String[] elements) {
        int result;
        if (elements[0].substring(5, 6).equalsIgnoreCase("c")) {
            result = queryColumnSumFor(toInt(elements[1]));
        } else {
            result = queryRowSumFor(toInt(elements[1]));
        }
        return result;
    }

    private static int queryRowSumFor(int row) {
        int result = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            result += matrix[row][i];
        }
        return result;
    }

    private static int queryColumnSumFor(int col) {
        int result = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            result += matrix[i][col];
        }
        return result;
    }

    private static void setValuesFor(String[] elements) {
        int[] fillSettings = new int[]{toInt(elements[1]), toInt(elements[2])};
        if (elements[0].substring(3, 4).equalsIgnoreCase("r")) {
            setRowFor(fillSettings);
        } else {
            setColumnFor(fillSettings);
        }
    }

    private static void setRowFor(int[] fillSettings) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            matrix[fillSettings[0]][i] = fillSettings[1];
        }
    }

    private static void setColumnFor(int[] fillSettings) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            matrix[i][fillSettings[0]] = fillSettings[1];
        }
    }

    private static int toInt(String element) {
        return Integer.valueOf(element);
    }
}


