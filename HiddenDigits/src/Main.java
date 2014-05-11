import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {


    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(hiddenDigits(fileLine));
        }
    }

    private static String hiddenDigits(String csvLine) {
        byte[] items = csvLine.getBytes();
        StringBuilder result = new StringBuilder();
        for (byte item : items) {
            if (item > 47 && item < 58) {
                result.append(item - 48);
            } else if (item > 96 && item < 107) {
                result.append(item - 97);
            }
        }
        return result.length() > 0 ? result.toString() : "NONE";
    }
}