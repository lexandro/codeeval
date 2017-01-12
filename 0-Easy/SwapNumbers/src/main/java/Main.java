import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.swapNumbers)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::swapNumbers).forEach(System.out::println);

    }

    static String swapNumbers(String fileLine) {
        char[] data = fileLine.toCharArray();
        int start = 0;
        for (int i = 0; i <= data.length; i++) {
            if (i == data.length || data[i] == ' ') {
                char temp = data[i - 1];
                data[i - 1] = data[start];
                data[start] = temp;
                start = i + 1;
            }
        }
        return String.valueOf(data);
    }
}

