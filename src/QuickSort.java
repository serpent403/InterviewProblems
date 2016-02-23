// QuickSort Tutorial: https://www.youtube.com/watch?v=COk73cpQbFQ

public class QuickSort {
	
	int[] A;
	
	public QuickSort(int[] input) {
		A = input;
	}
	
	void sort(int start, int end) {
		if(start < end) {
			int pIndex = partition(start, end);
			sort(start, pIndex-1);
			sort(pIndex+1, end);
		}
	}
	
	int partition(int start, int end) {		
		int pivot = A[end];
		int pIndex = start;
		
		for(int i=start; i < end; i++) {
			if(A[i] <= pivot) {				
				swap(i, pIndex);
				pIndex++;
			}
		}
		
		swap(pIndex, end);
		return pIndex;
	}
	
	void swap(int i, int j) {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
	
	void printElements() {
		for(int i=0; i < A.length; i++) {
			System.out.print(A[i]);
		}
	}
	
	public static void main(String args[]) {
		QuickSort qs = new QuickSort(new int[] { 7,2,1, 6, 8, 5, 3, 4});
		qs.sort(0, qs.A.length-1);
		qs.printElements();
		
	}

}
