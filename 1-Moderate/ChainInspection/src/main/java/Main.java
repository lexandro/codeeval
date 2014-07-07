import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                chainInspection(fileLine);
            }
        }
    }

    // java implementation of http://en.wikipedia.org/wiki/Polish_notation solution
    private static void chainInspection(String fileLine) {
        String[] chainItems = fileLine.split(";");
        Map<String, NodeItem> chain = toChainMap(chainItems);
        //
        int count = 0;
        if (!chain.isEmpty()) {
            NodeItem nodeItem = chain.get("BEGIN");
            nodeItem.visited = true;
            count++;
            //
            while (!nodeItem.next.equals("END")) {
                nodeItem = chain.get(nodeItem.next);
                if (nodeItem.visited) {
                    break;
                } else {
                    nodeItem.visited = true;
                    count++;
                }
            }
        }
        //
        if (chain.isEmpty() || count != chain.size()) {
            System.out.println("BAD");
        } else {
            System.out.println("GOOD");
        }
    }

    private static Map<String, NodeItem> toChainMap(String[] chainItems) {
        Map<String, NodeItem> result = new HashMap<>(chainItems.length);
        boolean begin = false;
        boolean end = false;
        //
        for (String chainItem : chainItems) {
            NodeItem nodeItem = new NodeItem(chainItem);
            result.put(nodeItem.value, nodeItem);
            // speed up evaluations with pre-checking
            if (!begin && nodeItem.value.charAt(0) == 'B') {
                begin = true;
            }
            //
            if (!end && nodeItem.next.charAt(0) == 'E') {
                end = true;
            }
        }
        // the chain is surely unfinished
        if (!(begin && end)) {
            result = Collections.emptyMap();
        }
        return result;
    }

    public static final class NodeItem {
        final String next;
        final String value;
        boolean visited;

        public NodeItem(String chainItem) {
            // avoiding regex, to perform better
            int dividerPos = chainItem.indexOf('-');
            this.value = chainItem.substring(0, dividerPos);
            this.next = chainItem.substring(dividerPos + 1, chainItem.length());
        }
    }
}