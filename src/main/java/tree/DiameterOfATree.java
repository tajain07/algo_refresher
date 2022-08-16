package tree;

public class DiameterOfATree {
    //static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        int[] diameter = new int[1];
        diameterOfTree(root, diameter);
        System.out.println("diameter: " + diameter[0]);
    }

    /**
     * Time complexity - O(N)
     * Space complexity - O(N)
     */
    private static int diameterOfTree(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;

        int lh = diameterOfTree(root.left, diameter);
        int rh = diameterOfTree(root.right, diameter);

        diameter[0] = Math.max(lh + rh, diameter[0]);

        return Math.max(lh, rh) + 1;

    }
}
