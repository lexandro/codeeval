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
            System.out.println(swapElements(fileLine));
        }
    }

    private static String swapElements(String fileLine) {
        String[] items = fileLine.split(" : ");
        String[] array = items[0].split(" ");
        String[] swaps = items[1].split(", ");
        for (String swap : swaps) {
            String[] positions = swap.split("-");
            int pos1 = Integer.valueOf(positions[0]);
            int pos2 = Integer.valueOf(positions[1]);
            String temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;

        }
        //
        StringBuilder result = new StringBuilder(array[0]);
        for (int i = 1; i < array.length; i++) {
            result.append(" ").append(array[i]);
        }
        return result.toString();

    }

}
