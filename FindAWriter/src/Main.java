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
            System.out.println(findAWriter(fileLine));
        }
    }

    private static String findAWriter(String fileLine) {
        String[] elements = fileLine.split("\\|");
        String[] positions = elements[1].trim().split(" ");
        int numberOfEncryptedCharacters = positions.length;
        char[] writerData = new char[numberOfEncryptedCharacters];
        //
        for (int i = 0; i < numberOfEncryptedCharacters; i++) {
            writerData[i] = elements[0].charAt(Integer.valueOf(positions[i]) - 1);
        }

        return String.valueOf(writerData);
    }

}
