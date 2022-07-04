package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - 863
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceK_LC863 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);


        List<Integer> values = distanceK(treeNode, new TreeNode(5), 2);
        System.out.println("values " + values);

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        TreeNode node = findTarget(root, target);
        System.out.println("node " + node.val);

        

        return new ArrayList<>();
    }

    private static TreeNode findTarget(TreeNode root, TreeNode target) {

        if (root == null)
            return null;

        if (root.val == target.val) {
            return root;
        }

        final TreeNode leftValue = findTarget(root.left, target);
        if (leftValue != null)
            return leftValue;

        final TreeNode rightValue = findTarget(root.right, target);
        if (rightValue != null)
            return rightValue;

        return null;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
