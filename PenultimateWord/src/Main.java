import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(penultimateWord(fileLine));
        }
    }

    private static String penultimateWord(String fileLine) {
        String[] words = fileLine.split(" ");
        int arraySize = words.length;
        return arraySize > 1 ? words[arraySize - 2] : words[0];
    }
}
