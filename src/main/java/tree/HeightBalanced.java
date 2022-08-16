package tree;

import java.util.Arrays;

public class HeightBalanced {
    public static class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        //root.left.right.right.left = new TreeNode(9);

        boolean heightBalanced = isHeightBalanced(root);
        System.out.println("is tree balanced = " + heightBalanced);

    }

    //TC - O(N)
    //SC - O(h) --> h will determine the number of recursive calls
    //              if tree is skewed h can be N
    private static boolean isHeightBalanced(TreeNode root) {
        TreeInfo treeInfo = getTreeInfo(root);
        return treeInfo.isBalanced;
    }

    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null)
            return new TreeInfo(true, -1);

        TreeInfo leftSubtreeInfo = getTreeInfo(root.left);
        TreeInfo rightSubtreeInfo = getTreeInfo(root.right);

        boolean isBalanced = leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced && Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;
        int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;
        return new TreeInfo(isBalanced, height);
    }

    /*private static int height(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int lh = height(root.left);
        int rh = height(root.right);

        if (lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }*/
}
