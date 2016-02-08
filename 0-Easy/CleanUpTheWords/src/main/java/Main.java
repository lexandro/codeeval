import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
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
        Files.lines(Paths.get(args[0])).forEach(Main::cleanUpTheWords);
    }

    protected static void cleanUpTheWords(String fileLine) {
        StringBuilder result = new StringBuilder(fileLine.length());
        fileLine
                .chars()
                .forEach(theChar -> {
                    if (Character.isLetter(theChar)) {
                        result.append((char) Character.toLowerCase(theChar));
                    } else {
                        if (result.length() > 0 && result.charAt(result.length() - 1) != ' ') {
                            result.append(' ');
                        }
                    }
                });

        System.out.println(result.toString());
    }
}