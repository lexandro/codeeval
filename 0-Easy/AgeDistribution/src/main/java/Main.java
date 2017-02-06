import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static List<DistributionMapper> distributionMappers;

    public static void main(String[] args) throws IOException {
        init();
        //
        solveChallenge(args);
    }


    private static void solveChallenge(String[] args) throws IOException {
        Files.lines(Paths.get(args[0])).map(Main::ageDistribution).forEach(System.out::println);
    }

    static String ageDistribution(String fileLine) {
        int age = Integer.valueOf(fileLine, 10);
        Optional<String> result = distributionMappers
                .stream()
                .filter(m -> age >= m.minAge && age <= m.maxAge)
                .map(m -> m.result)
                .findFirst();
        return result.orElse("This program is for humans");
    }

    static void init() {
        distributionMappers = new LinkedList<>();
        distributionMappers.add(new Main.DistributionMapper(0, 2, "Still in Mama's arms"));
        distributionMappers.add(new Main.DistributionMapper(3, 4, "Preschool Maniac"));
        distributionMappers.add(new Main.DistributionMapper(5, 11, "Elementary school"));
        distributionMappers.add(new Main.DistributionMapper(12, 14, "Middle school"));
        distributionMappers.add(new Main.DistributionMapper(15, 18, "High school"));
        distributionMappers.add(new Main.DistributionMapper(19, 22, "College"));
        distributionMappers.add(new Main.DistributionMapper(23, 65, "Working for the man"));
        distributionMappers.add(new Main.DistributionMapper(66, 100, "The Golden Years"));
    }

    private static class DistributionMapper {
        int minAge;
        int maxAge;
        String result;

        DistributionMapper(int minAge, int maxAge, String result) {
            this.minAge = minAge;
            this.maxAge = maxAge;
            this.result = result;
        }
    }

}