package tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    //Left Root Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<Integer> levelOrderTraversal(BinarySearchTree tree) {
        List<Integer> order = new ArrayList<>();
        levelOrderTraversal(tree.root, order);
        return order;
    }

    public static void printLevelOrderTraversal(BinarySearchTree tree) {
        System.out.printf("\nLevel Order: ");
        List<Integer> order = levelOrderTraversal(tree);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void levelOrderTraversal(Node node, List<Integer> order) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            final Node element = queue.poll();
            order.add(element.data);
            if (element.left != null)
                queue.add(element.left);
            if (element.right != null)
                queue.add(element.right);
        }

    }

}
