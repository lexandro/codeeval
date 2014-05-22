import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // setup input
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(isArmstrongNumber(fileLine) ? "True" : "False");
        }
    }

    private static boolean isArmstrongNumber(String fileLine) {
        int number = Integer.valueOf(fileLine);
        int numberSize = fileLine.length();
        String[] digits = fileLine.split("");
        int sum = 0;
        int i = 1;
        while (i <= numberSize) {
            sum += Math.pow(Integer.valueOf(digits[i]), numberSize);
            i++;
        }
        return sum == number;
    }
}
