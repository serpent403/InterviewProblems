public class PalindromeBase {   
    public static int answer(int n) { 
        int b = 2;
        String str = "";
        while(true) {
        	// convert integer to base b
            str = Integer.toString(Integer.parseInt(Integer.toString(n), 10), b);
            
            // check if str is a palindrome
            Boolean isPalindrome = true;
    	    int i = str.length()-1;
    	    int j=0;
    	    while(i > j){
    	        if(str.charAt(i) != str.charAt(j)){
    	            isPalindrome = false;
    	            break;
    	        }
    	        i--;
    	        j++;
    	    }
    	    
    	    if(isPalindrome) {
    	        break;
    	    }
    	    
    	    b++;
        }
        
        return b;
    } 
    
    public static void main(String args[]) {
    	System.out.println(PalindromeBase.answer(10));
    }
}