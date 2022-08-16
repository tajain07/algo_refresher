package tree;

/**
 *      12
 *      / \
 *     /   \
 *    /     \
 *   10     16
 *  / \     / \
 * 9  11   /   \
 *        14   18
 */
public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode rootTreeNode) {
        this.root = rootTreeNode;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }


    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key <= root.val)
            root.left = insertRec(root.left, key);
        else
            root.right = insertRec(root.right, key);

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(12);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(16);
        bst.insert(14);
        bst.insert(18);

        InorderTraversal.printInorderTraversal(bst, false);
        PreorderTraversal.printPreorderTraversal(bst, false);
        PostorderTraversal.printPostorderTraversal(bst, false);
        LevelOrderTraversal.print(bst);

    }

}

