
public class MaxDiffSubtree{
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int key;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxDiff(TreeNode root) { 
        return maxDiff(root, 0);
    }

    private int maxDiff(TreeNode root, int glo_max) {
        if (root == null) {
            return 0;
        }
        int leftNum = maxDiff(root.left, glo_max);
        int rightNum = maxDiff(root.right, glo_max);
        glo_max = Math.max(glo_max, Math.abs(leftNum - rightNum));

        return leftNum + rightNum + 1;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        MaxDiffSubtree sol = new MaxDiffSubtree();
        System.out.println(sol.maxDiff(root));
    }
}