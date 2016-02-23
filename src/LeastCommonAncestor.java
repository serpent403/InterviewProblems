
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5

public class LeastCommonAncestor {
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if((root.val > p.val) && (root.val > q.val)) {
			return LCA(root.left, p, q);
			
		} else if ((root.val < p.val) && (root.val < q.val)) {
			return LCA(root.right, p, q);
			
		}
		
		return root;
	}
	
	public static void main(String args[]) {
		TreeNode tn1 = new TreeNode(6);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(8);
		TreeNode tn4 = new TreeNode(0);
		TreeNode tn5 = new TreeNode(4);
		TreeNode tn6 = new TreeNode(7);
		TreeNode tn7 = new TreeNode(9);
		TreeNode tn8 = new TreeNode(3);
		TreeNode tn9 = new TreeNode(5);
		
		tn1.left = tn2;
		tn1.right = tn3;
		
		tn2.left = tn4;
		tn2.right = tn5;
		
		tn3.left = tn6;
		tn3.right = tn7;
		
		tn5.left = tn8;
		tn5.right = tn9;
		
		LeastCommonAncestor lcaClass = new LeastCommonAncestor();
		TreeNode lcaFound = lcaClass.LCA(tn1, new TreeNode(0), new TreeNode(5)); // LCA of 0 and 5
		
		System.out.println(lcaFound.val);
		
	}
}
