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
            System.out.println(compressedSequence(fileLine));
        }
    }

    private static String compressedSequence(String fileLine) {
        String[] numbers = fileLine.split(" ");
        StringBuilder result = new StringBuilder();
        int count = 0;
        String lastNum = numbers[0];
        for (String number : numbers) {
            if (number.equals(lastNum)) {
                count++;
            } else {
                result.append(count).append(" ").append(lastNum).append(" ");
                count = 1;
                lastNum = number;
            }
        }
        result.append(count).append(" ").append(lastNum);
        return result.toString().trim();
    }

}