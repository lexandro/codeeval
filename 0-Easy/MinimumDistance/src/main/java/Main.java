import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::minimumDistance).forEach(System.out::println);

    }

    static String minimumDistance(String fileLine) {
        int[] items = Arrays.stream(fileLine.split(" ")).mapToInt(Integer::parseInt).skip(1).sorted().toArray();
        int min = items[0];
        int max = items[items.length - 1];
        //
        OptionalInt minDistance = IntStream
                .range(min, max)
                .map(i -> Arrays // calculate the sum of distances for the actual street number
                        .stream(items)
                        .map(item -> Math.abs(item - i))
                        .sum())
                .min();
        //
        //noinspection OptionalGetWithoutIsPresent
        return String.valueOf(minDistance.getAsInt());
    }
}

