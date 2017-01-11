import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
  Author: Robert Stern (lexandro2000@gmail.comparePoints)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::comparePoints).forEach(System.out::println);

    }

    static String comparePoints(String fileLine) {
        int[] items = Arrays.stream(fileLine.split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder result = new StringBuilder();


        if (items[1] < items[3]) {
            result.append('N');
        } else if (items[1] > items[3]) {
            result.append('S');
        }

        if (items[0] < items[2]) {
            result.append('E');
        } else if (items[0] > items[2]) {
            result.append('W');
        }

        return result.length() == 0 ? "here" : result.toString();
    }
}

