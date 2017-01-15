import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::realFake).forEach(System.out::println);

    }

    static String realFake(String fileLine) {
        //
        final int[] adder = {0};
        long sum = fileLine.chars().filter(c -> c != ' ').map(c -> {
            adder[0] = 1 - adder[0];
            return (c - 48) * (1 + adder[0]);
        }).sum();
        return sum % 10 == 0 ? "Real" : "Fake";
    }
}

