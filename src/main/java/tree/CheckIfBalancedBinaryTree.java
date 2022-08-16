package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class CheckIfBalancedBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(12);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(16);
        bst.insert(14);
        bst.insert(18);
        bst.insert(19);
        bst.insert(20);

        final boolean Isbalanced = isBalanced(bst.root);
        System.out.println("Is balanced: " + Isbalanced);
    }

    public static boolean isBalanced(TreeNode root) {
        return dfsHeight_approach1(root) != -1;
    }


    // Time Complexity - O(N)
    // Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)
    public static int dfsHeight_approach1(TreeNode root) {
        if (root == null)
            return 0;

        int lh = dfsHeight_approach1(root.left);
        if (lh == -1) return -1;

        int rh = dfsHeight_approach1(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }

}
