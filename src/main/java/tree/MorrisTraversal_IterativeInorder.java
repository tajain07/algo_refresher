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
public class MorrisTraversal_IterativeInorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.right = new TreeNode(3);
        root.right.parent = root;

        root.left.left = new TreeNode(4);
        root.left.left.parent =  root.left;

        root.left.right = new TreeNode(5);
        root.left.right.parent = root.left;

        root.left.right.right = new TreeNode(6);
        root.left.right.right.parent = root.left.right;

        List<Integer> order = new ArrayList<>();
        iterativeInorderTraveral_ConstantSpace(root, order);
        System.out.println(order);

        order = new ArrayList<>();
        iterativePreorderTraveral_ConstantSpace_Algoexpert(root, order);
        System.out.println(order);


    }

    /**
     * TC - O(N)
     * SC - O(N)
     * This algorithm need parent pointer as well.
     *
     * @param root
     * @param order
     */
    private static void iterativePreorderTraveral_ConstantSpace_Algoexpert(TreeNode root, List<Integer> order) {
        TreeNode prevNode = null, currentNode = root;

        while (currentNode != null) {
            TreeNode nextNode = null;
            if (prevNode == null || prevNode == currentNode.parent) {
                if (currentNode.left != null)
                    nextNode = currentNode.left;
                else {
                    order.add(currentNode.val);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }

            } else if (prevNode == currentNode.left) {
                order.add(currentNode.val);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            prevNode = currentNode;
            currentNode = nextNode;
        }

    }


    /**
     *
     * @param root
     * @param order
     */
    private static void iterativeInorderTraveral_ConstantSpace(TreeNode root, List<Integer> order) {
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
                    curr = curr.left;
                } else {
                    prev.right = null;
                    order.add(curr.val);

                    curr = curr.right;
                }

            }
        }
    }


}
