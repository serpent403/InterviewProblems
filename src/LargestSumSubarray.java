
public class LargestSumSubarray {
	int[] A;
	
	public LargestSumSubarray(int [] arr) {
		A = arr;
	}
	
	void largestSumContiguous() {
		int[] S = new int[A.length];
		
		S[0] = A[0];
		int maxSumRightIndex = 0;
		for(int i=1; i < A.length; i++) {
			S[i] = Math.max(A[i], A[i] + S[i-1]);
			
			if(S[i] > S[maxSumRightIndex])
				maxSumRightIndex = i;
			
		}
		
		System.out.println("Maximum Subarray Sum = " + S[maxSumRightIndex]+"\n");
		
		// printing out the sub-array
		int j;
		for(j = maxSumRightIndex; j >= 0; j--) {
			if(S[j] < 0)
				break;
			
			System.out.println(A[j]);
		}
	}
	
	public static void main(String args[]) {
		LargestSumSubarray lss = new LargestSumSubarray(new int[] { -4,8,-7,10,1,3,-2 });
		lss.largestSumContiguous();
		
	}
	
}
