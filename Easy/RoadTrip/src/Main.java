import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
            roadTrip(fileLine);
        }
    }

    private static void roadTrip(String fileLine) {
        String[] cityDistances = fileLine.split(";");
        int[] distances = sortByDistance(cityDistances);
        //
        int distance = distances[0];
        StringBuilder result = new StringBuilder("" + distance);
        for (int i = 1; i < distances.length; i++) {
            result.append(",").append(distances[i] - distance);
            distance = distances[i];
        }
        System.out.println(result.toString());
    }

    private static int[] sortByDistance(String[] cityDistances) {
        int[] distances = new int[cityDistances.length];
        //
        for (int i = 0; i < cityDistances.length; i++) {
            int commaPos = cityDistances[i].indexOf(",");
            Integer distance = Integer.valueOf(cityDistances[i].substring(commaPos + 1, cityDistances[i].length()));
            distances[i] = distance;
        }
        Arrays.sort(distances);
        return distances;
    }
}