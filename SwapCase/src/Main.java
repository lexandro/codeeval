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
            System.out.println(swapCase(fileLine));
        }
    }

    private static String swapCase(String fileLine) {
        char[] chars = fileLine.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 96 && chars[i] < 123) {
                chars[i] = (char) (chars[i] - 32);
            } else if (chars[i] > 64 && chars[i] < 91) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }
}
