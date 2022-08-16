package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    //Root Left  Right
    //Time Complexity - O(N)
    //Space complexity - O(N)
    public static List<Integer> postorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        List<Integer> order = new ArrayList<>();
        if (useRecursive)
            postorderTraversalRec(tree.root, order);
        else
            postorderTraversalIterative_1Stack(tree.root, order);

        return order;
    }


    public static void printPostorderTraversal(BinarySearchTree tree, boolean useRecursive) {
        System.out.print("\nPostorder:  ");
        List<Integer> order = postorderTraversal(tree, useRecursive);
        for (Integer node : order) {
            System.out.printf("%d, ", node);
        }
    }

    private static void postorderTraversalRec(TreeNode treeNode, List<Integer> order) {
        if (treeNode == null) {
            return;
        }
        postorderTraversalRec(treeNode.left, order);
        postorderTraversalRec(treeNode.right, order);
        order.add(treeNode.val);
    }

    /**
     * Time Complexity - O(2N)
     * Time Complexity - O(N)
     */
    public static void postorderTraversalIterative_1Stack(TreeNode root, List<Integer> order) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.peek();
                    st.pop();
                    order.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        order.add(temp.val);
                    }
                }else{
                    cur = temp;
                }
            }
        }
    }

    private static void postorderTraversalIterative_2Stack(TreeNode root, List<Integer> order) {
        if (root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (stack1.size() > 0) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            order.add(stack2.pop().val);
        }
    }
}
