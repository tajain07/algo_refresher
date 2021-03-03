package tree;

public class BinarySearchTree {

    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }
    }

    Node root;

    public BinarySearchTree() {
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (root.data > key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inorder() {
        inOrderRec(root);
    }

    //Left Root Right
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }


    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();
    }
}

