import java.util.ArrayList;

public class LeadersArray {
	int[] A;
	public LeadersArray(int[] arr) {
		A = arr;
	}
	
	void leaders() {
		int max = A[A.length-1];
		ArrayList<Integer> leadersList = new ArrayList<Integer>();
		leadersList.add(max);
		
		for(int i=A.length-2; i >= 0; i--) {
			if(A[i] > max) {
				max = A[i];
				leadersList.add(A[i]);
			}
		}
		
		for(int leader : leadersList)
			System.out.println(leader);
		
	}
	
	public static void main(String args[]) {
		new LeadersArray(new int[] { 16,17,4,3,5,2 }).leaders();
	}
	
}
