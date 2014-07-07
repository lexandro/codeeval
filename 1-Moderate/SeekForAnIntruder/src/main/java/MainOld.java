import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.valueOf;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class MainOld {

    //
    private static Pattern dottedHex = Pattern.compile("0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])");
    private static Pattern dottedDecimal = Pattern.compile("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");
    private static Pattern dottedOctal = Pattern.compile("([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})");
    private static Pattern dottedBinary = Pattern.compile("([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})");
    private static Pattern hexadecimal = Pattern.compile("0[x]([0-9a-f]{8})");
    private static Pattern decimal = Pattern.compile("([0-9]{10})");
    private static Pattern octal = Pattern.compile("([0-7]{12})");
    private static Pattern binary = Pattern.compile("([0-1]{32})");

    private static AddressEvaluator[] addressEvaluators = new AddressEvaluator[8];

    static {
        addressEvaluators[0] = new AddressEvaluator(dottedOctal, 8);
        addressEvaluators[1] = new AddressEvaluator(dottedHex, 16);
        addressEvaluators[2] = new AddressEvaluator(dottedBinary, 2);
        addressEvaluators[3] = new AddressEvaluator(binary, 2);
        addressEvaluators[4] = new AddressEvaluator(dottedDecimal, 10);
        addressEvaluators[5] = new AddressEvaluator(hexadecimal, 16);
        addressEvaluators[6] = new AddressEvaluator(octal, 8);
        addressEvaluators[7] = new AddressEvaluator(decimal, 10);

    }

    private static List<Long> ipv4AddressesAsLong = new ArrayList<>();

    public static void main(String[] args) throws Throwable {
        //
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            seekForAnIntruder(fileLine);

        }
        //
        List<Long> intruderIps = filterIntruders(ipv4AddressesAsLong);
        printIntruders(intruderIps);
    }

    private static void seekForAnIntruder(String fileContent) {
        fileContent = fileContent.toLowerCase();

        for (AddressEvaluator addressEvaluator : addressEvaluators) {
            ipv4AddressesAsLong.addAll(getAddresses(addressEvaluator.pattern.matcher(fileContent), addressEvaluator.radix));
        }
        //
    }

    private static List<Long> filterIntruders(List<Long> ipv4AddressesAsLong) {
        Collections.sort(ipv4AddressesAsLong);
        //
        List<Long> intruderIps = new LinkedList<>();
        long ip = ipv4AddressesAsLong.get(0);
        int maxAmount = 0;
        int amount = 1;
        for (int i = 1; i < ipv4AddressesAsLong.size(); i++) {
            if (ipv4AddressesAsLong.get(i) == ip) {
                amount++;
            } else {
                if (amount > maxAmount) {
                    maxAmount = amount;
                }
                amount = 1;
                ip = ipv4AddressesAsLong.get(i);
            }
        }
        //
        ip = 0;
        amount = 1;
        for (Long anIpv4AddressesAsLong : ipv4AddressesAsLong) {
            if (anIpv4AddressesAsLong == ip) {
                amount++;
            } else {
                if (amount == maxAmount) {
                    intruderIps.add(0, ip);
                }
                ip = anIpv4AddressesAsLong;
                amount = 1;
            }
        }

        return intruderIps;
    }

    // printruders hehehe...
    private static void printIntruders(List<Long> intruderIps) {
        for (Long intruderIp : intruderIps) {
            System.out.print((intruderIp >> 24) + "." + ((intruderIp & 16777215) >> 16) + "." + ((intruderIp & 65535) >> 8) + "." + (intruderIp & 255) + " ");
        }
    }

    private static List<Long> getAddresses(Matcher matcher, int radix) {
        List<Long> ipv4longs = new LinkedList<>();
        while (matcher.find()) {
            Long ip = toLongIpAddress(matcher, radix);
            if (ip != null) {
                ipv4longs.add(ip);
            }
        }
        return ipv4longs;
    }

    private static Long toLongIpAddress(Matcher matcher, int radix) {
        if (matcher.groupCount() == 1) {
            return toLongIpAddress(matcher.group(1), radix);
        } else {
            return toLongIpAddress(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), radix);
        }
    }

    private static Long toLongIpAddress(String value, int radix) {
        Long ip = valueOf(value, radix);
        return isValidIpValue(ip) ? ip : null;
    }

    private static Long toLongIpAddress(String first, String second, String third, String fourth, int radix) {
        Long ip = (valueOf(first, radix) << 24) + (valueOf(second, radix) << 16) + (valueOf(third, radix) << 8) + valueOf(fourth, radix);
        return isValidIpValue(ip) ? ip : null;
    }

    private static boolean isValidIpValue(long ipAsLong) {
        return ipAsLong >= 16777216 && ipAsLong <= 4294967294l; // 1.1.1.1 - 255.255.255.254
    }


    private static final class AddressEvaluator {
        private Pattern pattern;
        private int radix;

        private AddressEvaluator(Pattern pattern, int radix) {
            this.pattern = pattern;
            this.radix = radix;
        }
    }

}