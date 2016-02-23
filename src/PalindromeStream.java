
public class PalindromeStream {
	
	void isPalindrome(String a) {
		int len = a.length();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < len; i++) {
			sb.append(a.charAt(i));
			
			if(sb.length() == 1) {
				System.out.println("YES");
				
			} else {
				int j = i;
				int k = 0;
				boolean err = false;
				
				while(j > k) {
					if(sb.charAt(k) != sb.charAt(j)) {
						err = true;
						break;
					}
					
					k++;
					j--;	
				}
				
				if(err)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
		}
	}

	public static void main(String args[]) {
		new PalindromeStream().isPalindrome("aabaa");
	}	
}
