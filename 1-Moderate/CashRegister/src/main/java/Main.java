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

    private static final Pattern INPUT_PATTERN = Pattern.compile("(\\d*\\.?\\d*);(\\d*\\.?\\d*)");
    //
    private static final double[] moneyValue = new double[]{
            10000d, 5000d, 2000d, 1000d, 500d, 200d, 100d, 50d, 25d, 10d, 5d, 1d
    };
    private static final String[] moneyName = new String[]{
            "ONE HUNDRED", "FIFTY", "TWENTY", "TEN", "FIVE", "TWO", "ONE",
            "HALF DOLLAR", "QUARTER", "DIME", "NICKEL", "PENNY"
    };
    // exceptional cases
    private static final StringBuilder ERROR = new StringBuilder("ERROR");
    private static final StringBuilder ZERO = new StringBuilder("ZERO");

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                cashRegister(fileLine);
            }
        }
    }

    private static void cashRegister(String fileLine) {
        Matcher m = INPUT_PATTERN.matcher(fileLine);
        if (m.find()) {
            // we are using cent based calculation
            Double purchasePriceAsDouble = Double.valueOf(m.group(1)) * 100;
            Double cashAsDouble = Double.valueOf(m.group(2)) * 100;
            // long is faster than double
            long purchasePrice = purchasePriceAsDouble.longValue();
            long cash = cashAsDouble.longValue();
            //
            //
            System.out.println(createReturnChangeAsText(cash - purchasePrice));
        }

    }

    private static StringBuilder createReturnChangeAsText(long difference) {
        if (difference > 0) {
            return calculateReturnChange(difference);
        } else if (difference < 0) {
            return ERROR;
        } else {
            return ZERO;
        }
    }

    private static StringBuilder calculateReturnChange(long returnAmount) {
        StringBuilder result = new StringBuilder();
        //
        for (int i = 0; i < moneyValue.length; i++) {
            while (returnAmount >= moneyValue[i]) {
                result.append(moneyName[i]).append(",");
                returnAmount -= moneyValue[i];
            }
        }
        //
        return result.deleteCharAt(result.length() - 1);
    }
}