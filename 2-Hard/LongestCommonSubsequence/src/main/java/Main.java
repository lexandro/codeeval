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
        Files.lines(Paths.get(args[0])).map(Main::longestCommonSubSequence).forEach(System.out::println);

    }

    static String longestCommonSubSequence(String fileLine) {
        String[] items = fileLine.split(";");
        // check similarity O(1)
        if (items[0].equals(items[1])) {
            return items[0];
        } else {
            // ordering input by length, enough to check the smaller against the bigger one.
            int longerIndex = items[0].length() > items[1].length() ? 0 : 1;
            String longer = items[longerIndex];
            String smaller = items[1 - longerIndex];
            for (int i = 0; i < smaller.length(); i++) {
                System.out.println(i);
            }
        }
        return fileLine + "";

    }

}