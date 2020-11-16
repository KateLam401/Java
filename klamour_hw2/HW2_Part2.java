package _requirements.part2;

public class HW2_Part2 {

	public static void rearrange(int[] a) {
		int next = 0;
		for (int n = next; n < a.length; n++) {
			int num = a[n];
			if(num % 2 != 0) {
				a[n] = a[next];
				a[next] = num;
				next++;
			}
		}
	}
	
	// test
	public static void main(String[] args) {
		int n = 10;
		int[] a = new int[n];
		
		// 10 random integers between 0 and 100
		for (int i=0; i<n; i++) {
			a[i] = (int)(Math.random() * 100);
		}
		
		System.out.println("Before rearrange");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + "  ");
		}
		
		rearrange(a);
		
		System.out.println("\nAfter rearrange");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + "  ");
		}			
	}	
}
