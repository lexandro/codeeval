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
        long sumOfIntegers = 0;
        while ((fileLine = reader.readLine()) != null) {
            //
            if (!fileLine.isEmpty()) {
                int theNumber = Integer.valueOf(fileLine);
                sumOfIntegers += theNumber;
            }
        }
        System.out.println(sumOfIntegers);
    }

}
