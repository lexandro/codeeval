import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static String digits;
    private static String letters;
    private static boolean haltFlag;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
//        sequenceTransformation("1010 AAAAABBBBAAAA");
//        sequenceTransformation("01001110 AAAABAAABBBBBBAAAAAAA");
//        sequenceTransformation("1100110 BBAABABBA");
//        sequenceTransformation("00 AAAAAA");
//        sequenceTransformation("0010110101011111101100111011101000000 AAAAAABBAAAAAAAAAAABBBBBBAAABBBAAAAAAAABBBBBBBBBABAAABBBBBAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        sequenceTransformation("00100101110110010101111111111 BBABABBBBBAAABBAAABBBABAAABBBABBBBABBBBBABABABBABAAABBAABBABB");
//        sequenceTransformation("100111000011011110110111000010100011010110100000100011110000011000100100101101000010001000100100100111010000000101001001111101010000 BAAAABBBBBAABBABBAAABAAABBBBABAAAABBBBAABBBAABABBBBBAAAABAAABBBBBAAAAAAAABBBABBBABAAAAAABABABBBABABAABBBBBBABBABBBABAABBABAABBAAABBABBABBABBAAABBBBAABBBABBB");
//        sequenceTransformation("0001011000100011001110111100100100110001001111101101111111110001101 AAABBABAABAABBBBBABBBBBAAABABABBABABAABAABBABAABBAABBBBAABBAAAABABA");
//        sequenceTransformation("111010011 AAAAAAAAAAAAAABBBAAAABBBBBBBBBB");
//        sequenceTransformation("110110000101101100100010101001001111111110100010100011110110001110010111000001000001 BAABBBAAAABBABBABBBBAAAAAAAAABABABBBBABAAABBAAABBAABABBAAAABBBABBABBAAAAAAABBBAABAAB");
//        sequenceTransformation("11000100000111100111101110101001010000110111010101101000001110110010111 BBABBBAABBABBABBBABBABABAABBABBBAAAAAAAAAABBAAABBABBABBBBABBBAAABAAAAAB");
//        sequenceTransformation("1111100101001100010111111001110010110100000110111011100101010011010110010000100010010111010110101100001 ABAABABABABBAAABBBAABBBAAAAABABAAAAABBABBAABBBABBBABABBAAAAABBABABAABABABAABBBAAAAABAAAAABBBBBBABBBABAB");
//        sequenceTransformation("0000 AAAA");
//        sequenceTransformation("0000 AAA");
//        sequenceTransformation("11111111111000011110100111111110011101011001001011001101010000010101101110111101000111100110010 BAABBABBBABBBBABABABBABBABBBBAABAABABBABBBABAAABBABBBBAAABBBABABBBBAAABBAABAABBABABAABBAAAABBBBAABBAA");
//        sequenceTransformation("00 BA");
//        sequenceTransformation("1110011001111001110011101010011110001110110101110 BBAAAABABBBBBABABABAABBABBAABBBBBABABABABBBABBABBABBABBAB");
//        sequenceTransformation("0000000101011101101101111011001101011001110001111000100100001010 AAAAAAAAAAAAAAAAAAAAAAAAAAAABAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBAAAAABBBAAAAAAAAAAAAAABBAAABBBBBBAABBAAAAAAABBBBBBAAAAAAAAAAAAAAABBBBBBBBBBAAAAAAAAAAAAAAAABBBAAABBBBBBAAAAAAAAAABBBBBAAAAABBBBAAAA");
//        sequenceTransformation("1011011010101001011001001101101111011010111101100010110110011001010100111000001111011010101011000110011011011111110001110000101110110101111011100101 ABBABABBBAAABBBBBBAAAABBBABBBABBABABBBBABBBBBBABABABBAABAAAABABBBABAAAAABBBBABABBBAABAAABBBABBBBAABBBABABAABBAABBABBABABBBBAAAAABABBBBBABBBBAABABAAAB");
//        sequenceTransformation("01011 AABBB");
//        sequenceTransformation("00110 AAAABBAA");
//        sequenceTransformation("1 B");
//        sequenceTransformation("00 AAAAAAAAAAA");
//        sequenceTransformation("111001000100110011011010100001010101011101111000110011100111001111111000010010011010101110101100010 ABBAABBABBBBABABABABABBAABBBBBABAAAAABAAABBAABBBABBBBABAAAAAABAAABBBAAABBBBBABBABAAAAABABAAAAAABBBAABBAAABAAABBBBBABAAAAAABBBBAABBBABABBABBABBBBABABAB");
//        sequenceTransformation("10000101001010100001000110101111101010101000011010001101100 BABBBBBBABAAAAAAABAABAAAAAAABBBAABABBBAABAABAAABAABBABBBAAB");
//        sequenceTransformation("111011111011000101101111100111011101010111111011001000111010000000111100 AABBBBBBAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAABAAAAAAAAABBBBAAAAAAAABAAAAAABBBBBBAAAAAAAAAAAABBBAAAABBBBAAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAABBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBAAAAAA");
//        sequenceTransformation("0 A");
//        sequenceTransformation("101001000100111111000000001010100001011011111111100010000100110101001011101111111001001011 BAABBBABBBBAAAABABBAAAAABABABABAABBBAAABBBAAAAABBABBBBABAABBAABBAAABAAABABBBAABBABBABBBBABAAAABABAAABABBABBAABAABBABAAABABABABBAAAAAAAAABABABBAABABBABABAAAAAAAAABBABAAAAABABBAAAAABAAABBAB");
//        sequenceTransformation("01011110100011010000110001101110001110000101000011101111110110000111111000101000110 AAAABBBAAAAAABBBBAAAAAABBBBBBBAAAAAAAAAAAAAAAAAAABBBBAAAAABAAAAAAAAAAAAAAAABBBBBBBAAAAAAAAAAABBAAAAAABBBBAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBAAAAAAAAAAAAAAAAAAAAABBBAAAAABBBBAAAAABBBBAAAAAAAAAAAAAAAAAABAAABBBBAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAABBBBBBAAAA");
//        sequenceTransformation("1100011110100111110011000100111010000100111100101010000011001100 BBBBAAAAAAABBBBBBBBABBBBBBABBAABAAABBAAABBAAABAABBABAABAAAABBAABABBABBBAABABAABBAAAAAAABBBBAAABABBBBAABBAABABBAABABBABBBABBAAAABAAAABABBBA");
//        sequenceTransformation("01000001100111000000110101100101010011011111000101000100111001010010101000110101110110011101101100111 BABABABAABABBABAABBAABBABBBAAAABBBAAABAAABBABABBBBBBBAABAAABBBBBBAABABBBBBAAABBABBBBABABBABAAAAABAABBBAAA");
//        sequenceTransformation("100000100101100001111100001000000001100011101001100111101110001110100010010000101011101100110011101100011111101011111000000001110110110011110110111 BBBBBBAAAAAAAAAAAAAAAAAAAAAAAABAAAABBBBBBBBAAAAAAAAAAAAAAAAAAAAABBBAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAABBBBBBBBAABBBBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAABBBBAAABBBAAAAAAAAAAAAAAAAAABBBAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBAAABBAAAAAAAAAAABBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBAAAAABBBAAAAAABBBBBBBBAAAAABBBBBBBBBBAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        sequenceTransformation("01001 ABBBAB");
//        sequenceTransformation("1 BBBBBBAAAAAA");
//        sequenceTransformation("001011010010000111010111001001010001100011001100111000111000010010100011010100000011 BAAAABBABAABABBBABAABBBABAABAAABAAABBAAAABAABBBABABBBAABBBBBBAAABAAAAAAABABBAABBBABBABABBBBAABABAAABBABBBBBABBBBAAAABABAAABAABAAABABBABABBABABBBAABABBBB");
//        sequenceTransformation("01010110001110111000110010100010110010011010110001001100111110000000000000110001100100001011001000101101001100110100011 BAABBABAAAAABAABAAABABAAAABBAAABABBBBBABBBABBBABBABBBABBABBAABBAABABAABBBABBBABBABBAABAABAAABBAAABABABABAABAABBAABABAAA");
//        sequenceTransformation("10 BBBBBAAAAAAA");
//        sequenceTransformation("01 BBBBBAAAAAAA");
//        sequenceTransformation("101110000001111010110011011000000011011100111110100111101000011100010111111110010010100101101101101000111011010001011001110101010110 AABBAAABABBBAABAAAABBABBBBABBABABBAAABABABBBBBBBABBBAAABABAAAAAABABAAAABBBBBBAABBBABBBBBBAABBBABBBBBABBABBAAAABABBBBABBBAAABBBBABBBB");
//        sequenceTransformation("111011001001111110001000111101000011111111110100010110000100011110001000001100101011101110010101100000100100001 AAAAAABBBBBBBAAABBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBABBBBAAAAAAAAAAAAAAAAAAAAABBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAABBAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAABAAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAABBBBBAAAAAAAAAAAAAABBBBB");
//        sequenceTransformation("001001010101010111111110111111110000010000101101101101101001001001101 AAAAAAAAAABBAAAAAAAAAAAAABAAABBAAAAAAAAABBBAAAABBBBBBAAABBBBAAAAAAAAAAAAAAAABABBBBBBAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAABBBBBAAABBAAAAAAAABBBBBBAAAABBABBAAAAAAAAAAAAAABBBBAAAAAAABBBBBBAAAAAB");
//        sequenceTransformation("01111101111100101001110111101111101101110111001000001101000010010000010100011110110100110100101011001100000101000001010110011101 ABBBBAAAAAABBBBBBBAAAAAAAAAAAAAABBBBAAAAABAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAABBBAAAAAAAAAABBBABBBBBBBAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAABBBBBBAAAAAAAAAAAAAAABAABBBBBBAAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAABBBBBAAAAAABAAAAAAAABBBBAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAABBAAAAAAAABBBBAAAAAAAAAAAAAABBBBBBBBBBAAAAAAB");
//        sequenceTransformation("100001111001101100001100010000111000111111011011011110110011111001011000010011100011100011111101 BAAABAABBBAAAAAAAABAAABBBBABBABBBABABBABABBBBBBAAAAAAAABAABBBAABBABBAAAAABAABAABBBBABBBABABAAABBAAABABAABABBBBAABBBABABA");
//        sequenceTransformation("1111100010111101111 BBBAABBAABAAABBAAAB");
//        sequenceTransformation("0111010011111110110000011000001100111101011010111000010001010100 ABAABBABBABBBBBABBBBABBABBBBBABAABAAAABBBABBABABBABABABBABBABBBBBBBBABABAAABBBBBBBAAAABAABAABABBABABBBBAAABBABABABABABAABAAAABBBBBAABBBBBBBA");
//        sequenceTransformation("1000010110011000110100110010000110110111001011010100100 AAAAAAAAAAAAAAAAAAAAAAAAAABBBAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBAAAAAAAAAAABBBBBAAAABBBAAAABBBBABBAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAA");
//        sequenceTransformation("0010000010001101000110000101111111111110101001101011101010100010011000010110100000010000001000110011100001111110001100101001001101110 BABABAAABAABABABAAABBBBBABAAABBAABAABBABBABBABAAABBAAABAABBABBAAABBABBABABBAAABAAABBBBABABBBABABBAAAAABBABBAABBAAAABBBAAABBAABABBAAABBAAAAAA");
//        sequenceTransformation("010011010001110100101111111101001101010000100011111000000011100010000101010100011111101101100010011000100100111001001011110101110000 BABBBAABABBBAAABBBABBAAAABBABAAAABABBBBBBABAAAABAAAABBBBBBABBABAABBBABABAAAABAAAAAAAABABABABBBBABAAAABBABBAABABBBAAAABAABAABAABABBBABBABAABBABB");
//        sequenceTransformation("000101001011111101100000110111011001011111000100000010001111010100010101010000000001010011101011000100001010111100010011001100111101110 BABABBBABBAAAAABBABABBBAAABABBAAABBAAAAABABABBBBBAAAABBAAAAABBBBABBABBAAABAAABABABBABBABAABABBAABAAAAABABAABBAAAAAABAAABABABBBAABBABBABABABAAABBABAAABBABBBAABAAABBAAAAAABAABAAABBBAAABBAAABBBBBBBABBBAABAAABAABBBBBABAAABBBAABAAABABBBBB");
//        sequenceTransformation("1 B");
//        sequenceTransformation("1100111000110011000001001011110010110111010100001001101101010110100111011010010101000100001100000011001110100101001010011001100101 AAAAAAAAAAABBBBBAABBBBAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBABBBBAAAAAAAABBBBBAAAAAAABAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAAAAAAAAAABBAAAAAABBBBBAAAAAAAAAAABBAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAABBBAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBABAAAAAABBBBAAAAAAAAAAAAAAAABBBBBAABBBAAAAAAAAAAAABBBAAAAAAAAAAABBBBBBAAAAABBAAAAAAAAAA");
//        sequenceTransformation("00101110111111000110110011001100010001011000011000101 AABABAAABBBAABBAABAABAABAAAABBAAAABBBBAABAABABBBAAABA");
//        sequenceTransformation("01100000000101111010100100100001111000101011100 BABAABAAABBAABAAAAABBABBBABAAAABBBBBBBBBBAAABAABBBAABBBAABBAAB");
//        sequenceTransformation("00110101110001100001101000011100000111110011011010001011001 AAAABBBBBAAABAAAABBBAABBBABBAAAAABBBBBAABBABBBAAAABBBABBABABB");
//        sequenceTransformation("0110111111001110001001000000011010011101011010000010011110010101001000100110011101111110001110010101001 AAAAABBBBBBAAAAAAAAAABBBBBBBBBBBBAAAAAAAAAAAABBBBBAAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAAAAAAAABBBAAABAAAAAAAABBAABBBBBBAAAABBAAAABBBBBBBAAABBAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAABABBBBBBAAAAABBBBBAAAAAABBBBBBAAAAAABBBAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB");

    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        List<String> lines = new LinkedList<>();
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                sequenceTransformation(fileLine);
                lines.add(fileLine);
            }
        }
