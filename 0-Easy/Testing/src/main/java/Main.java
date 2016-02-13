import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).forEach(Main::testing);
    }

    private static void testing(String fileLine) {
        String[] elements = fileLine.split("\\|");
        int diffCount = calculateDifference(elements);
        System.out.println(evaluateDifference(diffCount));

    }

    private static int calculateDifference(String[] elements) {
        int result = 0;
        for (int i = 0; i < elements[0].length() - 1; i++) {
            if (elements[0].charAt(i) != elements[1].charAt(i + 1)) {
                result++;
            }
            if (result == 7) {
                break;
            }
        }
        return result;
    }

    private static String evaluateDifference(int diffCount) {
        switch (diffCount) {
            case 0:
                return "Done";
            case 1:
            case 2:
                return "Low";
            case 3:
            case 4:
                return "Medium";
            case 5:
            case 6:
                return "High";
            default:
                return "Critical";
        }
    }


}