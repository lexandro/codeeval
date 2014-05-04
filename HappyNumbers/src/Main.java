import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // setup input
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(isHappyNumber(fileLine));
        }

    }

    private static String isHappyNumber(String fileLine) {
        if (sumOfSquares(Integer.valueOf(fileLine), new HashSet<Integer>()).contains(1)) {
            return "1".intern();
        } else {
            return "0".intern();
        }
    }

    private static Set<Integer> sumOfSquares(Integer number, Set<Integer> sums) {
        sums.add(number);
        String[] digits = number.toString().split("");
        int sum = 0;
        for (String digit : digits) {
            if (!digit.isEmpty()) {
                int digitInt = Integer.valueOf(digit);
                sum += digitInt * digitInt;
            }
        }
        if (!sums.contains(sum)) {
            sumOfSquares(sum, sums);
        }
        return sums;
    }
}
