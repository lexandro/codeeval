import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::longestCommonSubsequence).forEach(System.out::println);

    }

    static String longestCommonSubsequence(String fileLine) {
        return fileLine + "";

    }

}