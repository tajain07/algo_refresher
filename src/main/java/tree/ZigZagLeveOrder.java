package tree;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagLeveOrder {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(20);
        binarySearchTree.insert(15);
        binarySearchTree.insert(21);

        final List<List<Integer>> zigzag_order = zigzagLevelOrder(binarySearchTree.root);
        System.out.println("zigzag order " + zigzag_order);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return result;

        q.offer(root);
        boolean flag = true;

        while (!q.isEmpty()) {
            int levelNum = q.size();
            ArrayList<Integer> subList = new ArrayList<>(levelNum);

            for (int i = 0; i < levelNum; i++) {
                final TreeNode polledElement = q.poll();
                if (polledElement != null) {
                    if (polledElement.left != null) q.offer(polledElement.left);
                    if (polledElement.right != null) q.offer(polledElement.right);
                    if (flag) subList.add(polledElement.val);
                    else subList.add(0, polledElement.val);
                }
            }
            flag = !flag;
            result.add(subList);
        }
        return result;

    }
}
