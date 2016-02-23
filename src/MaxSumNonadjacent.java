
public class MaxSumNonadjacent {
	int[] A;
	
	public MaxSumNonadjacent(int[] arr) {
		this.A = arr;
	}
	
	void maxSum() {
		int[] S = new int[A.length];
		S[0] = A[0];
		
		for(int i=1; i < A.length; i++) {
			if(i == 1) {
				S[i] = Math.max(S[i], S[i-1]);
				continue;
			}
			
			S[i] = Math.max((A[i] + S[i-2]), S[i-1]);
		}
		
		System.out.println(S[S.length-1]);
	}
	
	int findMaxSum(int[] arr) {
		int[] S = new int[arr.length];
		S[0] = arr[0];
		
		for(int i=1; i < arr.length; i++) {
			if(i == 1) {
				S[i] = Math.max(S[i], S[i-1]);
				continue;
			}
			
			S[i] = Math.max((arr[i] + S[i-2]), S[i-1]);
		}
		
		return S[S.length-1];
	}
	

	
	public static void main(String args[]) {
		new MaxSumNonadjacent(new int[] { 3,2,7,10 }).maxSum();
	}

	
	
}