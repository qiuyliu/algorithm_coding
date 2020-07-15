public class isBalancedTree {

    static class TreeNode{
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}

//    in-order traverse
public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    int leftDepth = getDepth(root.left);
    int rightDepth = getDepth(root.right);
    if (Math.abs(leftDepth - rightDepth) > 1) {
        return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
}

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }



    //    post-order traverse
//    public boolean isBalanced(TreeNode root) {
//        return getHeight(root) != -1;
//    }
//
//    private int getHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
//            return -1;
//        }
//        return Math.max(left, right) + 1;
//    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);
        isBalancedTree sol = new isBalancedTree();
        System.out.println(sol.isBalanced(root));
    }
}
