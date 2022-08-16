package tree;

public class KthSmallestElementInBST {
    //private static int k = 5;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);

        InorderTraversal.printInorderTraversal(binarySearchTree, true);
        System.out.println();

        //int k = 1;
        /*int[] k = new int[]{1};
        int element = kthSmallest(binarySearchTree.root, k);
        System.out.println("Kth smallest element, binarySearchTree " + element);*/

        int[] k = new int[]{1};
        TreeNode resultNode = kthSmallestUsingInorder(binarySearchTree.root, k);
        System.out.println("Kth smallest element, kthSmallestUsingPreorder " + resultNode.val);


    }

    /**
     * This is simple inorder traversal with counting. Whenever is count is equal to k that will be our answer
     */
    private static TreeNode kthSmallestUsingInorder(TreeNode root, int[] k) {
        if (root == null)
            return null;

        TreeNode left = kthSmallestUsingInorder(root.left, k);
        if (left != null)
            return left;

        k[0]--;
        if (k[0] == 0)
            return root;

        return kthSmallestUsingInorder(root.right, k);

    }


    /*
    public static int kthSmallest(TreeNode root, int[] k) {
        final int[] result = kthSmallestElement(root, k);
        return result[0];
    }

    //TODO - Is there any way to do this with return int and not int[]
    private static int[] kthSmallestElement(TreeNode root, int[] k) {
        if (root == null)
            return new int[]{0, k[0]};

        final int[] retLeft = kthSmallestElement(root.left, k);
        k[0] = retLeft[1];

        if (retLeft[0] != 0) {
            return retLeft;
        } else if (--k[0] == 0) {
            return new int[]{root.val, k[0]};
        }


        return kthSmallestElement(root.right, k);
    }*/
}
