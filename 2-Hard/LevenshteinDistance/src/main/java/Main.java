import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Dictionary dictionary = new Dictionary();
    //
    private static List<Node> wordNodes = new LinkedList<>();

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
//        Node node1 = null;
//        Node node2 = null;

//        node1 = new Node("abcde");
//        node2 = new Node("abcee");
//        System.out.println(node1.isFriend(node2));

//        node1 = new Node("abcde");
//        node2 = new Node("abcede");
//        System.out.println(node1.isFriend(node2));

//        node1 = new Node("hello");
//        node2 = new Node("aahed");
//        System.out.println(node1.isFriend(node2));

    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        // Load wordlist
        while ((fileLine = reader.readLine()) != null) {
            if (fileLine.charAt(0) != 'E') {
                wordNodes.add(new Node(fileLine));
            } else {
                break;
            }
        }
        // Second part, load dictionary for comparison
        while ((fileLine = reader.readLine()) != null) {
            dictionary.addNode(new Node(fileLine));
        }
        //
        listLevenshteinDistances();
    }

    private static void listLevenshteinDistances() {
        //
        for (Node wordNode : wordNodes) {
            Set<Node> friends = dictionary.findFriendsFor(wordNode);
            wordNode.addFriends(friends);
            //
            exploreSocialNetworkFor(friends, dictionary);
            System.out.println(socialNetworkSizeOf(wordNode, new HashSet<Node>()));
        }
    }

    private static int socialNetworkSizeOf(Node wordNode, Set<Node> socialNetworkedNodes) {
        for (Node friend : wordNode.friends) {
            if (!socialNetworkedNodes.contains(friend)) {
                socialNetworkedNodes.add(friend);
                socialNetworkSizeOf(friend, socialNetworkedNodes);
            }
        }
        return socialNetworkedNodes.size();
    }

    private static void exploreSocialNetworkFor(Set<Node> wordNodes, Dictionary dictionary) {
        for (Node wordNode : wordNodes) {
            if (!wordNode.processed) {
                wordNode.processed = true;
                Set<Node> friends = dictionary.findFriendsFor(wordNode);
                wordNode.addFriends(friends);
                //
                exploreSocialNetworkFor(friends, dictionary);
            }
        }
    }
}

class Dictionary {
    // list words by their length
    LinkedList<Node>[] nodes = new LinkedList[25];

    public void addNode(Node node) {
        int wordLength = node.word.length();
        ensureCapacity(wordLength);
        if (nodes[wordLength] == null) {
            nodes[wordLength] = new LinkedList<>();
        }
        nodes[wordLength].add(node);
    }

    public Set<Node> findFriendsFor(Node node) {
        Set<Node> result = new HashSet<>();
        int wordLength = node.word.length();
        //
        int i = wordLength > 1 ? wordLength - 1 : 0;
        //
        while (i < wordLength + 2 && i <= nodes.length) {
            if (nodes[i] != null) {
                for (Node dictNode : nodes[i]) {
//                    int dist = levenshteinDistance(node.word, dictNode.word);
                    if (node.isFriend(dictNode)) {
                        result.add(dictNode);
                    }
                }
            }
            i++;
        }
        return result;
    }

    // not necessary for the current dataset, but I can't resist to implement hehehe
    private void ensureCapacity(int requiredLength) {
        if (nodes.length <= requiredLength) {
            nodes = Arrays.copyOf(nodes, requiredLength + 1);
        }
    }
}

class Node {
    public String word;
    public Set<Node> friends;
    public boolean processed;

    public Node(String word) {
        this.word = word;
    }

    public void addFriends(Set<Node> friends) {
        ensureFriendsListInitialized();
        this.friends.addAll(friends);
    }

    // very quick comparison for only one char difference
    // TODO test with aaaa|aaa, |baaa|aaa, aaab|aaa
    public boolean isFriend(Node node) {
        //
        if (this == node) {
            return false;
        }
        //
        String word1 = this.word;
        String word2 = node.word;
        // default difference starts with length comparison
        int difference = abs(word1.length() - word2.length());
        if (difference < 2) {
            return calculateDifference(word1, word2) < 2;
        } else {
            return false;
        }
    }


    private int calculateDifference(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return calculateForDifferentSize(word1, word2);
        } else {
            return calculateForSameSize(word1, word2);
        }
    }

    private int calculateForDifferentSize(String word1, String word2) {
        if (word1.length() > word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        int i = 0;
        int difference = 0;
        while (i < word1.length()) {
            if (word1.charAt(i) != word2.charAt(i + difference)) {
                difference++;
                if (difference > 1) {
                    break;
                }
            } else {
                i++;
            }
        }
        return difference;
    }

    private int calculateForSameSize(String word1, String word2) {
        int i = 0;
        int difference = 0;
        while (i < word1.length()) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
                if (difference > 1) {
                    break;
                }
            }
            i++;
        }
        return difference;
    }

    private void ensureFriendsListInitialized() {
        if (friends == null) {
            friends = new HashSet<>();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return !(word != null ? !word.equals(node.word) : node.word != null);
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "word='" + word + '\'' +
                '}';
    }
}
