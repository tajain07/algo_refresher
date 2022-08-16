package tree;

import javafx.util.Pair;

import java.util.Stack;

public class NodeDepths {
    static int totoalDepth = 0;

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

        int depths = nodeDepths_recursive(root);
        System.out.println("nodeDepths_recursive " + depths);

        depths = nodeDepths_iterative(root);
        System.out.println("nodeDepths_iterative " + depths);
    }


    private static int nodeDepths_iterative(TreeNode root) {
        int sumOfDepths = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            final Pair<TreeNode, Integer> nodeInfo = stack.pop();
            TreeNode node = nodeInfo.getKey();
            int depth = nodeInfo.getValue();

            if (node == null)
                continue;

            sumOfDepths += depth;
            stack.add(new Pair<>(node.left, depth + 1));
            stack.add(new Pair<>(node.right, depth + 1));
        }

        return sumOfDepths;
    }


    //Time Complexity  - O(h) [height of binary tree] --> if tree is balanced, h will be logN
    //Space Complexity - O(N)
    private static int nodeDepths_recursive(TreeNode root) {

        return calculateNodeDepths(root, 0);
    }

    private static int calculateNodeDepths(TreeNode root, int depth) {
        if (root == null)
            return 0;

        return depth + calculateNodeDepths(root.left, depth + 1) + calculateNodeDepths(root.right, depth + 1);
    }


}
