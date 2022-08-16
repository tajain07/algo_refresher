package tree;


import java.util.ArrayList;
import java.util.List;

// @formatter:off
/**
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *        / \
 *       7   8
 */


// @formatter:on
public class NodesAtADistanceK_DepthFirstSearch_LC30 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        final List<Integer> nodesAtDistanceK = distanceK_DFS(root, 3, 2);
        System.out.println("nodesAtDistanceK " + nodesAtDistanceK);
    }

    private static List<Integer> distanceK_DFS(TreeNode root, int target, int k) {
        List<Integer> nodesDistanceK = new ArrayList<>();

        findDistanceFromNodeToTarget(root, target, k, nodesDistanceK);
        return nodesDistanceK;
    }

    private static int findDistanceFromNodeToTarget(TreeNode root, int target, int k, List<Integer> nodesDistanceK) {

        if (root == null)
            return -1;

        if (root.val == target) {
            addSubtreeNodesAtDistanceK(root, 0, k, nodesDistanceK);
            return 1;
        }

        int leftDistance = findDistanceFromNodeToTarget(root.left, target, k, nodesDistanceK);
        int rightDistance = findDistanceFromNodeToTarget(root.right, target, k, nodesDistanceK);

        if (leftDistance == k || rightDistance == k)
            nodesDistanceK.add(root.val);

        if (leftDistance != -1) {
            addSubtreeNodesAtDistanceK(root.right, leftDistance + 1, k, nodesDistanceK);
            return leftDistance + 1;
        }

        if (rightDistance != -1) {
            addSubtreeNodesAtDistanceK(root.left, rightDistance + 1, k, nodesDistanceK);
            return rightDistance + 1;
        }

        return -1;
    }

    private static void addSubtreeNodesAtDistanceK(TreeNode root, int distance, int k, List<Integer> nodesDistanceK) {
        if (root == null)
            return;

        if (distance == k)
            nodesDistanceK.add(root.val);
        else {
            addSubtreeNodesAtDistanceK(root.left, distance + 1, k, nodesDistanceK);
            addSubtreeNodesAtDistanceK(root.right, distance + 1, k, nodesDistanceK);
        }
    }
}