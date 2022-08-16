package tree;

public class FindSuccessor_Inorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;


        root.right = new TreeNode(3);
        root.right.parent = root;

        root.left.left = new TreeNode(4);
        root.left.left.parent = root.left;

        root.left.right = new TreeNode(5);
        root.left.right.parent = root.left;


        root.left.left.left = new TreeNode(6);
        root.left.left.left.parent = root.left.left;

        TreeNode inorder_successor = findSuccessor(root, 3);
        System.out.println("Inorder successor " + inorder_successor);


    }

    //Question - Do node we are searching cannot exist in the tree?
    private static TreeNode findSuccessor(TreeNode root, int successorOf) {
        if (root.right == null)
            return getLeftMostChild(root);

        return getRightMostChild(root);
    }

    private static TreeNode getRightMostChild(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode.parent != null && currentNode.parent.right.equals(currentNode)) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }

    private static TreeNode getLeftMostChild(TreeNode node) {
        TreeNode currentNode = node.right;
        while (currentNode.left != null)
            currentNode = currentNode.left;

        return currentNode;
    }
}
