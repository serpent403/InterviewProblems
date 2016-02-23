
public class SortedCircularArray {
	int[] A;
	
	public SortedCircularArray(int[] arr) {
		A = arr;
	}
	
	boolean binarySearch(int start, int end, int ele) {
		if(start <= end) {
			int mid = (start+end)/2;
			System.out.println("mid = " + mid +  ", A[mid] = " + A[mid]);
			
			
			
			if((A[mid] == ele) || (A[start] == ele) || (A[end] == ele)) 
				return true;
			
			if(ele > A[mid]) { // could be in right half. not necessary though
				if(ele < A[end]) { // in right half
					return binarySearch(mid+1, end, ele);
				} else {
					return binarySearch(start, mid-1, ele);
				}
			} else {
				if(ele > A[start]) {
					return binarySearch(start, mid-1, ele);
				} else {
					return binarySearch(mid+1, end, ele);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		SortedCircularArray sca = new SortedCircularArray(new int[] { 9,12,15,16,18,19,20,21,0,6 });
		System.out.println(sca.binarySearch(0, 9, 12));
	}

}
