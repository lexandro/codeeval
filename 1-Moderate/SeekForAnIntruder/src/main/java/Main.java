import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.valueOf;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final int IP_4_MULTIPLIER = 256 * 256 * 256;
    private static final int IP_3_MULTIPLIER = 256 * 256;
    private static final int IP_2_MULTIPLIER = 256;
    //
    private static Pattern dottedHex = Pattern.compile("0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])\\.0[x]([0-9a-f]?[0-9a-f])");
    private static Pattern dottedDecimal = Pattern.compile("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");
    private static Pattern dottedOctal = Pattern.compile("([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})\\.([0][0-3][0-7]{2})");
    private static Pattern dottedBinary = Pattern.compile("([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})");
    private static Pattern hexadecimal = Pattern.compile("0[x]([0-9a-f]{8})");
    private static Pattern decimal = Pattern.compile("([0-9]{10})");
    private static Pattern octal = Pattern.compile("([0-7]{12})");
    private static Pattern binary = Pattern.compile("([0-1]{32})");

    private static Map<Pattern, Integer> matchers = new LinkedHashMap<>(8);

    static {
        matchers.put(dottedOctal, 8);
        matchers.put(dottedHex, 16);
        matchers.put(dottedBinary, 2);
        matchers.put(binary, 2);
        matchers.put(dottedDecimal, 10);
        matchers.put(hexadecimal, 16);
        matchers.put(octal, 8);
        matchers.put(decimal, 10);

    }

    private static List<Long> ipv4AddressesAsLong;

    public static void main(String[] args) throws Throwable {
        ipv4AddressesAsLong = new ArrayList<>();
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

        for (Map.Entry<Pattern, Integer> patternIntegerEntry : matchers.entrySet()) {
            ipv4AddressesAsLong.addAll(getAddresses(patternIntegerEntry.getKey().matcher(fileContent), patternIntegerEntry.getValue()));
        }
        //
    }

    private static List<Long> filterIntruders(List<Long> ipv4AddressesAsLong) {
        Collections.sort(ipv4AddressesAsLong);
        Collections.reverse(ipv4AddressesAsLong);
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

    private static void printIntruders(List<Long> intruderIps) {
        for (Long intruderIp : intruderIps) {
            System.out.print(intruderIp / IP_4_MULTIPLIER + "." + (intruderIp % IP_4_MULTIPLIER) / IP_3_MULTIPLIER + "." + ((intruderIp % IP_4_MULTIPLIER) % IP_3_MULTIPLIER) / IP_2_MULTIPLIER + "." + intruderIp % 256 + " ");
        }
        System.out.println();
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

    private static Long toLongIpAddress(String first, String second, String third, String fourth, int radix) {
        Long ip = valueOf(first, radix) * IP_4_MULTIPLIER + valueOf(second, radix) * IP_3_MULTIPLIER + valueOf(third, radix) * IP_2_MULTIPLIER + valueOf(fourth, radix);
        return isValidIpValue(ip) ? ip : null;
    }

    private static Long toLongIpAddress(String value, int radix) {
        Long ip = valueOf(value, radix);
        return isValidIpValue(ip) ? ip : null;
    }

    private static boolean isValidIpValue(long ipAsLong) {
        long lowestIpAsLong = 16777216;
        long highestIpAsLong = 4294967294l;
        return ipAsLong >= lowestIpAsLong && ipAsLong <= highestIpAsLong;
    }

}