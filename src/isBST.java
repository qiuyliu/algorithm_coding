/**
 * 
 * @author qiuyaoliu
 * time : O(n) each node time complexity, if we have N node in the tree, go over is O(n)
 * space: O(logn)
 */
class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
public class isBST {
	
	public boolean isBST(TreeNode root) {
		return  isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.key <= min || root.key >= max) {
			return false;
		}
		
		return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(6);

		isBST sol = new isBST();
		System.out.println(sol.isBST(root));
	}

}
