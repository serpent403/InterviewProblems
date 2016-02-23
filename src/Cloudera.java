import java.util.Arrays;
import java.util.*;

public class Cloudera {	
	int minimumCommon(int [] a, int [] b) {
		// TreeSets maintain sorted order
		Set<Integer> set1 = new TreeSet<Integer>(Arrays.asList(Arrays.stream(a).boxed().toArray( Integer[]::new )));
		Set<Integer> set2 = new TreeSet<Integer>(Arrays.asList(Arrays.stream(b).boxed().toArray( Integer[]::new )));
		set1.retainAll(set2);
		return set1.isEmpty() ? -1 : set1.iterator().next();
	}
	
	int evaluatePostfix(String S) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean error;
		error = false;
		
		for(int i=0; i < S.length(); i++) {
			Character c = S.charAt(i);
			
			if(c == '*') {
				if(stack.empty()) {
					error = true;
					break;
				}
				
				int num1 = stack.pop();

				if(stack.empty()) {
					error = true;
					break;
				}
				
				int num2 = stack.pop();
				
				stack.push(num1*num2);
				
			} else if(c == '+') {
				if(stack.empty()) {
					error = true;
					break;
				}
				
				int num1 = stack.pop();

				if(stack.empty()) {
					error = true;
					break;
				}
				
				int num2 = stack.pop();
				
				stack.push(num1+num2);				
				
			} else {
				stack.push(Character.getNumericValue(c));
			}
		
		} // for
		
		if(error == true) {
			return -1;
		}
		
		int finalNum = stack.pop();
		
		if(!stack.empty())
			return -1;
		
		return finalNum;
	}
	
	
	
     int evaluatePostfix2(String S) {
         Stack<Integer> s = new Stack<Integer>();
         boolean err_flag = false;
         
         for(int i=0; i<S.length(); i++) {
             Character c = S.charAt(i);
             
             if((c == '+') || (c == '*')) {
                 if(s.empty() || s.size() < 2) {
                     err_flag = true;
                     break;
                 }
                 
                 int n1 = s.pop();
                 int n2 = s.pop();
                 
                 int val = (c == '+') ? (n1+n2) : (n1*n2);
                 s.push(val);
                 
             } else {
                 s.push(Character.getNumericValue(c));
             }
         }
             
         if((err_flag == true) || (s.size() > 1)) {
             return -1;
         }
             
         int result = s.pop();
         return result;
    }	
	
	public static void main(String args[]) {
		Cloudera c = new Cloudera();
		
		//14,12,9
		
		System.out.println(c.minimumCommon(new int[] { 14,12,11,9,11,2,3,5 }, new int[] { 2,3,0,10 }));
		
	}

}
