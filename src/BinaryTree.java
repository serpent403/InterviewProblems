import java.util.*;

public class BinaryTree {
	TreeNode root;
	
	HashMap<Integer, Integer> levelWidthMap;
	
	public BinaryTree() {
		root = null;
		levelWidthMap = new HashMap<Integer, Integer>();
	}
	
	public BinaryTree(TreeNode root) {
		this.root = root;
		levelWidthMap = new HashMap<Integer, Integer>();
	}
	
	void printLevelOrder() {
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		
		Q.add(root);
		
		while(!Q.isEmpty()) {
			TreeNode temp = Q.remove();
			System.out.println(temp.val);
			
			if(temp.left != null)
				Q.add(temp.left);
			
			if(temp.right != null)
				Q.add(temp.right);
			
		}
	}
	
	void printInOrder(TreeNode node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.println(node.val);
			printInOrder(node.right);
		}
	}
	
	void inOrderNonRecursive() {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
	}
	 
	void maxWidthOfTree() {
		widthOfTree(root, 1);
		
		Integer maxWidth = Collections.max(levelWidthMap.values());
		System.out.println("maxWidth of Binary Tree = " + maxWidth);
	}
	
	// width -> max number of nodes at any given level
	void widthOfTree(TreeNode node, int level) {
		if(node != null) {			
			Integer count = levelWidthMap.get(level);
			count = (count == null) ? 1 : count+1;
			
			levelWidthMap.put(level, count);
			
			widthOfTree(node.left, level+1);
			widthOfTree(node.right, level+1);
		}
	}
	
	Boolean printAncestors(TreeNode node, int ele) {
		if(node != null) {
			if(node.val == ele) {
				System.out.print(ele + " ");
				return true;
			}
			
			Boolean boolFromLeft = printAncestors(node.left, ele);
			if(boolFromLeft) {
				System.out.print(node.val + " ");
				return true;
			}
			
			Boolean boolFromRight = printAncestors(node.right, ele);
			if(boolFromRight) {
				System.out.print(node.val + " ");
				return true;
			}
		}
		
		return false;

	}
	
	int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
			
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
			
		}
	}

	void maxSum() {
		Stack<Integer> stack = maxSumLeaf(root, 0);
		
		if(!stack.empty()) {
			System.out.println("Max sum = " + stack.pop());
			System.out.println(Arrays.toString(stack.toArray()));
			
		} else {
			System.out.println("Result stack is empty!");
		}
	}
	
	// needs logN extra memory
	Stack<Integer> maxSumLeaf(TreeNode node, int sum) {
		Stack<Integer> newStack = new Stack<Integer>();
		
		if(node != null) {
			int currentSum = sum + node.val;
			
			if(node.left == null && node.right == null) { // leaf node		
				newStack.push(node.val); // push the leaf value
				newStack.push(currentSum); // push total sum at the leaf also onto the stack
				return newStack;
			}

			Stack<Integer> stackLeft = maxSumLeaf(node.left, currentSum);
			Stack<Integer> stackRight = maxSumLeaf(node.right, currentSum);
			
			if(stackLeft.empty()) {
				return stackRight;
				
			} else if(stackRight.empty()) {
				return stackLeft;
			}
			
			int maxLeft = stackLeft.pop();
			int maxRight = stackRight.pop();
			
			if(maxLeft >= maxRight) {
				stackLeft.push(node.val);
				stackLeft.push(maxLeft);
				return stackLeft;
				
			} else {
				stackRight.push(node.val);
				stackRight.push(maxRight);
				return stackRight;
			}
		}
		
		return newStack;
	}
	
	public static void main(String args[]) {
		TreeNode tn1 = new TreeNode(4);
		TreeNode tn2 = new TreeNode(8);
		TreeNode tn3 = new TreeNode(9);
		TreeNode tn4 = new TreeNode(2);
		TreeNode tn5 = new TreeNode(11);
		TreeNode tn6 = new TreeNode(5);
		TreeNode tn7 = new TreeNode(0);
		
		tn2.left = tn4;
		tn2.right = tn5;
		
		tn3.left = tn6;
		tn3.right = tn7;
		
		tn1.left = tn2;
		tn1.right = tn3;
		
		BinaryTree bt = new BinaryTree(tn1);
		//bt.printLevelOrder();
		//bt.printInOrder(bt.root);
		//bt.maxWidthOfTree();
		//bt.printAncestors(bt.root, 5);
		bt.maxSum();
		
		
	}
}