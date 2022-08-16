package tree;

import java.util.ArrayList;
import java.util.List;

// @formatter:off

/**
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *      \
 *       6
 *
 */

// @formatter:on
public class MorrisTraversal_IterativePreorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.left.right.right = new TreeNode(6);

        List<Integer> order = new ArrayList<>();
        iterativePreorderTraveral_ConstantSpace(root, order);
        System.out.println(order);


    }


    private static void iterativePreorderTraveral_ConstantSpace(TreeNode root, List<Integer> order) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                order.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    order.add(curr.val);

                    curr = curr.left;
                } else {
                    prev.right = null;

                    curr = curr.right;
                }

            }
        }
    }


}
