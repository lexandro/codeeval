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
                pangrams(fileLine);
            }
        }
    }

    private static void pangrams(String fileLine) {
        boolean[] lettersUsage = new boolean[26];
        //
        for (int count = 0; count < fileLine.length(); count++) {
            char letter = fileLine.charAt(count);
            if (letter >= 'a' && letter <= 'z') {
                lettersUsage[letter - 'a'] = true;
            } else if (letter >= 'A' && letter <= 'Z') {
                lettersUsage[letter - 'A'] = true;
            }
        }
        boolean flag = false;
        for (byte count = 0; count < 26; count++) {
            if (!lettersUsage[count]) {
                System.out.print((char) (count + 97));
                flag = true;
            }
        }
        System.out.println(flag ? "" : "NULL");
    }
}
