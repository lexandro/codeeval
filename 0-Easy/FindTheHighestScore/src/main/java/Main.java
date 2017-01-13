import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::findTheHighestScore).forEach(System.out::println);

    }

    static String findTheHighestScore(String fileLine) {
        String[] items = fileLine.split("\\|");
        int[] maxPoints = null;
        for (String item : items) {
            int[] actPoints = Arrays.stream(item.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            //
            if (maxPoints == null) {
                maxPoints = actPoints;
            } else {
                for (int j = 0; j < maxPoints.length; j++) {
                    maxPoints[j] = Math.max(actPoints[j], maxPoints[j]);
                }
            }
        }
        return Arrays.stream(maxPoints).mapToObj(String::valueOf).reduce("", (a, b) -> a + (a.length() > 0 ? " " : "") + b);

    }
}

