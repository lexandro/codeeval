import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static final char[] EMPTY = new char[0];

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                theMinistryOfTruth(fileLine);
            }
        }
    }

    private static void theMinistryOfTruth(String fileLine) {
        String[] items = fileLine.split(";");
        String[] originalWords = items[0].split("\\s+");
        String[] newWords = items.length == 2 ? items[1].split(" ") : new String[0];
        // reserve enough space to prevent reallocation
        StringBuilder result = new StringBuilder(items[0].length());
        //
        int index = 0;
        for (String originalWord : originalWords) {
            if (index >= newWords.length) {
                result.append(pad(originalWord.length()));
            } else {
                int pos = originalWord.indexOf(newWords[index]);
                if (pos >= 0) {
                    result.append(pad(pos));
                    result.append(newWords[index]);
                    result.append(pad(originalWord.length() - newWords[index].length() - pos));
                    index++;
                    //
                } else {
                    result.append(pad(originalWord.length()));
                }
            }
            result.append(' ');

        }
        System.out.println((index == newWords.length ? result : "I cannot fix history"));
    }

    private static char[] pad(int size) {
        char[] result;
        if (size > 0) {
            result = new char[size];
        } else {
            return EMPTY;
        }
        //
        for (int i = 0; i < size; i++) {
            result[i] = '_';
        }
        return result;
    }
}