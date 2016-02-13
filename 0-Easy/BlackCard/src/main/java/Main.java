import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).forEach(Main::blackCard);
    }

    private static void blackCard(String fileLine) {
        String[] elements = fileLine.split("\\|");
        int steps = Integer.parseInt(elements[1].trim());
        String[] players = elements[0].split(" ");
        //
        List<String> playersList = convertPlayerArrayToLinkedList(players);
        //
        while (playersList.size() > 1) {
            Iterator<String> playersIterator = playersList.iterator();
            for (int count = 0; count < steps; count++) {
                if (!playersIterator.hasNext()) {
                    playersIterator = playersList.iterator();
                }
                playersIterator.next();
            }
            playersIterator.remove();
        }
        System.out.println(playersList.get(0));

    }

    private static List<String> convertPlayerArrayToLinkedList(String[] players) {
        List<String> playersList = new LinkedList<>();
        Collections.addAll(playersList, players);
        return playersList;
    }

}