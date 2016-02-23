import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BraceValidation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
        int testCase = Integer.parseInt(scanner.next());
            for(int i = 0; i < testCase; i++){
                String b = scanner.next();
		      System.out.println(isBalanced(b));
        }
        
		
	}
	
	private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == L_PAREN)   stack.push(L_PAREN);

            else if (s.charAt(i) == L_BRACE)   stack.push(L_BRACE);

            else if (s.charAt(i) == L_BRACKET) stack.push(L_BRACKET);

            else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty())        return "NO";
                if (stack.pop() != L_PAREN) return "NO";
            }

            else if (s.charAt(i) == R_BRACE) {
                if (stack.isEmpty())        return "NO";
                if (stack.pop() != L_BRACE) return "NO";
            }

            else if (s.charAt(i) == R_BRACKET) {
                if (stack.isEmpty())        return "NO";
                if (stack.pop() != L_BRACKET) return "NO";
            }

            // ignore all other characters

        }
        if(stack.isEmpty()){
           return "YES"; 
        }
        else{
            return "NO";
        }
    }
    
    
    /*
     * Complete the function below.
     */

        static String[] Braces(String[] values) {
            int valuesCount = values.length;
            String[] resultArray = new String[valuesCount];
            
            Boolean isValid = true;
            for(int i=0; i < valuesCount; i++) {
                String value = values[i];
                if(value.isEmpty()) {
                    isValid = true;
                    
                } else if (value.length() > 100) {
                    isValid = false;
                    
                } else  {
                    
                    Stack<Character> stack = new Stack<Character>();

                    for(int j = 0; j < value.length(); j++) {
                        char currChar = value.charAt(j);
                        
                        if((currChar == '(') || (currChar == '{') || (currChar == '[')) {
                            stack.push(currChar);
                            
                        } else if((currChar == ')') || (currChar == '}') || (currChar == ']')) {
                        	
                            if(stack.isEmpty()) {
                                isValid = false; 
                                break;
                            }
                            
                            char topChar = stack.pop();
                            
                            if (!((currChar == ')' && topChar == '(') || (currChar == '}' && topChar == '{') || (currChar == '[' && topChar == ']'))) {
                                isValid = false;
                            }
                            
                        } else {
                            continue;
                            
                        }
                    } // inner for
                    
                    if(isValid == true && !(stack.empty())) {
                        isValid = false;
                    }
                    
                    resultArray[i] = isValid ? "YES" : "NO";
              
                }
                
            } // outer for
            
            return resultArray;

        }


	
}
