package tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    //Root Left  Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<Integer> postorderTraversal(BinarySearchTree tree) {
        List<Integer> order = new ArrayList<>();
        postorderTraversalRec(tree.root, order);
        return order;
    }

    public static void printPostorderTraversal(BinarySearchTree tree) {
        System.out.printf("\nPostorder:  ");
        List<Integer> order = postorderTraversal(tree);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void postorderTraversalRec(Node node, List<Integer> order) {
        if (node == null) {
            return;
        }
        postorderTraversalRec(node.left, order);
        postorderTraversalRec(node.right, order);
        order.add(node.data);


    }
}
