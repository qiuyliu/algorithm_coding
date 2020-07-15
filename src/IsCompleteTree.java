import com.sun.source.tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsCompleteTree {

    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

//  if(!left and right): false
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left == null) {
                    flag = true;
                } else if (flag) {
                    return false;
                } else {
                    q.offer(cur.left);
                }

                if(cur.right == null) {
                    flag = true;
                } else if (flag) {
                    return false;
                } else {
                    q.offer(cur.right);
                }
            }
        }
        return true;
    }
    
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        IsCompleteTree sol = new IsCompleteTree();
        System.out.println(sol.isCompleted(root));
    }
}
