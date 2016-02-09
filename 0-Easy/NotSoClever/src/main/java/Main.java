import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).forEach(Main::notSoClever);
    }

    protected static void notSoClever(String fileLine) {
        String[] items = fileLine.split("\\|");
        int[] numbers = Stream.of(items[0].split(" ")).mapToInt(Integer::parseInt).toArray();

        int stepCount = 0;
        int maxSteps = Integer.parseInt(items[1].trim());
        int i = 0;
        while (i < numbers.length - 1 && stepCount < maxSteps) {
            if (numbers[i] > numbers[i + 1]) {
                int helper = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = helper;
                i = 0;
                stepCount++;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(numbers).replaceAll("\\[|\\]|,", ""));


    }
}