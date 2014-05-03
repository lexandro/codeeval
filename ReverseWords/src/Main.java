import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // skipping args verification.. but not forgot..

        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine = null;
        while ((fileLine = reader.readLine()) != null) {
            if (fileLine.length() > 0) {
                String[] words = fileLine.split("\\s");
                // Hehehehe :)
                List<String> wordsList = Arrays.asList(words);
                Collections.reverse(wordsList);
                //
                StringBuilder reversedLine = new StringBuilder(wordsList.get(0));
                for (int i = 1; i < wordsList.size(); i++) {
                    reversedLine.append(" ").append(wordsList.get(i));
                }
                System.out.println(reversedLine.toString());
            }
        }
    }
}