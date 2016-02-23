public class CircularQueue {
	private int[] A;
	private int front;
	private int rear;
	private int size;
	
	public CircularQueue(int size) {
		A  = new int[size];
		front = -1;
		rear = -1;
		this.size = size;
	}
	
	void push(int e) {
		if(front == -1) { // queue is empty
			front = 0;
			
		} else {
			if((rear+1) % size == front) { // queue is full
				System.out.println("Cannot push "+e+". CQ is full!");
				return;
			}	
		}
		
		rear = (rear + 1) % size;
		A[rear] = e;
		System.out.println("Enqueued "+e);
	}
	
	int pop() {
		if(front == -1) { // queue is empty
			System.out.println("Cannot pop. Circular Queue is empty!");
			return -1;			
		}
		
		int e = A[front];
		
		if(front == rear) { // queue has only 1 element in it. remove and reset.
			front = -1;
			rear = -1;
			
		} else {
			front = (front+1) % size;
		}
		
		System.out.println("Dequeued "+e);
		
		return e;
	}
	
	void print() {
		for (int i : A) {
			System.out.println(A[i]);
		}
	}
	
	public static void main(String args[]) {
		CircularQueue cq = new CircularQueue(6);
		
		cq.push(2);
		cq.push(14);
		cq.push(50);
		cq.push(9);
		cq.push(24);
		cq.push(7);
		cq.push(10); // err
		cq.pop();
		cq.push(10);
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop(); // err
		
	}

}