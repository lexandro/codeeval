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
        Files.lines(Paths.get(args[0])).map(Main::cardNumberValidation).forEach(System.out::println);

    }

    static String cardNumberValidation(String fileLine) {
        if ("".equalsIgnoreCase(fileLine)) {
            throw new IllegalArgumentException("Input is empty");
        }

        int pos = 0;
        int sum = 0;

        for (int i = fileLine.length() - 1; i >= 0; i--) {
            char ch = fileLine.charAt(i);
            if (ch != ' ') {
                pos++;
                if (pos % 2 == 0) {
                    sum += sumDigits(char2Int(ch) * 2);
                } else {
                    sum += char2Int(ch);
                }

            }
        }
        return String.valueOf(sum % 10 == 0 ? 1 : 0);
    }

    // We surely know, the input can't be bigger than 18
    static int sumDigits(int input) {
        return input % 10 + input / 10;
    }

    // we are optimistically assume the input is a digit
    static int char2Int(char input) {
        if (input < 58 && input > 47) {
            return (int) input - 48;
        } else {
            throw new IllegalArgumentException("Not a digit");
        }

    }
}