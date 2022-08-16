package tree;

import javafx.util.Pair;
import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Depth of Binary Tree
 */
public class MaxiumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(12);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(16);
        bst.insert(14);
        bst.insert(18);
        bst.insert(19);

        int depth = maxDepth(bst.root);
        System.out.println("max depth " + depth);

        depth = maxDepth_LevelOrder(bst.root);
        System.out.println("maxDepth_LevelOrder " + depth);
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public static int maxDepth_LevelOrder(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int height = 0;
        while (!queue.isEmpty()) {
            final Pair<TreeNode, Integer> element = queue.poll();
            final TreeNode node = element.getKey();
            final int value = element.getValue();
            height = Math.max(height, value);
            if (node.left != null) queue.add(new Pair<>(node.left, value + 1));
            if (node.right != null) queue.add(new Pair<>(node.right, value + 1));
        }

        return height;
    }

}
