import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available on https://github.com/lexandro/codeeval
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
            matrixRotation(fileLine);
        }
    }

    private static void matrixRotation(String inputLine) {
        String[] elements = inputLine.split(" ");
        int size = Double.valueOf(Math.sqrt(elements.length)).intValue();
        //
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(elements[y + (size - x - 1) * size] + ' ');
            }
        }
        System.out.println();
    }
}
