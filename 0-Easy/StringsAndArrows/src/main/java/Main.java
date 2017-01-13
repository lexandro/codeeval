import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.stringsAndArrows)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::stringsAndArrows).forEach(System.out::println);

    }

    static String stringsAndArrows(String fileLine) {
        int sum = 0;
        sum += findAll(fileLine, "<--<<");
        sum += findAll(fileLine, ">>-->");
        return String.valueOf(sum);
    }

    private static int findAll(String fileLine, String pattern) {
        int result = 0;
        int index = fileLine.indexOf(pattern, 0);
        while (index != -1) {
            result++;
            index = fileLine.indexOf(pattern, index + 1);
        }
        return result;
    }
}

