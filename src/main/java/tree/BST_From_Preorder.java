package tree;

public class BST_From_Preorder {
    public static void main(String[] args) {
        int[] elements = new int[]{10, 5, 1, 7, 40, 50};
        Node root = null;
        root = buildBST(root, elements);
        System.out.println(root);
    }

    private static Node buildBST(Node root, int[] elements) {
        for (int element : elements) {
            root = addNodeToBST(root, element);
        }
        return root;
    }

    private static Node addNodeToBST(Node root, int element) {
        if (root == null) {
            root = new Node(element);
        } else if (element <= root.value) {
            root.left = addNodeToBST(root.left, element);
        } else {
            root.right = addNodeToBST(root.right, element);
        }

        return root;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
