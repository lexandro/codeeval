import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Map<String, Integer> cardValues;

    static {
        cardValues = new HashMap<>();
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);
    }

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::simpleOrTrump).forEach(System.out::println);

    }

    static String simpleOrTrump(String fileLine) {
        String[] items = fileLine.split(" \\| ");
        //
        char trump = items[1].charAt(0);
        String[] cards = items[0].split(" ");
        final int[] maxValue = {0};
        //
        Map<String, Integer> values = Arrays
                .stream(cards)
                .collect(Collectors.toMap(c -> c, c -> {
                    int result = cardValues.get(c.substring(0, c.length() - 1));
                    if (c.charAt(c.length() - 1) == trump) {
                        result += 20;
                    }
                    //
                    if (result > maxValue[0]) {
                        maxValue[0] = result;
                    }
                    return result;
                }));

        return values.keySet().stream().filter(k -> values.get(k) == maxValue[0]).reduce("", (a, b) -> a + (a.length() > 0 ? " " : "") + b);
    }
}

