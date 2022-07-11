package tree;

import java.sql.Array;
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

    private static void preorderTraversalRec(Node node, List<Integer> order) {
        if (node == null) {
            return;
        }
        order.add(node.data);
        preorderTraversalRec(node.left, order);
        preorderTraversalRec(node.right, order);

    }

    //Left Root Right
    //Time Complexity - O(N)
    //Space complexity - O(N) => O(Height of tree)
    private static void preorderTraversalIterative(Node node, List<Integer> order) {

        if (node == null)
            return;

        //LIFO
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            final Node root = stack.pop();
            order.add(root.data);

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
