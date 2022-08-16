package tree;

import javafx.util.Pair;

import java.util.*;

/**
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *        / \
 *       7   8
 */
public class NodesAtADistanceK_BreadthFirstSearch_LC30 {
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

        final List<Integer> nodesAtDistanceK = distanceK(root, 7, 5);
        System.out.println("nodesAtDistanceK " + nodesAtDistanceK);
    }


    // TC - O(V+E) since v=n && v+e < 2n (since e edges will be less than n or v) => O(n)
    // SC - O(N)
    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        Map<Integer, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root);

        TreeNode targetNode = null;
        final TreeNode parentOfTarget = parent_track.get(target);
        if (parentOfTarget.left != null && parentOfTarget.left.val == target)
            targetNode = parentOfTarget.left;
        else if (parentOfTarget.right != null && parentOfTarget.right.val == target)
            targetNode = parentOfTarget.right;

        List<Integer> result = new ArrayList<>();

        if (targetNode == null)
            return result;

        //Scenario 1 : Parent can come back to its child again so we need visited set. Example - Target - 3, parent - 1, Parent.right is back to 3 again
        //Scenario 2 : Child can be back to target/parent node as are adding parent node as well.
        //             Example - Node - 6, parent - 3, 3 is the node we started from.
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(targetNode, 0));
        visitedSet.add(targetNode.val);

        while (!queue.isEmpty()) {
            final Pair<TreeNode, Integer> polledElement = queue.poll();
            final TreeNode polledElementNode = polledElement.getKey();

            //visitedSet.add(polledElementNode.val);

            final int level = polledElement.getValue();

            if (level == k) {
                result.add(polledElementNode.val);
            } else {
                if (polledElementNode.left != null && !visitedSet.contains(polledElementNode.left.val)) {
                    queue.offer(new Pair<>(polledElementNode.left, level + 1));
                    visitedSet.add(polledElementNode.left.val);
                }
                if (polledElementNode.right != null && !visitedSet.contains(polledElementNode.right.val)) {
                    queue.offer(new Pair<>(polledElementNode.right, level + 1));
                    visitedSet.add(polledElementNode.right.val);
                }


                final TreeNode parentOfPolledElement = parent_track.get(polledElementNode.val);
                if (parentOfPolledElement != null && !visitedSet.contains(parentOfPolledElement.val)) {
                    queue.offer(new Pair<>(parentOfPolledElement, level + 1));
                    visitedSet.add(parentOfPolledElement.val);
                }
            }
        }

        return result;
    }

    // TC - O(V+E) since v=n && v+e < 2n (since e edges will be less than n or v) => O(n)
    private static void markParents(TreeNode root, Map<Integer, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left.val, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right.val, current);
                queue.offer(current.right);
            }
        }
    }

}
