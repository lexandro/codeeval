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

    private static List<Node> words = new LinkedList<>();
    private static List<Node> dictionary = new LinkedList<>();
    private static Map<Node, Node> network = new HashMap<>();
    //
    private static Node[] dictArray;


    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        // Load wordlist
        while ((fileLine = reader.readLine()) != null) {
            if (fileLine.charAt(0) == 'E') {
                break;
            }
            addToWordList(fileLine);
        }
        // Second part, load dictionary for comparison
        while ((fileLine = reader.readLine()) != null) {
            addToDictionary(fileLine);
        }
        dictArray = toArray(dictionary);
        network = new HashMap<>();
        listLevenshteinDistances();
    }

    private static void listLevenshteinDistances() {
        //
        for (Node word : words) {
            System.out.println(countSocialNetworkFor(word));
        }
    }

    private static int countSocialNetworkFor(Node socialWord) {
        createNetworkFor(socialWord);
        //
        Set<Node> network = listNetworkFor(socialWord, new HashSet<Node>());
        return network.size();
    }

    private static Set<Node> listNetworkFor(Node socialWord, Set<Node> network) {
        network.addAll(socialWord.friends);
        //
        for (Node friend : socialWord.friends) {
            for (Node friendOfFriend : friend.friends) {
                if (!network.contains(friendOfFriend)) {
                    network.add(friendOfFriend);
                    listNetworkFor(friendOfFriend, network);
                }
            }
        }
        return network;
    }

    private static void createNetworkFor(Node word) {
        word.friends = collectFriendsFor(word);
        createNetworkFor(word.friends);

    }

    private static void createNetworkFor(Set<Node> words) {
        for (Node word : words) {
            if (word.friends == null) {
                for (Node dictWord : dictArray) {
                    if (areFriends(word, dictWord) && !word.equals(dictWord)) {
                        word.addFriend(dictWord);

                    }
                }
            }
        }
    }

    private static Set<Node> collectFriendsFor(Node socialWord) {
        Set<Node> result = new HashSet<>();
        for (Node dictWord : dictArray) {
            if (areFriends(socialWord, dictWord)) {
                result.add(dictWord);
            }
        }
        return result;
    }

    private static Node[] toArray(List<Node> nodeList) {
        Node[] dictArray = new Node[nodeList.size()];
        toArray(nodeList, dictArray);
        //
        return dictArray;
    }

    private static void toArray(List<Node> nodeList, Node[] dictArray) {
        int i = 0;
        for (Node node : nodeList) {
            dictArray[i++] = node;
        }
    }

    private static void addToWordList(String fileLine) {
        Node node = new Node(fileLine);
        node.type = 1;
        words.add(node);
    }

    private static void addToDictionary(String fileLine) {
        Node node = new Node(fileLine);
        dictionary.add(node);
    }

    // very quick comparison for only one char difference
    private static boolean areFriends(Node node1, Node node2) {
        String word1 = node1.word;
        String word2 = node2.word;
        // default difference starts with length comparison
        int difference = abs(word1.length() - word2.length());
        if (difference < 2) {
            int minLength = min(word1.length(), word2.length());
            int i = 0;
            while (difference < 2 && i < minLength) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    difference++;
                }
                i++;
            }
            return difference < 2;
        } else {
            return false;
        }
    }

    private static class Node {
        private String word;
        private Set<Node> friends;
        private int type;

        public Node(String word) {
            this.word = word;
        }

        public void addFriend(Node friend) {
            if (friends == null) {
                friends = new HashSet<>();
            }
            //
            friends.add(friend);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (word != null ? !word.equals(node.word) : node.word != null) return false;

            return true;
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
}