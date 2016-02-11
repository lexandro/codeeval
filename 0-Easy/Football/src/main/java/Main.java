import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static final int MAX_TEAMS = 7;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).forEach(Main::notSoClever);
    }

    protected static void notSoClever(String fileLine) {
        String[] countriesData = fileLine.split("\\|");
        //
        Map<Integer, List<Integer>> teamFansLists = extractFanData(countriesData);
        showResults(teamFansLists);
    }

    private static Map<Integer, List<Integer>> extractFanData(String[] countriesData) {
        Map<Integer, List<Integer>> teamFansLists = new HashMap<>();
        for (Integer countryId = 0; countryId < countriesData.length; countryId++) {
            String[] fansInCountries = countriesData[countryId].trim().split(" ");
            for (String fansInCountryString : fansInCountries) {
                Integer teamIdInCountry = Integer.parseInt(fansInCountryString);
                if (teamFansLists.get(teamIdInCountry) == null) {
                    List<Integer> fanList = new LinkedList<>();
                    fanList.add(countryId + 1);
                    teamFansLists.put(teamIdInCountry, fanList);
                } else {
                    teamFansLists.get(teamIdInCountry).add(countryId + 1);
                }
            }
        }
        return teamFansLists;
    }

    private static void showResults(Map<Integer, List<Integer>> teamFansLists) {
        ArrayList<Integer> sortedTeamIds = new ArrayList<>(teamFansLists.keySet());
        Collections.sort(sortedTeamIds);
        StringBuilder result = new StringBuilder();

        for (Integer teamId : sortedTeamIds) {
            result.append(teamId).append(':');
            String prefix = "";
            for (Integer countryId : teamFansLists.get(teamId)) {
                result.append(prefix).append(countryId);
                prefix = ",";
            }
            result.append("; ");
        }
        System.out.println(result);
    }
}