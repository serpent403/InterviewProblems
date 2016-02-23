import java.util.*;

public class AllPairs {
	
	static void countPairs() {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // number of elements
		int k = scanner.nextInt(); // difference

		int[] arr = new int[n];    
		HashMap<Integer, Boolean> hMap = new HashMap<Integer, Boolean>();
		int count = 0; // number of pairs
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			hMap.put(arr[i], true);
        }
		
		scanner.close();
		
		for(int i = 0; i < n; i++) {
			int ele = arr[i];
			
			Boolean hDiff = hMap.get(ele - k);
			Boolean hSum = hMap.get(ele + k); 
			
			if((ele - k >= 0) && (hDiff != null) && hDiff)
				count++;
			if((hSum != null) && hSum)
				count++;
			
			hMap.put(ele, false);
		}
		
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		countPairs();
	}

}

