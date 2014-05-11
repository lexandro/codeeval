import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(lowestUniqueNumberPosition(fileLine));
        }
    }

    private static Integer lowestUniqueNumberPosition(String numberList) {
        int[] numbers = convertStringToInts(numberList);
        //
        Map<Integer, Integer> numberCounters = calculateOccurrences(numbers);
        //
        int lowestUniqueValue = findLowestUniqueNumber(numberCounters);
        //
        return findLowestUniqueIndex(numbers, lowestUniqueValue);
    }

    private static int[] convertStringToInts(String numberList) {
        String[] numberStrings = numberList.split(" ");
        int numbersAmount = numberStrings.length;
        int[] result = new int[numbersAmount];
        for (int i = 0; i < numbersAmount; i++) {
            result[i] = Integer.valueOf(numberStrings[i]);
        }
        return result;
    }

    private static Map<Integer, Integer> calculateOccurrences(int[] numbers) {
        Map<Integer, Integer> numberCounters = new HashMap<>();
        for (int number : numbers) {
            if (numberCounters.containsKey(number)) {
                numberCounters.put(number, numberCounters.get(number) + 1);
            } else {
                numberCounters.put(number, 1);
            }
        }
        return numberCounters;
    }

    private static int findLowestUniqueNumber(Map<Integer, Integer> numberCounters) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : numberCounters.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    private static int findLowestUniqueIndex(int[] numbers, int lowestUniqueValue) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (lowestUniqueValue == numbers[i]) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
