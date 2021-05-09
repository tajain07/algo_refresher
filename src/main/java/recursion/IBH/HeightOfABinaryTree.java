package recursion.IBH;

import tree.BinarySearchTree;

public class HeightOfABinaryTree {
    public static void main(String[] args) {
        BinarySearchTree.Node root = new BinarySearchTree.Node(10);
        root.left = new BinarySearchTree.Node(9);
        root.right = new BinarySearchTree.Node(12);
        root.right.right = new BinarySearchTree.Node(14);
        root.left.left = new BinarySearchTree.Node(8);
        root.left.left.left = new BinarySearchTree.Node(6);

        System.out.println(heightOfTree(root));
    }

    public static int heightOfTree(BinarySearchTree.Node root) {

        if (root == null) //Base condition - smallest valid input is null
            return 0;

        //Hypothesis - start
        int left_height = heightOfTree(root.getLeft());
        int right_height = heightOfTree(root.getRight());
        //Hypothesis - end

        return Math.max(left_height, right_height) + 1; //induction
    }
}
