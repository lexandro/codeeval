import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::chardonnayOrCabernet).forEach(System.out::println);

    }

    static String chardonnayOrCabernet(String fileLine) {
        String items[] = fileLine.split(" \\| ");
        String[] wines = items[0].split(" ");
        List<Character> knownLetters = new ArrayList<>(items[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        StringBuilder result = new StringBuilder();
        //
        for (String wine : wines) {
            ArrayList<Character> letters = new ArrayList<>(knownLetters);
            for (char wineLetter : wine.toLowerCase().toCharArray()) {
                int letterPos = letters.indexOf(wineLetter);
                if (letterPos >= 0) {
                    letters.remove(letterPos);
                    if (letters.isEmpty()) {
                        result.append(wine).append(' ');
                        break;
                    }

                }
            }
        }

        return result.length() > 0 ? result.toString().trim() : "False";
    }
}

