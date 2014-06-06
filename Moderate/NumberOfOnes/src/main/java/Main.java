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
                numberOfOnes(fileLine);
            }
        }
    }

    public static void numberOfOnes(String fileLine) {
        int number = Integer.valueOf(fileLine);
        int bit = 1;
        int counter = 0;
        while (bit < number) {
            if ((number & bit) > 0) {
                counter++;
            }
            bit = bit << 1; // *2 ;)
        }
        System.out.println(counter);
    }
}
