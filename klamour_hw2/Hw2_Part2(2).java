

public class Hw2_Part2 {


	
	public static void rearrange(int[] a) {
		// write this method
		// if needed, write a separate method with additional parameters and invoke it here
	}
	
	// test your method(s)
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
