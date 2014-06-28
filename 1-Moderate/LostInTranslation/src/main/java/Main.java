import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static char[] codelTranslationTable = new char[26];

    public static void main(String[] args) throws Throwable {
        initCodelTranslationTable();
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                lostInTranslation(fileLine);
            }
        }
    }

    private static void lostInTranslation(String fileLine) {
        char[] codelText = fileLine.toCharArray();
        for (int i = 0; i < codelText.length; i++) {
            if (codelText[i] - 97 < 26 && codelText[i] - 97 >= 0) {
                codelText[i] = codelTranslationTable[codelText[i] - 97];
            }
        }
        System.out.println(codelText);
    }

    private static void initCodelTranslationTable() {
        codelTranslationTable['a' - 97] = 'y';
        codelTranslationTable['b' - 97] = 'h';
        codelTranslationTable['c' - 97] = 'e';
        codelTranslationTable['d' - 97] = 's';
        codelTranslationTable['e' - 97] = 'o';
        codelTranslationTable['f' - 97] = 'c';
        codelTranslationTable['g' - 97] = 'v';
        codelTranslationTable['h' - 97] = 'x';
        codelTranslationTable['i' - 97] = 'd';
        codelTranslationTable['j' - 97] = 'u';
        codelTranslationTable['k' - 97] = 'i';
        codelTranslationTable['l' - 97] = 'g';
        codelTranslationTable['m' - 97] = 'l';
        codelTranslationTable['n' - 97] = 'b';
        codelTranslationTable['o' - 97] = 'k';
        codelTranslationTable['p' - 97] = 'r';
        codelTranslationTable['q' - 97] = 'z';
        codelTranslationTable['r' - 97] = 't';
        codelTranslationTable['s' - 97] = 'n';
        codelTranslationTable['t' - 97] = 'w';
        codelTranslationTable['u' - 97] = 'j';
        codelTranslationTable['v' - 97] = 'p';
        codelTranslationTable['w' - 97] = 'f';
        codelTranslationTable['x' - 97] = 'm';
        codelTranslationTable['y' - 97] = 'a';
        codelTranslationTable['z' - 97] = 'q';
    }
}