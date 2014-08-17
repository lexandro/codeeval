import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(simpleSorting(fileLine));
        }
    }

    private static String simpleSorting(String fileLine) {
        String[] numberStrings = fileLine.split(" ");
        BigDecimal[] numbers = new BigDecimal[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = new BigDecimal(numberStrings[i]);
        }
        Arrays.sort(numbers);
        StringBuilder result = new StringBuilder(numbers[0].toString());
        for (int i = 1; i < numbers.length; i++) {
            result.append(" ").append(numbers[i].toString());
        }
        return result.toString();
    }
}
