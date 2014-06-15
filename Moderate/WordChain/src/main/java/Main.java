import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */

public class Main {

    private static String[] unprocessedWords;
    private static boolean[] processed;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                wordChain(fileLine);
            }
        }
    }

    // CPU intensive, but memory effective version
    private static void wordChain(String fileLine) {
        unprocessedWords = fileLine.split(",");
        // flag to see what is already in the chain or not
        processed = new boolean[unprocessedWords.length];

        int maxChainLength = 0;
        for (int i = 0; i < unprocessedWords.length; i++) {
            //
            int chainLength = findLongestChain(i, 1);
            //
            if (chainLength > maxChainLength) {
                maxChainLength = chainLength;
            }
        }
        System.out.println(maxChainLength > 1 ? maxChainLength : "None");
    }

    private static int findLongestChain(int wordIndex, int currentLength) {
        int maxResult = currentLength;
        processed[wordIndex] = true;
        for (int i = 0; i < unprocessedWords.length; i++) {
            if (!processed[i] && isChaining(unprocessedWords[wordIndex], unprocessedWords[i])) {
                processed[i] = true;
                //
                int result = findLongestChain(i, currentLength + 1);
                if (result > maxResult) {
                    maxResult = result;
                }
                //
                processed[i] = false;
            }
        }
        processed[wordIndex] = false;
        return maxResult;

    }

    private static boolean isChaining(String word, String unprocessedWord) {
        return word.charAt(word.length() - 1) == unprocessedWord.charAt(0);
    }
}