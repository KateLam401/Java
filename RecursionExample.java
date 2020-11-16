

public class RecursionExample {
	
	// print array in reverse order
	// clean user interface
	public static void recursivePrint(int[] a){
		recursivePrint(a, a.length-1);
	}

	// reparameterizing the signature with an additional parameter
	public static void recursivePrint(int[] a, int n){
		if (n < 0) return;
		System.out.print(a[n] + " ");
		recursivePrint(a, n-1);
	}

	
	// clean user interface
	public static int binarySum(int[] data) {
		return binarySum(data, 0, data.length-1);
	}
		
	// reparameterizing the signature with additional parameters
	public static int binarySum(int[ ] data, int low, int high) {
		if (low > high)             // zero elements in subarray
		  return 0;
		else if (low == high)       // one element in subarray
		  return data[low];
		else {
		  int mid = (low + high) / 2;
		  return binarySum(data, low, mid) + binarySum(data, mid+1, high);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {1, 2, 3, 4, 5, 6};
		
		System.out.println("\nPrint a in reverse order: ");
		recursivePrint(a);
		System.out.println("\nPrint b in reverse order: ");
		recursivePrint(b);
		
		System.out.println("Sum of elements in a = " + binarySum(a));
		System.out.println("Sum of elements in b = " + binarySum(b));
		
	}

}
