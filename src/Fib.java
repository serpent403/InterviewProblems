// DP
public class Fib {
	static int fib(int n) {
		int M[] = new int[n+1];
		M[0] = 1; M[1] = 1;
		
		// building the table (bottom up)
		for(int i=2; i < n+1; i++) {
		  M[i] = M[i-1] + M[i-2];
		}
		
		return M[n];
	}
	
	public static void main(String args[]) {
		int n = 6;
		System.out.println(fib(n));
	}
	
}
