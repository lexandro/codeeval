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
            System.out.println(shortestRepetition(fileLine));
        }
    }

    private static int shortestRepetition(String csvLine) {
        int lineSize = csvLine.length();
        int result = lineSize;
        int i = 0;
        boolean found = false;
        while (++i < lineSize) {
            if (i < lineSize / 2 + 1) {
                if (lineSize % i == 0) {
                    String fragment = csvLine.substring(0, i);
                    if (csvLine.substring(0, i * 2).equals(fragment + fragment)) {
                        result = i;
                        found = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return found ? result : lineSize;
    }
}