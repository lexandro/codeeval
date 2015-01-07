import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static String[] slangs = {", yeah!"
            , ", this is crazy, I tell ya."
            , ", can U believe this?"
            , ", eh?"
            , ", aw yea."
            , ", yo."
            , "? No way!"
            , ". Awesome!"
    };

    private static int slangIndex = 0;

    private static Set<Character> punctuationMarks = new HashSet<>(Arrays.asList('.', '!', '?'));

    private static boolean shouldReplace = true;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                slangFlavor(fileLine);
            }
        }
    }

    private static void slangFlavor(String fileLine) {
        StringBuilder result = new StringBuilder();
        for (Character theChar : fileLine.toCharArray()) {
            String slang = null;
            if (punctuationMarks.contains(theChar)) {
                if (shouldReplace = !shouldReplace) {
                    slang = getNextSlang();
                }
            }
            result.append(slang == null ? theChar : slang);
        }
        System.out.println(result.toString());
    }

    private static String getNextSlang() {
        String result = slangs[slangIndex];
        if (++slangIndex == slangs.length) {
            slangIndex = 0;
        }
        return result;
    }

}