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
            String[] numberStrings = fileLine.split(",");
            int number1 = Integer.valueOf(numberStrings[0]);
            int number2 = Integer.valueOf(numberStrings[1]);
            //
            System.out.println(calculateMod(number1, number2));
        }
    }

    private static int calculateMod(int number1, int number2) {
        while (number1 >= number2) {
            number1 -= number2;
        }
        return number1;
    }
}
