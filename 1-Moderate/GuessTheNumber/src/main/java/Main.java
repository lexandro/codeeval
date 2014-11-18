import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                guessTheNumber(fileLine);
            }
        }
    }

    private static void guessTheNumber(String fileLine) {
        String[] elements = fileLine.split(" ");
        int upper = Integer.valueOf(elements[0]);
        int lower = 0;
        int guess = 0;
        int answerIndex = 1;

        while (answerIndex < elements.length) {
            guess = (lower + upper + 1) / 2;
            if (elements[answerIndex].charAt(0) == 'L') {
                upper = guess - 1;
            } else if (elements[answerIndex].charAt(0) == 'H') {
                lower = guess + 1;
            } else {
                break;
            }
            answerIndex++;
        }
        System.out.println(guess);

    }
}