import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::reverseBurrowsWheelerTransform).forEach(System.out::println);

    }

    static String reverseBurrowsWheelerTransform(String fileLine) {

        //
        int terminator = fileLine.indexOf('|');
        StringBuilder data = new StringBuilder(fileLine.substring(0, terminator));
        // Using array matrix to store variations
        char[][] transforms = new char[data.length()][data.length()];
        //
        //
        for (int i = 0; i < data.length(); i++) {
            for (int j = 0; j < data.length(); j++) {
                // working with reversed char array to avoid insertion into to beginning of arrays
                transforms[j][i] = data.charAt(j);
            }
            final int currStrSize = i;
            // saving memory for comparison and not generating strings, comparing reversed strings
            Arrays.sort(transforms, (o1, o2) -> {
                for (int ii = currStrSize; ii >= 0; ii--) {
                    int diff = o1[ii] - o2[ii];
                    if (diff != 0) {
                        return diff;
                    }
                }
                return 0;
            });
        }

        // We surely know there's one and only one entry starting with '$'
        @SuppressWarnings("OptionalGetWithoutIsPresent") char[] result = Arrays
                .stream(transforms).filter(item -> item[0] == '$')
                .findFirst().get();
        //
        revertArray(result);
        return String.valueOf(result);
    }

    private static void revertArray(char[] result) {
        for (int i = 0; i < result.length / 2; i++) {
            char temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
    }
}