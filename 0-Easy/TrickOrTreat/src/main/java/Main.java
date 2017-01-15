import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static int[] candies = {3, 4, 5, 1};
    private static Pattern pattern = Pattern.compile("(\\d+)");


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::trickOrTreat).forEach(System.out::println);

    }

    static String trickOrTreat(String fileLine) {
        //
        Matcher matcher = pattern.matcher(fileLine);
        int[] numbers = new int[4];
        int count = 0;
        int numberOfKids = 0;
        //  extract numbers
        while (matcher.find()) {
            int number = Integer.valueOf(fileLine.substring(matcher.start(), matcher.end()));
            numbers[count] = number * candies[count];
            if (count < 3) {
                numberOfKids += number;
            }
            count++;
        }

        return String.valueOf(Arrays.stream(numbers).limit(3).sum() * numbers[3] / numberOfKids);
    }
}

