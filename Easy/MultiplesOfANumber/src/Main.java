import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        while ((fileLine = reader.readLine()) != null) {
            String[] numbersArray = fileLine.split(",");
            int first = Integer.valueOf(numbersArray[0]);
            int second = Integer.valueOf(numbersArray[1]);
            //
            int multiple = second;
            while (multiple < first) {
                multiple += second;
            }
            System.out.println(multiple);
        }
    }
}
