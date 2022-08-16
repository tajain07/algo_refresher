package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    //Root Left  Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<TreeNode> inorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        List<TreeNode> order = new ArrayList<>();
        if (useRecursive)
            inorderTraversalRec(tree.root, order);
        else {
            //inorderTraversalIterative_code1(tree.root, order);
            inorderTraversalIterative_code2(tree.root, order);

        }
        return order;
    }

    public static List<TreeNode> inorderTraversal(TreeNode root, boolean useRecursive) {
        List<TreeNode> order = new ArrayList<>();
        if (useRecursive)
            inorderTraversalRec(root, order);
        else {
            //inorderTraversalIterative_code1(tree.root, order);
            inorderTraversalIterative_code2(root, order);
        }
        return order;
    }


    public static void printInorderTraversal(TreeNode root, boolean useRecursive) {
        System.out.printf("\nInorder:  ");
        List<TreeNode> order = inorderTraversal(root, useRecursive);
        for (TreeNode node : order) {
            System.out.printf("%d, ", node.val);
        }
    }


    public static void printInorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        System.out.printf("\nInorder:  ");
        List<TreeNode> order = inorderTraversal(tree, useRecursive);
        for (TreeNode node : order) {
            System.out.printf("%d, ", node.val);
        }
    }

    private static void inorderTraversalRec(TreeNode treeNode, List<TreeNode> order) {
        if (treeNode == null) {
            return;
        }
        inorderTraversalRec(treeNode.left, order);
        order.add(treeNode);
        inorderTraversalRec(treeNode.right, order);

    }


    private static void inorderTraversalIterative_code2(TreeNode treeNode, List<TreeNode> order) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = treeNode;
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            order.add(curr);

            curr = curr.right;
        }
    }

    private static void inorderTraversalIterative_code1(TreeNode treeNode, List<Integer> order) {

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                treeNode = stack.pop();
                order.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

}
