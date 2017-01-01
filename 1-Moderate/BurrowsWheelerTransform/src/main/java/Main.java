import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

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
        //
        StringBuilder[] transforms = new StringBuilder[data.length()];
        for (int i = 0; i < data.length(); i++) {
            if (transforms[i] == null) {
                transforms[i] = new StringBuilder();
            }
        }
        //
        for (int i = 0; i < data.length(); i++) {
            for (int j = 0; j < data.length(); j++) {
                transforms[j].insert(0, data.charAt(j));
            }

            // saving memory for comparison and not generating strings
            Arrays.sort(transforms, (o1, o2) -> {
                for (int ii = 0; ii < o1.length(); ii++) {
                    int cmp = Character.valueOf(o1.charAt(ii)).compareTo(o2.charAt(ii));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            });
        }
        Optional<StringBuilder> result = Arrays.stream(transforms).filter(item -> item.charAt(item.length() - 1) == '$').findFirst();
        //
        return result.get().toString();
    }
}