package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    //Root Left  Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<Integer> inorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        List<Integer> order = new ArrayList<>();
        if (useRecursive)
            inorderTraversalRec(tree.root, order);
        else
            inorderTraversalIterative(tree.root, order);

        return order;
    }


    public static void printInorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        System.out.printf("\nInorder:  ");
        List<Integer> order = inorderTraversal(tree, useRecursive);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void inorderTraversalRec(Node node, List<Integer> order) {
        if (node == null) {
            return;
        }
        inorderTraversalRec(node.left, order);
        order.add(node.data);
        inorderTraversalRec(node.right, order);

    }


    private static void inorderTraversalIterative(Node node, List<Integer> order) {

        Stack<Node> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                order.add(node.data);
                node = node.right;
            }
        }
    }
}
