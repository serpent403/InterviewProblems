
public class AddDigits {
	public int add(int num) {
		while((num % 10) != num) {
			int temp = num;
			int sum = 0;
			
			while(temp > 0) {
				sum += (temp % 10);
				temp = temp / 10;
			}
			
			num = sum;
		}
		
		return num;
	}
	
	public static void main(String args[]) {
		AddDigits ad = new AddDigits();
		System.out.println(ad.add(123456789));
		
	}
}