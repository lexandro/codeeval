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
            System.out.println(isSelfDescribingNumber(fileLine));
        }
    }

    private static int isSelfDescribingNumber(String fileLine) {
        //
        for (int i = 0; i < fileLine.length(); i++) {
            int digit = Integer.valueOf(fileLine.substring(i, i + 1));
            if (!(digit == countOccurrences(fileLine, i))) {
                return 0;
            }
        }
        return 1;
    }

    private static int countOccurrences(String fileLine, Integer digit) {
        int count = 0;
        int lastPos = 0;
        //
        while (lastPos != -1) {
            lastPos = fileLine.indexOf(digit.toString(), lastPos);
            if (lastPos != -1) {
                lastPos++;
                count++;
            }
        }
        return count;
    }
}
