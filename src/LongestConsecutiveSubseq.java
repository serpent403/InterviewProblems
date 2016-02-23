import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestConsecutiveSubseq {
	int lcs(int [] a) {
		HashMap<Integer, Boolean> hMap = new HashMap<Integer, Boolean>();
		int len = 0;
		
		for(int i=0; i < a.length; i++)
			hMap.put(a[i], true);
		
		Iterator<Map.Entry<Integer, Boolean>> it = hMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, Boolean> pair = it.next();
			
			int ele = pair.getKey();
			if(hMap.get(ele-1) != null) // not the starting number. move on.
				continue;
			
			int len_temp = 1;
			Integer buff = ele;
			while(true) {
				if(hMap.get(buff + 1) != null) {
					buff++;
					len++;
				} else {
					break;
				}
			} // while inner
			
			len = Math.max(len, len_temp);
			
		} // while outer
		
		return len;
	}
	
	public static void main(String args[]) {
		int lcs = new LongestConsecutiveSubseq().lcs(new int[] { 1,9,3,10,4,20,2,5 });
		System.out.println(lcs);
	}
	
}
