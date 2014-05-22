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
            System.out.println(morseCode(fileLine));
        }
    }

    private static String morseCode(String fileLine) {
        String[] words = fileLine.split("  ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(decodeWord(word)).append(" ");
        }
        return result.toString().trim();
    }

    private static StringBuilder decodeWord(String word) {
        String[] letters = word.split(" ");
        StringBuilder result = new StringBuilder();
        for (String letter : letters) {
            switch (letter) {
                case ".-":
                    result.append("A");
                    break;
                case "-...":
                    result.append("B");
                    break;
                case "-.-.":
                    result.append("C");
                    break;
                case "-..":
                    result.append("D");
                    break;
                case ".":
                    result.append("E");
                    break;
                case "..-.":
                    result.append("F");
                    break;
                case "--.":
                    result.append("G");
                    break;
                case "....":
                    result.append("H");
                    break;
                case "..":
                    result.append("I");
                    break;
                case ".---":
                    result.append("J");
                    break;
                case "-.-":
                    result.append("K");
                    break;
                case ".-..":
                    result.append("L");
                    break;
                case "--":
                    result.append("M");
                    break;
                case "-.":
                    result.append("N");
                    break;
                case "---":
                    result.append("O");
                    break;
                case ".--.":
                    result.append("P");
                    break;
                case "--.-":
                    result.append("Q");
                    break;
                case ".-.":
                    result.append("R");
                    break;
                case "...":
                    result.append("S");
                    break;
                case "-":
                    result.append("T");
                    break;
                case "..-":
                    result.append("U");
                    break;
                case "...-":
                    result.append("V");
                    break;
                case ".--":
                    result.append("W");
                    break;
                case "-..-":
                    result.append("X");
                    break;
                case "-.--":
                    result.append("Y");
                    break;
                case "--..":
                    result.append("Z");
                    break;
                case ".----":
                    result.append("1");
                    break;
                case "..---":
                    result.append("2");
                    break;
                case "...--":
                    result.append("3");
                    break;
                case "....-":
                    result.append("4");
                    break;
                case ".....":
                    result.append("5");
                    break;
                case "-....":
                    result.append("6");
                    break;
                case "--...":
                    result.append("7");
                    break;
                case "---..":
                    result.append("8");
                    break;
                case "----.":
                    result.append("9");
                    break;
                case "-----":
                    result.append("0");
                    break;
                default:
                    result.append("obazmeg").append(letter).append("faszbele");
            }
        }
        return result;
    }

}