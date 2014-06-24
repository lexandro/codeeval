import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */

public class Main {

    private static char[] chars;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                balancedSmileys(fileLine);
            }
        }
    }

    private static void balancedSmileys(String fileLine) {
        chars = fileLine.toCharArray();
        int allOpened = 0;
        int trueOpened = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                allOpened++;
                if (isNonSmile(i)) {
                    trueOpened++;
                }
            } else if (chars[i] == ')') {
                trueOpened = Math.max(0, --trueOpened);
                if (isNonSmile(i)) {
                    if (allOpened >= 0) {
                        allOpened--;
                    } else {
                        break;
                    }
                }
            }
        }
        if (trueOpened == 0 && allOpened >= 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isNonSmile(int index) {
        return index == 0 || chars[index - 1] != ':';
    }
}