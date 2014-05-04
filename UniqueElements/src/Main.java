import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static final String SEPARATOR = ",";

    public static void main(String[] args) throws IOException {
        // setup input
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            {
                Set<Integer> sortedNumbersSet = toIntSet(fileLine);
                System.out.println(toLine(sortedNumbersSet));
            }
        }
    }

    private static SortedSet<Integer> toIntSet(String fileLine) {
        SortedSet<Integer> result = new TreeSet<Integer>();
        String[] lineItems = fileLine.split(",");
        for (String lineItem : lineItems) {
            result.add(Integer.valueOf(lineItem));
        }
        return result;
    }

    private static String toLine(Set<Integer> sortedNumbersSet) {
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = sortedNumbersSet.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(SEPARATOR);
            }
        }
        return result.toString();
    }
}
