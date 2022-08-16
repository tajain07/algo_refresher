package tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderIterativeTraversal_SingleStack {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(12);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(16);
        bst.insert(14);
        bst.insert(18);

        List<Integer> order = new ArrayList<>();

        PostorderTraversal.postorderTraversalIterative_1Stack(bst.root, order);
        System.out.print("\nPostorder iterative using single stack:  ");

        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }
}
