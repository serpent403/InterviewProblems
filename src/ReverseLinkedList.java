class Node {
	int val;
	Node next;
	
	public Node(int x) { val = x; }
}

public class ReverseLinkedList {
	void reverse(Node n) {
		if(n.next != null) {
			Node next = n.next;
			n.next = null;
			reverse(next);
			next.next = n;
		}
	}
	
	void reverseIterative(Node curr) {
		Node prev = null;
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
	}
	
	public void printLL(Node n) {
		if(n != null) {
		  System.out.println(n.val);
		  printLL(n.next);
		}
	}
	
	public static void main(String args[]) {
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(0);
		Node n4 = new Node(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		ReverseLinkedList sol = new ReverseLinkedList();
		
		sol.printLL(n1);
		//sol.reverse(n1);
		sol.reverseIterative(n1);
		System.out.println("--------------");
		sol.printLL(n4);
		
	}
	
	
}
