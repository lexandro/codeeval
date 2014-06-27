import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */

public class Main {
    private static final Pattern HEXA_CODE_PATTERN = Pattern.compile("%([0-9a-fA-F][0-9a-fA-F])");
    private static final Pattern URI_PATTERN = Pattern.compile("^([a-zA-Z]+)://([a-zA-Z0-9.]+):?([0-9]+)?(.*)");
    //
    private static final String ESCAPE_CHAR = "\\";
    //
    private static final int SCHEMA_GROUP_NUMBER = 1;
    private static final int DOMAIN_GROUP_NUMBER = 2;
    private static final int PORT_GROUP_NUMBER = 3;
    private static final int RESOURCE_GROUP_NUMBER = 4;
    private static final String STANDARD_HTTP_PORT = "80";
    public static final int HEXA_RADIX = 16;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                uriComparison(fileLine);
            }
        }
    }

    private static void uriComparison(String fileLine) {
        String[] uris = fileLine.split(";");
        uris[0] = deHexifyText(uris[0]);
        uris[1] = deHexifyText(uris[1]);
        //
        Matcher matcher1 = URI_PATTERN.matcher(uris[0]);
        Matcher matcher2 = URI_PATTERN.matcher(uris[1]);
        //
        if (matcher1.find() && matcher2.find()) {
            if (isSchemaEquals(matcher1, matcher2) &&
                    isDomainEquals(matcher1) &&
                    isPortEquals(matcher1, matcher2) &&
                    isResourceEquals(matcher1, matcher2)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

        }
    }

    private static boolean isSchemaEquals(Matcher matcher1, Matcher matcher2) {
        return matcher1.group(SCHEMA_GROUP_NUMBER).equalsIgnoreCase(matcher2.group(SCHEMA_GROUP_NUMBER));
    }

    private static boolean isDomainEquals(Matcher matcher1) {
        return matcher1.group(DOMAIN_GROUP_NUMBER).equalsIgnoreCase(matcher1.group(DOMAIN_GROUP_NUMBER));
    }

    private static boolean isPortEquals(Matcher matcher1, Matcher matcher2) {
        return ((matcher1.group(PORT_GROUP_NUMBER) == null || matcher1.group(PORT_GROUP_NUMBER).equalsIgnoreCase(STANDARD_HTTP_PORT)) && (matcher2.group(PORT_GROUP_NUMBER) == null || matcher2.group(PORT_GROUP_NUMBER).equalsIgnoreCase(STANDARD_HTTP_PORT)) ||
                (matcher1.group(PORT_GROUP_NUMBER) != null && matcher1.group(PORT_GROUP_NUMBER).equalsIgnoreCase(matcher2.group(PORT_GROUP_NUMBER))));
    }

    private static boolean isResourceEquals(Matcher matcher1, Matcher matcher2) {
        return matcher1.group(RESOURCE_GROUP_NUMBER).equalsIgnoreCase(matcher2.group(RESOURCE_GROUP_NUMBER));
    }

    private static String deHexifyText(String fileLine) {
        Matcher matcher = HEXA_CODE_PATTERN.matcher(fileLine);
        String result = null;
        while (matcher.find()) {
            String replaceChar = String.valueOf((char) Integer.parseInt(matcher.group().substring(SCHEMA_GROUP_NUMBER, PORT_GROUP_NUMBER), HEXA_RADIX));
            if (replaceChar.equals(ESCAPE_CHAR)) {
                replaceChar = "\\\\";
            }
            result = matcher.replaceFirst(String.valueOf(replaceChar));
            matcher = HEXA_CODE_PATTERN.matcher(result);
        }

        return result == null ? fileLine : result;
    }

}