import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.stringMask)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::stringMask).forEach(System.out::println);

    }

    static String stringMask(String fileLine) {
        String[] items = fileLine.split(" ");
        char[] data = items[0].toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (items[1].charAt(i) == '1' && data[i] > 96) {
                data[i] -= 32;
            }
        }
        return String.valueOf(data);
    }
}

