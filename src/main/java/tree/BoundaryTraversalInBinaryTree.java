package tree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversalInBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(100);
        bst.insert(120);
        bst.insert(132);
        bst.insert(129);
        bst.insert(128);
        bst.insert(130);
        bst.insert(90);
        bst.insert(80);
        bst.insert(85);
        bst.insert(82);
        bst.insert(86);

        System.out.println(printBoundary(bst.root));
    }

    private static ArrayList<Integer> printBoundary(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);

        return ans;
    }

    private static void addRightBoundary(TreeNode node, ArrayList<Integer> ans) {
        ArrayList<Integer> tempList = new ArrayList<>();
        TreeNode cur = node;
        while (!isLeaf(cur)) {
            if (cur.right != null) {
                tempList.add(cur.right.val);
                cur = cur.right;
            } else {
                tempList.add(cur.left.val);
                cur = cur.left;
            }
        }

        Collections.reverse(tempList);
        ans.addAll(tempList);
    }

    private static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    private static void addLeftBoundary(TreeNode node, ArrayList<Integer> ans) {
        TreeNode cur = node;
        while (!isLeaf(cur)) {
            if (cur.left != null) {
                ans.add(cur.left.val);
                cur = cur.left;
            } else {
                ans.add(cur.right.val);
                cur = cur.right;
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
}
