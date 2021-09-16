public class LowestCommonAncestor {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int key;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(16);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(-17);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.right = new TreeNode(9);
        TreeNode a = root.left.left;
        TreeNode b = root.left.left.right.right;

        LowestCommonAncestor sol = new LowestCommonAncestor();
        System.out.println(sol.lca(root, a, b).key);
    }
}
