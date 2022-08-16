package tree;

public class TreeIdenticalOrNot {
    public static void main(String[] args) {
        BinarySearchTree b1 = new BinarySearchTree();

        b1.insert(9);
        b1.insert(20);
        b1.insert(15);
        b1.insert(7);


        BinarySearchTree b2 = new BinarySearchTree();
        b2.insert(9);
        b2.insert(20);
        b2.insert(15);
        b2.insert(7);

        boolean isSame = isSameTree(b1.root, b2.root);
        System.out.println("Is Same, isSameTree: " + isSame);


        isSame = isSameTree_approach2(b1.root, b2.root);
        System.out.println("Is Same, isSameTree_approach2: " + isSame);
    }

    // https://youtu.be/BhuvF_-PWS0
    public static boolean isSameTree_approach2(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

}
