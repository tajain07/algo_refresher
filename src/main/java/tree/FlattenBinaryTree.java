package tree;

import com.sun.source.tree.Tree;

import java.util.List;

// @formatter:off

/**
 *       1
 *      / \
 *     /   \
 *    /     \
 *   2       3
 *  / \     /
 * 4   5   6
 *    / \
 *   7   8
 *
 */

// @formatter:on
public class FlattenBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(0);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        TreeNode nodesAtDistanceK = flattenBinaryTree_Using_Inorder_Traversal(root);
        printFlattenTree(nodesAtDistanceK);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(0);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        nodesAtDistanceK = flattenBinaryTreel(root);
        printFlattenTree(nodesAtDistanceK);

    }


    private static TreeNode flattenBinaryTreel(TreeNode root) {
        final TreeNode[] treeNodes = flattenTree(root);
        return treeNodes[0];
    }

    // Connect Left's right and Right's left
    // Return left's left and right's right
    // TC - O(n) time
    // SC - O(d) space | d is depth of tree | if balanced d = logN
    private static TreeNode[] flattenTree(TreeNode node) {
        TreeNode leftMost, rightMost;
        if (node.left == null)
            leftMost = node;
        else {
            TreeNode[] leftSubtreeLeftMost_RightMost_Pair = flattenTree(node.left);
            connectNodes(leftSubtreeLeftMost_RightMost_Pair[1], node);
            leftMost = leftSubtreeLeftMost_RightMost_Pair[0];
        }
        if (node.right == null)
            rightMost = node;
        else {
            TreeNode[] rightSubtreeLeftMost_RightMost_Pair = flattenTree(node.right);
            connectNodes(node, rightSubtreeLeftMost_RightMost_Pair[0]);
            rightMost = rightSubtreeLeftMost_RightMost_Pair[1];
        }


        return new TreeNode[]{leftMost, rightMost};

    }


    /**
     * This approach uses Inorder traversal and then modifies the left and right pointer
     * O(n) time | O(n) space
     */
    private static TreeNode flattenBinaryTree_Using_Inorder_Traversal(TreeNode root) {
        final List<TreeNode> inOrderNodes = InorderTraversal.inorderTraversal(root, true);
        for (int i = 0; i < inOrderNodes.size() - 1; i++) {
            final TreeNode leftNode = inOrderNodes.get(i);
            final TreeNode rightNode = inOrderNodes.get(i + 1);
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        return inOrderNodes.get(0);

    }

    private static void printFlattenTree(TreeNode root) {
        TreeNode nodesAtDistanceKCopy = root;
        while (nodesAtDistanceKCopy != null) {
            System.out.print(nodesAtDistanceKCopy.val + "--");
            nodesAtDistanceKCopy = nodesAtDistanceKCopy.right;
        }
        System.out.println();
    }

    private static void connectNodes(TreeNode left, TreeNode right) {
        left.right = right;
        right.left = left;

    }

}
