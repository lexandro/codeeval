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
            System.out.println(jsonMenuIds(fileLine));
        }
    }

    private static int jsonMenuIds(String fileLine) {
        String[] words = fileLine.split("id\":");
        int result = 0;
        for (String word : words) {
            if (word.contains("\"label\"")) {
                result += Integer.valueOf(word.substring(0, word.indexOf(",")).trim());
            }
        }
        return result;
    }

}