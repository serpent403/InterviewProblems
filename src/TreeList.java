//http://cslibrary.stanford.edu/109/TreeListRecursion.html

// My alternate recursive solution
public class TreeList {

	TreeNode head; // head of the DLL
	
	TreeNode treeToList(TreeNode node) {
		if(node == null)
			return null;
		
		TreeNode prev1 = treeToList(node.left);
		
		if(head == null) {
			head = node;
			
		} else {
			if(prev1 != null) {
				prev1.right = node;
				node.left = prev1;
			}	
		}
		
		TreeNode prev2 = treeToList(node.right);
		
		if(prev2 != null) {
			node.right = prev2;
			prev2.left = node;
		}
		
		return (prev2 != null) ? prev2 : node;
		
	}
	
    
    // Do a traversal of the list and print it out
    void printList() {
        TreeNode current = head;
        
        while (current != null) {
            System.out.print(Integer.toString(current.val) + " ");
            current = current.right;
            if (current == head) break;
        }
        
        System.out.println();
    }
	
	
	public static void main(String args[]) {
		TreeNode tn1 = new TreeNode(4);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(5);
		TreeNode tn4 = new TreeNode(1);
		TreeNode tn5 = new TreeNode(3);
		
		tn1.left = tn2;
		tn1.right = tn3;
		
		tn2.left = tn4;
		tn2.right = tn5;
		
		TreeList tList = new TreeList();
		tList.treeToList(tn1);
		
		tList.printList();
		
				
	}
	
}
