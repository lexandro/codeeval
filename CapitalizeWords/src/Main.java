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
            System.out.println(capitalizeWords(fileLine));
        }
    }

    private static String capitalizeWords(String fileLine) {
        char[] chars = fileLine.toCharArray();
        boolean spaceFlag = true;
        for (int i = 0; i < chars.length; i++) {
            if (32 == chars[i] && !spaceFlag) {
                spaceFlag = true;
            } else if (spaceFlag && chars[i] > 96 && chars[i] < 123) {
                chars[i] = (char) (chars[i] - 32);
                spaceFlag = false;
            } else {
                spaceFlag = false;
            }
        }
        return String.valueOf(chars);
    }
}
