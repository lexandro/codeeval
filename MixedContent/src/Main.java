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
            System.out.println(mixedContent(fileLine));
        }
    }

    private static String mixedContent(String fileLine) {
        String[] items = fileLine.split(",");
        //
        StringBuilder words = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        String numberPrefix = "";
        String wordPrefix = "";
        //
        for (String item : items) {
            if (item.charAt(0) > 47 && item.charAt(0) < 58) {
                numbers.append(numberPrefix);
                numbers.append(item);
                numberPrefix = ",";
            } else {
                words.append(wordPrefix);
                words.append(item);
                wordPrefix = ",";
            }
        }

        StringBuilder result;
        if (words.length() > 0) {
            result = words;
            if (numbers.length() > 0) {
                result.append("|").append(numbers);
            }
        } else {
            result = numbers;
        }

        return result.toString();
    }
}

