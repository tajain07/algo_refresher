package tree;

//TOOD - Visual representation
public class RightSiblingTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.right = new TreeNode(10);
        root.right.left.left = new TreeNode(11);


        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(13);

        root.right.left.left.left = new TreeNode(14);

        rightSiblingTree(root);
        System.out.println(root);


    }

    //TC - O(n)
    //SC - O(d)
    private static void rightSiblingTree(TreeNode root) {
        rightSiblingTree(root, true, null);
    }

    private static void rightSiblingTree(TreeNode node, boolean isLeft, TreeNode parent) {
        if (node == null)
            return;

        final TreeNode left = node.left;
        final TreeNode right = node.right;

        rightSiblingTree(left, true, node);
        if (parent == null)
            node.right = null;
        else if (isLeft) {
            node.right = parent.right;
        } else {
            if (parent.right == null)
                node.right = null;
            else
                node.right = parent.right.left;
        }
        rightSiblingTree(right, false, node);
    }
}
