package tree;

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

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        levelOrderTraversal(root, order);
        return order;
    }

    public static void print(TreeNode root, String customText) {
        System.out.printf("\n %s Level Order: ", customText);
        List<Integer> order = levelOrderTraversal(root);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    public static void print(BinarySearchTree tree) {
        System.out.printf("\nLevel Order: ");
        List<Integer> order = levelOrderTraversal(tree);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void levelOrderTraversal(TreeNode treeNode, List<Integer> order) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {
            final TreeNode element = queue.poll();
            order.add(element.val);
            if (element.left != null)
                queue.add(element.left);
            if (element.right != null)
                queue.add(element.right);
        }

    }

}
