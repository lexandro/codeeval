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
            System.out.println(multiplyLists(fileLine));
        }
    }

    private static String multiplyLists(String csvLine) {
        String[] lists = csvLine.split("\\|");
        String[] digits = lists[0].split(" ");
        String[] multipliers = lists[1].trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            result.append(Integer.valueOf(digits[i]) * Integer.valueOf(multipliers[i])).append(" ");
        }
        return result.toString().trim();
    }
}