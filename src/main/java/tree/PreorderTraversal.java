package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    //Left Root Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<Integer> preorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        List<Integer> order = new ArrayList<>();
        if (useRecursive)
            preorderTraversalRec(tree.root, order);
        else
            preorderTraversalIterative(tree.root, order);
        return order;
    }

    public static void printPreorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        System.out.printf("\nPreorder: ");
        List<Integer> order = preorderTraversal(tree, useRecursive);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void preorderTraversalRec(TreeNode treeNode, List<Integer> order) {
        if (treeNode == null) {
            return;
        }
        order.add(treeNode.val);
        preorderTraversalRec(treeNode.left, order);
        preorderTraversalRec(treeNode.right, order);

    }

    //Left Root Right
    //Time Complexity - O(N)
    //Space complexity - O(N) => O(Height of tree)
    private static void preorderTraversalIterative(TreeNode treeNode, List<Integer> order) {

        if (treeNode == null)
            return;

        //LIFO
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);

        while (!stack.isEmpty()) {
            final TreeNode root = stack.pop();
            order.add(root.val);

            //Because LIFO put right first
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }
        }

    }
}
