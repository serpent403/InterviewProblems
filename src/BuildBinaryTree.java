
public class BuildBinaryTree {
	private int[] inorder;
	private int[] preorder;
	private int preIndex;
	
	
	public BuildBinaryTree(int[] inorder, int[] preorder) {
		this.inorder = inorder;
		this.preorder = preorder;
		preIndex = 0;
		
	}
	
	public int getIndex(int[] arr, int l, int r, int ele) {
        int k=-1;
        
        for(int i=l; i <= r; i++){
            if(arr[i] == ele) {
                k=i;
                break;
            }
        }
        
        return k;
	}	
	
	TreeNode buildTree(int inIndexLeft, int inIndexRight) {
		TreeNode node = null;
		
		if((inIndexLeft <= inIndexRight) && (preIndex < preorder.length)) {
			int ele = preorder[preIndex++];
			
			// search index of element in in-order array
			int inIndex = getIndex(inorder, inIndexLeft, inIndexRight, ele);
			
			if(inIndex != -1) {
				// create new node with this root
				node = new TreeNode(ele);
				
				// recursively call buildTree on elements left of inIndex and right of inIndex
				node.left = buildTree(inIndexLeft, inIndex-1);
				node.right = buildTree(inIndex+1, inIndexRight);
				
			}
		}
		
		return node;
	}
	
	public static void main(String args[]) {
		BuildBinaryTree bbt = new BuildBinaryTree(new int[] { 11,8,4,2,9,5 }, new int[] { 2,8,11,4,5,9 });
		
		TreeNode root = bbt.buildTree(0, bbt.inorder.length-1);
		new BinaryTree(root).printInOrder(root);
		
		
	}
	
}
