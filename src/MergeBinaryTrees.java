public class MergeBinaryTrees {

    public static TreeNode mergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        if (t1 == null && t2 != null) {
            root.key = t2.key;
            root.left = mergeTree(null, t2.left);
            root.right = mergeTree(null, t2.right);
        } else if (t1 != null && t2 == null) {
            root.key = t1.key;
            root.left = mergeTree(t1.left, null);
            root.right = mergeTree(t1.right, null);
        } else {
            root.key = t1.key + t2.key;
            root.left = mergeTree(t1.left, t2.left);
            root.right = mergeTree(t1.right, t2.right);
        }

        return root;
    }

    static class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;

        public TreeNode(TreeNode root) {
            this.key = root.key;
            this.left = root.left;
            this.right = root.right;
        }

        public TreeNode(int key) {
            this.key = key;
        }
    }

    private static void preorder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.key);
        //helper(root.left);
        //helper(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(3);
        preorder(mergeTree(root, root2));
    }
}
