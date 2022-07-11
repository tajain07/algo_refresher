package tree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node rootNode) {
        this.root = rootNode;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }


    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key <= root.data)
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
        PostorderTraversal.printPostorderTraversal(bst);
        LevelOrderTraversal.printLevelOrderTraversal(bst);

    }

}

