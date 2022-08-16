package tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSums_BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);

        Integer[] sums = branchSums(root);
        System.out.println("Sums " + Arrays.toString(sums));

    }

    //Time Complexity = O(N)
    //Space Complexity = O(N)
    static Integer[] branchSums(TreeNode root) {
        List<Integer> sums = new ArrayList<>();

        calculateBranchSums(root, 0, sums);

        Integer[] sumsResult = new Integer[sums.size()];
        sums.toArray(sumsResult);

        return sumsResult;
    }

    private static void calculateBranchSums(TreeNode root, int runningSum, List<Integer> sums) {
        if (root == null) return;

        final int newRunningSum = runningSum + root.val;

        if (root.left == null && root.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(root.left, newRunningSum, sums);
        calculateBranchSums(root.right, newRunningSum, sums);
    }
}
