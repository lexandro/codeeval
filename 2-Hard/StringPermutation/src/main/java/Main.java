import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                stringPermutation(fileLine);
            }
        }
    }

    private static void stringPermutation(String fileLine) {
        char[] items = fileLine.toCharArray();
        Arrays.sort(items);
        StringBuilder result = new StringBuilder();
        //
        permutation(String.valueOf(items), "", result);
        //
        System.out.println(result.deleteCharAt(result.length() - 1));

    }

    private static void permutation(String remaining, String prefix, StringBuilder result) {
        if (remaining.isEmpty()) {
            result.append(prefix).append(',');
        } else {
            int remainingSize = remaining.length();
            for (int i = 0; i < remainingSize; i++) {
                permutation(remaining.substring(0, i) + remaining.substring(i + 1, remainingSize), prefix + remaining.charAt(i), result);
            }
        }
    }
}