package tree;

// @formatter:off

/**
 *        10
 *        / \
 *       /   \
 *      /     \
 *     5      15
 *    / \     / \
 *   2   5   /   \
 *  /       13   22
 * 1         \
 *           14
 */

// @formatter:on
public class FindClosestInBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(5);
        bst.insert(13);
        bst.insert(22);
        bst.insert(1);
        bst.insert(14);

        int num = 9;
        TreeNode closestNum = findClosestWrong(bst.root, num);
        System.out.println("closestNum " + closestNum.val);

        int closestNodeVal = findClosestRecursive(bst.root, num);
        System.out.println("closestNodeVal " + closestNodeVal);


        closestNodeVal = findClosestIterative(bst.root, num);
        System.out.println("closestNodeVal " + closestNodeVal);
    }

    //TC - Average : O(logN) | Worst - O(N)
    //SC -  For Iterative O(1)
    private static int findClosestIterative(TreeNode root, int target) {
        TreeNode currentNode = root;
        int closest = Integer.MAX_VALUE;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.val))
                closest = currentNode.val;
            if (target < currentNode.val)
                currentNode = currentNode.left;
            else if (target > currentNode.val)
                currentNode = currentNode.right;
            else
                break;
        }
        return closest;
    }

    //TC - Average : O(logN) | Worst - O(N)
    //SC - For Recursive same as TC
    //     For Iterative O(1)
    private static int findClosestRecursive(TreeNode root, int num) {
        return findClosestRecursiveHelper(root, num, Integer.MAX_VALUE);

    }

    private static int findClosestRecursiveHelper(TreeNode root, int target, int closest) {
        if (root == null)
            return closest;
        if (Math.abs(target - closest) > Math.abs(target - root.val))
            closest = root.val;
        if (target < root.val)
            return findClosestRecursiveHelper(root.left, target, closest);
        else if (target > root.val)
            return findClosestRecursiveHelper(root.right, target, closest);
        else
            return closest;
    }

    /**
     * Wrong algo -- doesn't give correct answer if node is closest to root node
     *
     * @param root
     * @param num
     * @return
     */
    private static TreeNode findClosestWrong(TreeNode root, int num) {
        if (root == null)
            return null;


        if (num == root.val)
            return root;
        if (num < root.val) {
            if (root.left == null)
                return root;
            else
                return findClosestWrong(root.left, num);
        } else {
            if (root.right == null)
                return root;
            else
                return findClosestWrong(root.right, num);
        }

    }
}
