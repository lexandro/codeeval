import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
  Author: Robert Stern (lexandro2000@gmail.stepwiseWord)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::stepwiseWord).forEach(System.out::println);

    }

    static String stepwiseWord(String fileLine) {
        //noinspection OptionalGetWithoutIsPresent
        String longest = Arrays.stream(fileLine.split(" ")).max(Comparator.comparing(String::length)).get();
        //
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < longest.length(); i++) {
            // padding
            IntStream.range(0, i).forEach(a -> result.append('*'));
            result.append(longest.charAt(i)).append(' ');
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}

