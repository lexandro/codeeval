import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }


    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(calculateStringBeautiness(fileLine));
        }
    }

    private static int calculateStringBeautiness(String text) {
        //
        int[] numberOfOccurrences = calculateLetterOccurrences(text);
        //
        List<Integer> reverseSortedOccurrenceAmounts = reverseSortOccurrences(numberOfOccurrences);
        //
        return calculate(reverseSortedOccurrenceAmounts);
    }

    private static int calculate(List<Integer> reverseSortedOccurrenceAmounts) {
        int result = 0;
        int counter = 26;
        //
        for (int amount : reverseSortedOccurrenceAmounts) {
            result += amount * counter--;
        }
        return result;
    }

    private static int[] calculateLetterOccurrences(String text) {
        String[] letters = text.toLowerCase().split("");
        int[] lettersCount = new int[26];
        //
        for (int i = 1; i < letters.length; i++) {
            String letter = letters[i];
            char character = letter.charAt(0);
            if (character > 96 && character < 123)
                lettersCount[character - 97]++;
        }
        return lettersCount;
    }

    private static List<Integer> reverseSortOccurrences(int[] occurrenceAmounts) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i : occurrenceAmounts) {
            if (i != 0) {
                values.add(i);
            }
        }
        //
        Collections.sort(values);
        Collections.reverse(values);
        return values;
    }
}
