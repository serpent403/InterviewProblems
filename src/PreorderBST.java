import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
 
public class PreorderBST {
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        ArrayList<String> out = new ArrayList<String>();  
        
        while(testCases > 0) {
            int n = Integer.parseInt(in.nextLine());
            int[] preOrderArr = new int[n];
            String[] numbers = in.nextLine().split(" ");
            
            for(int i=0; i < numbers.length; i++) {
                preOrderArr[i] = Integer.parseInt(numbers[i]);
            }
                
            out.add(validatePreOrder(preOrderArr));
            testCases--;
        }
        
        for(int i=0; i < out.size(); i++) {
            System.out.println(out.get(i));
        }
        
        in.close();

    }
    
    public static String validatePreOrder(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = -1;
        
        for(int i=0; i < arr.length; i++) {
            if(arr[i] < low && low > -1) {
                return "NO";
            }
            
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                low = stack.pop();
            }
            
            stack.push(arr[i]);
            
        }
        
        return "YES";
    }   
 
}