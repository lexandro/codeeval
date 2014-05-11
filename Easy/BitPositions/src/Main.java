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
            {
                String[] numbersArray = fileLine.split(",");
                int n = Integer.valueOf(numbersArray[0]);
                int p1 = Integer.valueOf(numbersArray[1]);
                int p2 = Integer.valueOf(numbersArray[2]);

                int p1bit = 1 << (p1 - 1);
                int p2bit = 1 << (p2 - 1);

                System.out.println(!(((p1bit & n) ^ p1bit) == 0 ^ ((p2bit & n) ^ p2bit) == 0));
            }

        }
    }
}
