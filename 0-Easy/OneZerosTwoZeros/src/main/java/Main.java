import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::oneZerosTwoZeros).forEach(System.out::println);

    }

    static String oneZerosTwoZeros(String fileLine) {
        String[] items = fileLine.split(" ");
        int expZeros = Integer.parseInt(items[0]);
        int rangeMax = Integer.parseInt(items[1]);
        //
        long i = IntStream.range(1, rangeMax + 1).mapToObj(Integer::toBinaryString).filter(bin -> bin.chars().filter(c -> c == '0').count() == expZeros).count();
        //
        return String.valueOf(i);
    }
}

