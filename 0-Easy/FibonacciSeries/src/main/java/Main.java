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
            //
            int expectedPos = Integer.valueOf(fileLine);
            System.out.println(fibonacci(expectedPos));
        }
    }

    private static long fibonacci(int expectedPos) {
        long first = 0;
        long second = 1;
        for (int pos = 0; pos < expectedPos; pos++) {
            second += first;
            first = second - first;
        }
        return first;
    }
}
