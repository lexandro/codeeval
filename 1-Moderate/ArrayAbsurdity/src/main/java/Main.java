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
                arrayAbsurdity(fileLine);
            }
        }
    }

    private static void arrayAbsurdity(String fileLine) {
        String[] sections = fileLine.split(";");
        String[] arrayItems = sections[1].split(",");
        int[] numbersCounter = new int[Integer.valueOf(sections[0])];
        for (String arrayItem : arrayItems) {
            int index = Integer.valueOf(arrayItem);
            if (numbersCounter[index] == 1) {
                System.out.println(index);
                break;
            }
            numbersCounter[index]++;
        }
    }
}
