import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Map<Character, Integer> romanValues;

    public static void main(String[] args) throws Throwable {
        romanValues = new HashMap<>(7);
        //
        romanValues.put('M', 1000);
        romanValues.put('D', 500);
        romanValues.put('C', 100);
        romanValues.put('L', 50);
        romanValues.put('X', 10);
        romanValues.put('V', 5);
        romanValues.put('I', 1);
        //
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                romanAndArabic(fileLine);
            }
        }
    }

    private static void romanAndArabic(String fileLine) {
        int value = 0;
        int prevValue;
        int prevRomanBase = 0;
        int sum = 0;
        //
        for (int i = 0; i < fileLine.length(); i += 2) {
            prevValue = value;
            value = (fileLine.charAt(i) - 48) * romanValues.get(fileLine.charAt(i + 1));
            //
            if (prevRomanBase < romanValues.get(fileLine.charAt(i + 1))) {
                sum -= prevValue;
            } else {
                sum += prevValue;
            }
            prevRomanBase = romanValues.get(fileLine.charAt(i + 1));
        }
        sum += value;
        //
        System.out.println(sum);
    }

}