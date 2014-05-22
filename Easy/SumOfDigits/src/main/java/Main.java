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
            int sumOfDigits = 0;
            //
            String[] digits = fileLine.split("");
            for (int i = 1; i < digits.length; i++) {
                sumOfDigits += Integer.valueOf(digits[i]);
            }
            //
            System.out.println(sumOfDigits);
        }
    }
}
