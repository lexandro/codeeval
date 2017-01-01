import java.nio.file.Files;
import java.nio.file.Paths;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static String ALLOWED_CHARS = " !\"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::gronsfeldCipher).forEach(System.out::println);

    }

    static String gronsfeldCipher(String fileLine) {
        StringBuilder result = new StringBuilder();
        String[] items = fileLine.split(";");
        int[] keys = str2Keys(items[0]);
        int keyIndex = 0;
        //
        for (char letter : items[1].toCharArray()) {
            int letterIndex = ALLOWED_CHARS.indexOf(letter);
            // preventing the underflow with ALLOWED_CHARS.length()
            letterIndex = (letterIndex - keys[keyIndex] + ALLOWED_CHARS.length()) % ALLOWED_CHARS.length();
            result.append(ALLOWED_CHARS.charAt(letterIndex));
            // looping through the keys
            keyIndex = (keyIndex + 1) % keys.length;
        }
        return result.toString();
    }

    // converts string of digits to an array
    private static int[] str2Keys(String key) {
        int[] result = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            result[i] = key.charAt(i) - 48;
        }
        return result;
    }
}