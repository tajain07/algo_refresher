package tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

        int[] answers = maxPathSum_approach2(root);
        System.out.println("The Max Path Sum for this tree is " + answers[1]);

    }


    //int[0] = max sum as branch
    //int[1] = max sum including root node
    public static int[] maxPathSum_approach2(TreeNode root) {
        if (root == null)
            return new int[2];

        //leftValues[0] = max sum as branch
        //leftValues[1] = max sum including root node
        final int[] leftValues = maxPathSum_approach2(root.left);
        final int[] rightValues = maxPathSum_approach2(root.right);
        final int maxChildSumAsBranch = Math.max(leftValues[0], rightValues[0]);

        int value = root.val;

        final int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsRootNode = Math.max(maxSumAsBranch, leftValues[0] + value + rightValues[0]);
        int maxPathSum = Math.max(Math.max(leftValues[1], rightValues[1]), maxSumAsRootNode);

        return new int[]{maxSumAsBranch, maxPathSum};
    }

    public static int maxPathSum(TreeNode root) {

        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    private static int maxPathDown(TreeNode root, int[] maxValue) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathDown(root.left, maxValue)); //to not return negative number instead return 0,  max with 0
        int right = Math.max(0, maxPathDown(root.right, maxValue)); //to not return negative number instead return 0,  max with 0
        maxValue[0] = Math.max(maxValue[0], left + right + root.val);
        return Math.max(left, right) + root.val;  //return the max subtree i.e. either left or rignt

    }

}
