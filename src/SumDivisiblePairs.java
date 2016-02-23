import java.util.*;

public class SumDivisiblePairs {
	
	void pairs(int[] a, int k) {
		HashMap<Integer, Stack<Integer>> remCountMap = new HashMap<Integer, Stack<Integer>>();
		
		for(int i=0; i < a.length; i++) {
			int rem = a[i] % k;			
			Stack<Integer> stk = remCountMap.get(rem);
			
			if(stk != null) {				
				stk.push(a[i]);
				remCountMap.put(rem, stk);
			} else {
				stk = new Stack<Integer>();
				stk.push(a[i]);
				remCountMap.put(rem, stk);
			}
		}
		
		Iterator<Map.Entry<Integer, Stack<Integer>>> it = remCountMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Integer, Stack<Integer>> pair = it.next();
			int rem = pair.getKey();
			Stack<Integer> stk = pair.getValue();
			
			if(stk.empty())
				continue;
			
			if((rem*2) == k) { // remainder is half of k	
				if(stk.size() % 2 != 0) {
					System.out.println("Array cannot be divied in sum pairs divisible by " + k);
					return;
					
				} else { // print out all the elements in the stack
					int ctr = 0; // used for printing purpose
					while(!stk.isEmpty()) {
						if(ctr%2 == 0) {
							System.out.print(stk.pop());
						} else {
							System.out.println(", "+stk.pop());
						}
						
						ctr++;
					}
				}
				
			} else { // check for corresponding (k - rem) key in the hash map
				Stack<Integer> stk2 = remCountMap.get((k - rem));
				
				if(stk2 == null || stk2.empty() || (stk.size() != stk2.size())) {
					System.out.println("Array cannot be divied in sum pairs divisible by " + k);
					return;
				}
				
				while(!stk.empty()) {
					System.out.println(stk.pop() + ", " + stk2.pop());
				}
			}
		} // while(it.hasNext())
	}
	
	public static void main(String args[]) {
		SumDivisiblePairs sdp = new SumDivisiblePairs();
		//sdp.pairs(new int[] { 9,7,5,3,13,11 }, 6);
		sdp.pairs(new int[] { 92, 75, 65, 48, 45, 35 }, 10);
		
	}

}
