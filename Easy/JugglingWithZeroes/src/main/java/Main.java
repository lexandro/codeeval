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
                jugglingWithZeroes(fileLine);
            }
        }
    }

    private static void jugglingWithZeroes(String fileLine) {
        String[] items = fileLine.split(" ");
        StringBuilder result = new StringBuilder();
        String digitsToAdd;
        //
        for (int i = 0; i < items.length; i += 2) {
            if (!items[i].equals("0")) {
                digitsToAdd = items[i + 1].replace('0', '1');
            } else {
                digitsToAdd = items[i + 1];
            }
            result.append(digitsToAdd);
        }
        System.out.println(Long.parseLong(result.toString(), 2));
    }
}