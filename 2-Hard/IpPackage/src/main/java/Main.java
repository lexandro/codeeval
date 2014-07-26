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

    private static final Pattern IP_PATTERN = Pattern.compile("(\\d*)\\.(\\d*)\\.(\\d*)\\.(\\d*)");

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                ipPackage(fileLine);
            }
        }
    }

    private static void ipPackage(String fileLine) {
        String[] elements = fileLine.split(" ");
        long newSourceIp = stringIP2Decimal(elements[0]);
        long newDestinationIp = stringIP2Decimal(elements[1]);
        //
        int[] header = extractIPHeaderFrom(elements);
        setSourceIP(newSourceIp, header);
        setDestinationIP(newDestinationIp, header);
        calculateChecksumFor(header);
        for (int i : header) {
            System.out.print((i < 16 ? "0" : "") + Integer.toHexString(i) + " ");
        }
        System.out.println();

    }

    private static void calculateChecksumFor(int[] header) {
        // erase old checksum
        header[10] = 0;
        header[11] = 0;
        long sumOfValues = calculateHeaderSum(header);
        long carry = sumOfValues >> 0x10;
        sumOfValues = sumOfValues & 0xffff;
        sumOfValues += carry;
        int checksum = Long.valueOf(~sumOfValues & 0xffff).intValue();

        header[10] = checksum >> 8;
        header[11] = checksum & 0xff;

    }

    private static long calculateHeaderSum(int[] header) {
        long result = 0;
        for (int i = 0; i < header.length; i += 2) {
            result += (header[i] << 8) + header[i + 1];
        }

        return result;
    }

    private static long stringIP2Decimal(String ipAddress) {
        Matcher ipMatcher = IP_PATTERN.matcher(ipAddress);
        if (ipMatcher.matches()) {
            long result = Long.parseLong(ipMatcher.group(1), 10) << 24;
            result += Long.parseLong(ipMatcher.group(2), 10) << 16;
            result += Long.parseLong(ipMatcher.group(3), 10) << 8;
            result += Long.parseLong(ipMatcher.group(4), 10);
            return result;
        }
        return 0;
    }

    private static void setSourceIP(long newSourceIp, int[] header) {
        setIP(newSourceIp, 12, header);
    }

    private static void setDestinationIP(long newDestinationIp, int[] header) {
        setIP(newDestinationIp, 16, header);
    }

    private static void setIP(long ipAddress, int position, int[] header) {
        header[position] = Long.valueOf(ipAddress >> 24).intValue();
        header[position + 1] = Long.valueOf((ipAddress >> 16) & 255).intValue();
        header[position + 2] = Long.valueOf((ipAddress >> 8) & 255).intValue();
        header[position + 3] = Long.valueOf(ipAddress & 255).intValue();
    }

    private static int[] extractIPHeaderFrom(String[] elements) {
        int[] header = new int[20];
        for (int i = 0; i < 20; i++) {
            header[i] = Integer.parseInt(elements[i + 2], 16);
        }
        return header;
    }
}