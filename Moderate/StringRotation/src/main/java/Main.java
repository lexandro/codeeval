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
                stringRotation(fileLine);
            }
        }
    }

    // that's quite ugly, I don't like it. I'll try to make it nicer
    private static void stringRotation(String fileLine) {
        String[] elements = fileLine.split(",");
        //
        for (int i = 0; i < elements[0].length(); i++) {
            if (isRotationStartsFrom(i, elements[0], elements[1])) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");

    }

    private static boolean isRotationStartsFrom(int position, String word1, String word2) {
        for (int j = 0; j < word1.length(); j++) {
            if (word1.charAt(j) != word2.charAt((position + j) % word2.length())) {
                return false;
            }
        }
        return true;
    }
}