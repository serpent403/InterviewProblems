
public class CompressString {

	 static String compress(String str) {
		 if(str.length() <= 1) {
			 return str; 
		 }
		 
		StringBuffer sb = new StringBuffer("");
		int ctr = 1;
		
		for(int i=1; i < str.length(); i++) {
			char char_curr = str.charAt(i);
			char char_prev = str.charAt(i-1);
			
			if(char_curr == char_prev) {
				ctr++;
				
			} else {
				String nextStr = (ctr > 1) ? char_prev + Integer.toString(ctr) : char_prev+"";
				sb.append(nextStr);
				ctr = 1;
			}
			
			if(i == str.length() - 1) {
				String lastStr = (ctr > 1) ? char_curr + Integer.toString(ctr) : char_curr+"";
				sb.append(lastStr);
			}	
		}
		
		return sb.toString();
		
	}
	 
	public static void main(String args[]) {
		System.out.println(compress("aafbbbcccz"));
	}
}
