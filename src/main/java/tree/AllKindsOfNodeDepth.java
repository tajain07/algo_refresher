package tree;

import java.util.ArrayList;
import java.util.List;

public class AllKindsOfNodeDepth {
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

        int totalDepth = allKindsOfNodeDepths(root);
        System.out.println("totalDepth " + totalDepth);
    }

    private static int allKindsOfNodeDepths(TreeNode root) {
        if (root == null)
            return 0;

        int[] answer = allKindsOfNodeDepthsHelper(root);
        return answer[0];
    }

    //int[2] -> int[0] => sum of depths, int[1] => number of nodes
    private static int[] allKindsOfNodeDepthsHelper(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{0, 1};
        }

        int[] leftAns = allKindsOfNodeDepthsHelper(root.left);
        int[] rightAns = allKindsOfNodeDepthsHelper(root.right);

        final int sumOfDepths = leftAns[0] + rightAns[0] + leftAns[1] + rightAns[1];
        final int numberOfNodes = leftAns[1] + rightAns[1] + 1;
        return new int[]{sumOfDepths, numberOfNodes};


    }
}
