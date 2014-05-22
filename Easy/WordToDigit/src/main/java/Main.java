import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Map<String, String> digitsMap;

    public static void main(String[] args) throws IOException {
        initializeMap();
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(wordToDigit(fileLine));
        }
    }

    private static String wordToDigit(String fileLine) {
        String[] digitWords = fileLine.split(";");
        StringBuilder result = new StringBuilder();
        for (String digitWord : digitWords) {
            result.append(digitsMap.get(digitWord));
        }
        return result.toString();
    }

    private static void initializeMap() {
        digitsMap = new HashMap<>();
        digitsMap.put("zero", "0");
        digitsMap.put("one", "1");
        digitsMap.put("two", "2");
        digitsMap.put("three", "3");
        digitsMap.put("four", "4");
        digitsMap.put("five", "5");
        digitsMap.put("six", "6");
        digitsMap.put("seven", "7");
        digitsMap.put("eight", "8");
        digitsMap.put("nine", "9");
    }
}

