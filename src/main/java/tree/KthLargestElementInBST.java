package tree;

public class KthLargestElementInBST {
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

        //int kArr = 1;
        /*int[] kArr = new int[]{1};
        int element = kthSmallest(binarySearchTree.root, kArr);
        System.out.println("Kth smallest element, binarySearchTree " + element);*/

        int N = 6; //this should calculate using any tree traversal mechanism
        int k = 2;
        int[] kArr = new int[]{N - k + 1};
        TreeNode resultNode = kthLargestUsingInorder(binarySearchTree.root, kArr);
        System.out.println("Kth smallest element, kthSmallestUsingPreorder " + resultNode.val);


        TreeNode resultNode2 = kthLargestUsingInorder2(binarySearchTree.root, new int[]{k});
        System.out.println("Kth smallest element, kthLargestUsingInorder2 " + resultNode2.val);
    }


    //for kth largest we can do a reverse inorder kind of thing: RIGHT ROOT LEFT with the counter logic
    private static TreeNode kthLargestUsingInorder2(TreeNode root, int[] k) {
        if (root == null)
            return null;

        TreeNode left = kthLargestUsingInorder2(root.right, k);
        if (left != null)
            return left;

        k[0]--;
        if (k[0] == 0)
            return root;

        return kthLargestUsingInorder2(root.left, k);

    }


    /**
     * This is simple inorder traversal with counting. Whenever is count is equal to k that will be our answer
     */
    private static TreeNode kthLargestUsingInorder(TreeNode root, int[] k) {
        if (root == null)
            return null;

        TreeNode left = kthLargestUsingInorder(root.left, k);
        if (left != null)
            return left;

        k[0]--;
        if (k[0] == 0)
            return root;

        return kthLargestUsingInorder(root.right, k);

    }

}
