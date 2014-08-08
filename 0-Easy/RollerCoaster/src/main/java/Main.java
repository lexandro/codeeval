import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            rollerCoaster(fileLine);
        }
    }

    private static void rollerCoaster(String fileLine) {
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (char letter : fileLine.toCharArray()) {
            if (Character.isLetter(letter)) {
                result.append(flag ? Character.toUpperCase(letter) : Character.toLowerCase(letter));
                flag = !flag;
            } else {
                result.append(letter);
            }
        }
        System.out.println(result);
    }
}