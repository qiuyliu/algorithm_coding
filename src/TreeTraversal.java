import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeTraversal {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

//    preorder iterative way

    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.key);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack. push(cur.left);
        }
        return res;
    }

//    preorder recursive way

    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return ;
        }
        res.add(root.key);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }



//    inorder iterative way

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> s = new ArrayDeque<TreeNode>();
        push(root, s);

        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.key);
            push(cur.right, s);
        }

        return res;
    }

    private void push(TreeNode root, Deque<TreeNode> s) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeTraversal sol = new TreeTraversal();

        System.out.println(sol.preOrder(root));
        System.out.println(sol.preOrder2(root));
        System.out.println(sol.inOrder(root));
    }
}