//        for (String line : lines) {
//            System.out.println(line);
//        }
    }

    public static void sequenceTransformation(String fileLine) {
        int pos = fileLine.indexOf(' ');
        digits = fileLine.substring(0, pos);
        letters = fileLine.substring(pos + 1, fileLine.length());
        //
//        System.out.println(fileLine + " " + (checkSequence(0, 0) ? "Yes" : "No"));
//        System.out.println(fileLine);
        haltFlag = false;
        System.out.println(checkSequence(0, 0) ? "Yes" : "No");
    }

    private static boolean checkSequence(int digitIndex, int letterIndex) {
//        System.out.println(digits.substring(0, digitIndex) + " - " + letters.substring(0, letterIndex));
        // Let's do quick check for the remaining data
        if (digits.length() - digitIndex > letters.length() - letterIndex) {
            // more digits than remaining letters?
            return false;
        } else if (digits.length() - digitIndex == letters.length() - letterIndex) {
            // equal size, everything should fit or fail
            return isAllRemainingCharacterFits();
        }
        // Quick check not applicable... Let's go on the hard way...
        if (digitIndex < digits.length() && letterIndex < letters.length()) {
            // not finished yet..
            char expectedSequenceChar = letters.charAt(letterIndex);
            while (letterIndex < letters.length() && !haltFlag) {
                if (isApply(digitIndex, letterIndex, expectedSequenceChar)) {
                    if (checkSequence(digitIndex + 1, letterIndex + 1)) {
                        if (digitIndex + 1 == digits.length()) {
                            while (letterIndex < letters.length()) {
                                if (letters.charAt(letterIndex) != expectedSequenceChar) {
                                    haltFlag = true;
                                    return false;
                                }
                                letterIndex++;
                            }
                        }
                        return true;
                    }
                } else {
                    return false;
                }
                letterIndex++;
            }
            //
        }
        return digitIndex == digits.length();
    }

    private static boolean isAllRemainingCharacterFits() {
        for (int i = 0; i < digits.length(); i++) {
            if (!isApply(i, i, letters.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private static boolean isApply(int digitIndex, int sequenceIndex, char sequenceChar) {
        char digit = digits.charAt(digitIndex);
        char letter = letters.charAt(sequenceIndex);
        return (digit == '0' && letter == 'A') || (letter == sequenceChar && digit == '1' && (letter == 'A' || letter == 'B'));
    }
}