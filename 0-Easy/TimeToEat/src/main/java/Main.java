import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::timeToEat).forEach(System.out::println);

    }

    static String timeToEat(String fileLine) {
        return Arrays.stream(fileLine.split(" ")).sorted(Comparator.reverseOrder()).reduce("", (a, b) -> a + (a.length() > 0 ? " " : "") + b);
    }
}

