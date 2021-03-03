package recursion;

import tree.BinarySearchTree;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);


        int height = height(tree.getRoot());
        System.out.println(height);

    }

    private static int height(BinarySearchTree.Node node) {
        if (node == null) {
            return 0;
        }

        BinarySearchTree.Node left = node.getLeft();
        BinarySearchTree.Node right = node.getRight();
        return Math.max(height(left), height(right)) + 1;
    }


}
