// DP 

public class NimGame {
	public boolean canWinNim(int n) {
		boolean[] CW = new boolean[n];
		
		if(n < 0)
			return false;
		
		for(int i = 0; i < n; i++) {
			if((i== 0) || (i==1) || (i==2)) {
				CW[i] = true;
				
			} else {
				CW[i] = !(CW[i-1] && CW[i-2] && CW[i-3]);
				
			}
		}
		
		return CW[n-1];
	}
	
	public static void main(String args[]) {
		NimGame ng = new NimGame();
		
		System.out.println(ng.canWinNim(3));
		System.out.println(ng.canWinNim(8));
		System.out.println(ng.canWinNim(9));
		
	}

}
