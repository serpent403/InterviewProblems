import java.util.*;

public class UnionAndIntersection {
	
	void union(int[] A, int[] B) {
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		
		for(int e : A) {
			if(hMap.get(e) == null)
				hMap.put(e, 1);
		}		
		
		for(int e : B) {
			if(hMap.get(e) == null)
				hMap.put(e, 1);
		}
		
		Iterator<Map.Entry<Integer, Integer>> it = hMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Integer, Integer> pair = it.next();
			System.out.println(pair.getKey());
		}
	}
	
	void intersection(int[] A, int[] B) {
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int e : A) {
			if(hMap.get(e) == null) {
				hMap.put(e, 1);
			}
		}
		
		for(int e : B) {
			if(hMap.get(e) != null) {
				al.add(e);
				System.out.println(e);
			}
		}
	}
	
	public static void main(String args[]) {
		System.out.println("UNION:");
		new UnionAndIntersection().union(new int[] { 1,2,3 }, new int[] { 3,4,5,6 });
		System.out.println("\nINTERSECTION:");
		new UnionAndIntersection().intersection(new int[] { 1,2,3 }, new int[] { 3,4,5,6 });
		
	}

}
