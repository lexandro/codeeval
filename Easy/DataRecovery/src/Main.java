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
            System.out.println(dataRecovery(fileLine));
        }
    }

    private static String dataRecovery(String fileLine) {
        String[] elements = fileLine.split(";");
        //
        String[] words = elements[0].split(" ");
        String[] resultWords = new String[words.length];
        String[] positions = elements[1].split(" ");
        //
        unShuffleWords(words, resultWords, positions);
        //
        String remainder = findLastShuffledWord(words);
        //
        StringBuilder result = assembleSentence(resultWords, remainder);
        return result.toString();
    }

    private static void unShuffleWords(String[] words, String[] resultWords, String[] positions) {
        for (int i = 0; i < positions.length; i++) {
            resultWords[Integer.valueOf(positions[i]) - 1] = words[i];
            words[i] = null;
        }
    }

    private static String findLastShuffledWord(String[] words) {
        String remainder = null;
        for (String word : words) {
            if (word != null) {
                remainder = word;
                break;
            }
        }
        return remainder;
    }

    private static StringBuilder assembleSentence(String[] resultWords, String remainder) {
        StringBuilder result = new StringBuilder(resultWords[0]);
        for (int i = 1; i < resultWords.length; i++) {
            result.append(" ").append(resultWords[i] != null ? resultWords[i] : remainder);
        }
        return result;
    }

}
