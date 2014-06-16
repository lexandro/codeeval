import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static final TreeNode TREE = setupTree();

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static TreeNode setupTree() {
        TreeNode nodeItemLeft = new TreeNode(10);
        TreeNode nodeItemRight = new TreeNode(29);
        TreeNode ancestor = new TreeNode(20, nodeItemLeft, nodeItemRight);
        //
        nodeItemLeft = new TreeNode(3);
        nodeItemRight = ancestor;
        ancestor = new TreeNode(8, nodeItemLeft, nodeItemRight);
        //
        nodeItemLeft = ancestor;
        nodeItemRight = new TreeNode(52);
        ancestor = new TreeNode(30, nodeItemLeft, nodeItemRight);
        return ancestor;

    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                lowestCommonAncestor(fileLine);
            }
        }
    }

    // optimized for speed. No unnecessary checks and getters/setters
    private static void lowestCommonAncestor(String fileLine) {
        // String items[] = fileLine.split(" ");
        // this is faster
        int spaceIndex = fileLine.indexOf(' ', 1);
        int node1 = Integer.valueOf(fileLine.substring(0, spaceIndex));
        int node2 = Integer.valueOf(fileLine.substring(spaceIndex + 1, fileLine.length()));
        //
        TreeNode lastNode = TREE;
        TreeNode currentNode = getAncestor(TREE, node1, node2);
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = getAncestor(currentNode, node1, node2);
        }
        System.out.println(lastNode.value);
    }

    private static TreeNode getAncestor(TreeNode currentNode, int node1, int node2) {
        if (currentNode.value < node1 && currentNode.value < node2) {
            return currentNode.right;
        } else if (currentNode.value > node1 && currentNode.value > node2) {
            return currentNode.left;
        }
        return null;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode nodeItemLeft, TreeNode nodeItemRight) {
            this(value);
            left = nodeItemLeft;
            right = nodeItemRight;
        }
    }
}