
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}
	
	public void invert(TreeNode root) {
		if((root != null) && ((root.left != null) || root.right != null)) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			 
			invert(root.left);
			invert(root.right);
		}
	}
	
	public static void main(String args[]) {
		
	}

}
