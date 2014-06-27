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
                minimumCoins(fileLine);
            }
        }
    }

    private static void minimumCoins(String fileLine) {
        int amount = Integer.valueOf(fileLine);
        //
        int count = amount / 5;
        amount = amount % 5;
        count += amount / 3 + amount % 3;
        System.out.println(count);

    }
}