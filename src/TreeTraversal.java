import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

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

    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder2(root, res);
        return res;
    }

    private void inOrder2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return ;
        }
        inOrder2(root.left, res);
        res.add(root.key);
        inOrder2(root.right, res);

    }
//    post-order recursion way
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return ;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.key);
    }

//    post-order iterative way
    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        push(stack, root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.key);
//            if the top of stack is the parent of current node, we push the right subtree of top of stack
            if (!stack.isEmpty() && stack.peek().left == cur) {
                push(stack, stack.peek().right);
            }
        }
        return res;
    }

    private void push(Deque<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                return ;
            }
        }
    }

//    Level traversal

    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        int level = 1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode cur = dq.pollFirst();
                    res.add(cur.key);
                    if (cur.left != null) {
                        dq.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        dq.offerLast(cur.right);
                    }
                } else {
                    TreeNode cur = dq.pollLast();
                    res.add(cur.key);
                    if (cur.right != null) {
                        dq.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        dq.offerFirst(cur.left);
                    }
                }
            }
            level++;
        }
        return res;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeTraversal sol = new TreeTraversal();

//        System.out.println(sol.preOrder(root));
//        System.out.println(sol.preOrder2(root));
//        System.out.println(sol.inOrder(root));
//        System.out.println(sol.inOrder2(root));
//        System.out.println(sol.postOrder(root));
//        System.out.println(sol.postOrder2(root));
        System.out.println(sol.zigZag(root));
    }
}
