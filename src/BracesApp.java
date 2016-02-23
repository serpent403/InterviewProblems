import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BracesApp {
	
	// ignores non brace characters
    static String[] BracesNew(String[] values) {
        int valuesCount = values.length;
        String[] resultArray = new String[valuesCount];
        
        for(int i=0; i < valuesCount; i++) {
            String value = values[i];
            Boolean isValid = true;
            
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
                        
                        if (!((currChar == ')' && topChar == '(') || (currChar == '}' && topChar == '{') || (currChar == ']' && topChar == '['))) {
                            isValid = false;
                            break;
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


	
	
	public static String[] Braces(String[] values) {
		int strCount = (values.length <= 15) ? values.length : 15;
		String[] resultArray = new String[strCount];
				
		for(int i=0; i < strCount; i++) {
			String str = values[i];
			Boolean isValid = true;
			
			
		    if (str.isEmpty()) {
		    	isValid = true;
		    	
		    } else if (str.length() > 100) {
		    	isValid = false;
		    	
		    } else {	
			    Stack<Character> stackOfBraces = new Stack<Character>();
			    
			    for (int j = 0; j < str.length(); j++) {
			        char currentBrace = str.charAt(j);
			        
			        
			        if (!(currentBrace == '[' || currentBrace == '(' || currentBrace == '{' || currentBrace == ']' || currentBrace == ')' || currentBrace == '}')) {
			          isValid = false;
			          break;
			        }
			        
			        if (currentBrace == '[' || currentBrace == '(' || currentBrace == '{') {
			        	stackOfBraces.push(currentBrace);
			        }
	
			        if (currentBrace == ']' || currentBrace == ')' || currentBrace == '}') {
			            if (stackOfBraces.isEmpty()) {
			            	isValid = false;
			                break;
			            }
	
			            char lastBrace = stackOfBraces.peek();
			            if (currentBrace == '}' && lastBrace == '{' || currentBrace == ')' && lastBrace == '(' || currentBrace == ']' && lastBrace == '[') {
			            	stackOfBraces.pop();
			            	
			            }  else {
			            	isValid = false;
			            	break;
			            	
			            }
			        }
			    } // inner for loop
			    
   			    // extra braces left over
			    if(isValid == true) {
			        if(!stackOfBraces.isEmpty()) { 
			        	isValid = false;
			        }
			    }
		    
		    } // else
		    
		    System.out.println("Bool -> " + isValid.toString());
			
			resultArray[i] = isValid ? "YES" : "NO";
						
		} // outer for loop
		
		return resultArray;
		
	}	

	
  public static void main(String args[]){
	String[] input = {"{{{{{}}}}}", "{[a]b}", "[a]]"};
    String[] resultsArr = BracesNew(input);
    
    for(int i=0; i<resultsArr.length; i++) {
    	System.out.println(resultsArr[i]);
    }
    
  }
	
}
