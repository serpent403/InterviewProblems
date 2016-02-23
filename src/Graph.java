import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Vertex {
	int id; // number
	int key; // MST key
	
	public Vertex(int i, int k) {
		id = i;
		key = k;
	}
	
}

public class Graph {
	
	int[][] adjMatrix;
	
	public Graph(int[][] a) {
		adjMatrix = a;
	}
	
	void BFS() {
		Boolean[] visited = new Boolean[adjMatrix.length]; // .length gives number of rows
		Integer[] pred = new Integer[adjMatrix.length];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Arrays.fill(visited, false);
		pred[0] = null;
		visited[0] = true;
		Q.add(0);
		
		while(!Q.isEmpty()) {
			Integer n = Q.remove();
			System.out.println(n);
			
			for(int i=0; i < adjMatrix[0].length; i++) { // [0].length gives number of columns
				if(adjMatrix[n][i] == 1 && visited[i] == false) {
					pred[i] = n;
					visited[i] = true;
					Q.add(i);
				}
			}
		}
		
		printPred(pred);
	}
	
	void DFS() {
		Boolean[] visited = new Boolean[adjMatrix.length]; // .length gives number of rows
		Integer[] pred = new Integer[adjMatrix.length];
		
		Arrays.fill(visited, false);
		Arrays.fill(pred, null);		
		
		for(int i=0; i < adjMatrix.length; i++) {
			if(visited[i] == false)
				DFS_VISIT(i, visited, pred);
		}
		
		printPred(pred);
	}
	
	private void DFS_VISIT(Integer n, Boolean[] v, Integer[] p) {
		System.out.println(n);
		
		v[n] = true;
		for(int i=0; i < adjMatrix[0].length; i++) {
			if(adjMatrix[n][i] == 1 && v[i] == false){
				p[i] = n;
				DFS_VISIT(i, v, p);
			}
		}
	}
	
	// cycle detection using dfs
	void detectCycle() {
		Boolean[] visited = new Boolean[adjMatrix.length];
		HashSet<Integer> recStack = new HashSet<Integer>();
		
		Arrays.fill(visited, false);
		
		for(int i=0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				if(detectCycleDFS(i, visited, recStack)) {
					System.out.println("Cycle Detected!");
					return;
				}					
			}			
		}
		
		System.out.println("No cycle detected.");
		
	}
	
	// graph has a cycle if a vertex points to a vertex in the current recursion stack
	private boolean detectCycleDFS(int n, Boolean[] v, HashSet<Integer> r) {
		System.out.println(n);
		v[n] = true;
		
		if(adjMatrix[n][n] == 1) // self loop
			return true;
		
		r.add(n); // add node to recursion hash set
		
		for(int i=0; i < adjMatrix[0].length; i++) {
			if(adjMatrix[n][i] == 1 && v[i] == false) {
				if(r.contains(i))
					return true;
				
				if(detectCycleDFS(i, v, r))
					return true;
			}
		}
		
		
		r.remove(n); // remove node from recursion hash set
		return false;
	}
	
	void topoSort() {
		Boolean[] visited = new Boolean[adjMatrix.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		Arrays.fill(visited, false);
		
		for(int i=0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				topoDfs(i, visited, stack);
				
			}
		}
		
		// printing out the topologically sorted order
		while(!stack.empty())
			System.out.println(stack.pop());
		
	}
	
	// only valid for DAG
	// insert a vertex in stack only if all its adjacent vertices are in stack/visited.
	private void topoDfs(int n, Boolean[] v, Stack<Integer> s) {
		v[n] = true;
		
		for(int i=0; i < adjMatrix[n].length; i++) {
			if(adjMatrix[n][i] == 1 && v[i] == false) {
				topoDfs(i, v, s);
				
			}
		}		
		
		s.push(n);
	}
	
	void mstPrim() {
		Integer[] pred = new Integer[adjMatrix.length];
		Arrays.fill(pred, null);
		
		// define the priority queue
		PriorityQueue<Vertex> PQ = new PriorityQueue<>(adjMatrix.length, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				if(o1.key < o2.key) {
					return -1;
					
				} else {
					return 1;
				}
			}
		});
		
		Vertex[] vertices = new Vertex[adjMatrix.length];
		
		// initialize the PQ with all vertices
		vertices[0] = new Vertex(0, 0); // id=0, key=0
		PQ.add(vertices[0]);
		
		for(int i=1; i < adjMatrix.length; i++) {
			vertices[i] = new Vertex(i, Integer.MAX_VALUE);
			PQ.add(vertices[i]);
		}
		
		while(!PQ.isEmpty()) {
			Vertex v = PQ.poll(); // first 0 is removed
			System.out.println("Polled -> " + v.id);
			
			for(int i=0; i < adjMatrix[v.id].length; i++) {
				if(adjMatrix[v.id][i] != 0){ // adjacent vertices
					System.out.println(v.id+" -> " + i);
					if(PQ.contains(vertices[i]) && adjMatrix[v.id][i] < vertices[i].key) {
						// update the key of this adjacent vertex
						Boolean bool = PQ.remove(vertices[i]);
						System.out.println("Updating key for " + i + " to "+ adjMatrix[v.id][i] +" -> " + bool);
						
						Vertex temp = new Vertex(vertices[i].id, adjMatrix[v.id][i]);
						vertices[i] = temp;
						PQ.add(temp);
						
						pred[i] = v.id;	
					} else {
						//System.out.println("Did not find "+i+" in PQ.");
					}
				}
			} // for
			System.out.println("-------------------------------------------");
		} // while
		
		printPred(pred);
	}
	
	
	void printPred(Integer[] pred) {
		System.out.println("Predecessor array:");
		System.out.println(Arrays.toString(pred));
	}
	
	
	public static void main(String args[]) {
		int[][] a = new int[][] {
//			BFS, DFS
//			{0, 1, 1, 0},
//			{0, 0, 0, 1},
//			{0, 0, 0, 0},
//			{0, 0, 0, 0}

//			Cycle Detection -> http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
//			{0, 1, 1, 0},
//			{0, 0, 1, 0},
//			{1, 0, 0, 1},
//			{0, 0, 0, 1}
			
//			Topological Sort
//			{0,0,0,0,0,0},
//			{0,0,0,0,0,0},
//			{0,0,0,1,0,0},
//			{0,1,0,0,0,0},
//			{1,1,0,0,0,0},
//			{1,0,1,0,0,0}
			
//			MST
//			 0,1,2,3,4,5,6,7,8
			{0,4,0,0,0,0,0,8,0},
			{4,0,8,0,0,0,0,11,0},
			{0,8,0,7,0,4,0,0,2},
			{0,0,7,0,9,14,0,0,0},
			{0,0,0,9,0,10,0,0,0},
			{0,0,4,14,10,0,2,0,0},
			{0,0,0,0,0,2,0,1,6},
			{8,11,0,0,0,0,1,0,7},
			{0,0,2,0,0,0,6,7,0}

			
		};
		
		Graph g = new Graph(a);
		//g.BFS();
		//g.DFS();
		//g.detectCycle();
		//g.topoSort();
		g.mstPrim();
		
	}

}
