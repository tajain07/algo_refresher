package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        LevelOrderTraversal.print(root, "Original tree");

        TreeNode invertedBinaryTreeRoot_Using_Recusion = invertBinaryTree_Recursive(root);
        LevelOrderTraversal.print(invertedBinaryTreeRoot_Using_Recusion, "Invert Binary tree Using Recursion, ");

        TreeNode invertedBinaryTreeRoot = invertBinaryTree_Iterative(root);
        LevelOrderTraversal.print(invertedBinaryTreeRoot, "Invert Binary tree Using Iterative, ");

    }

    // Time complexity - O(N)
    // Space complexity - At a particular time, there will all leaf nodes in the queue, roughly which will be
    //                   N/2 so, it's O(N/2) => O(N)
    private static TreeNode invertBinaryTree_Iterative(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode polledElement = queue.poll();
            if (polledElement == null)
                continue;

            swapChildNodes(polledElement);

            queue.add(polledElement.left);
            queue.add(polledElement.right);
        }

        return root;
    }

    // Time complexity - O(N) - we are traversing every single node
    // Space complexity - The Longest recursive call will be equal to the longest subtree i.e. depth of tree
    //                    O(d) => O(logN)
    private static TreeNode invertBinaryTree_Recursive(TreeNode root) {
        if (root == null)
            return null;

        swapChildNodes(root);
        invertBinaryTree_Recursive(root.left);
        invertBinaryTree_Recursive(root.right);
        return root;
    }

    private static void swapChildNodes(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
