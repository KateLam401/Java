import java.util.*;

public class SortingComparison {
	
	public static void main(String args[]) {

		List<Integer> intervals = new ArrayList<Integer>(10);
		intervals.add(10000); intervals.add(20000); intervals.add(30000); intervals.add(40000); 
		intervals.add(50000); intervals.add(60000); intervals.add(70000); intervals.add(80000); 
		intervals.add(90000); intervals.add(100000);
		long startTime,endTime,elapsedTime;
        Random r = new Random();
        
        for (var n: intervals) {
            int a[] = new int[n];
            for(int i = 0; i < a.length; i++){
                a[i] = r.nextInt(1000000) + 1;}
		    
			System.out.println("Number of items: " + n.toString());
		    
			startTime = System.currentTimeMillis();	    
	        insertionSort(a);
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime-startTime;
	        System.out.println("insertion sort: " + elapsedTime);
	
			startTime = System.currentTimeMillis();	    
	        mergeSort(a);
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime-startTime;
	        System.out.println("merge sort: " + elapsedTime);
	        
			startTime = System.currentTimeMillis();	    
	        quickSort(a);
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime-startTime;
	        System.out.println("quick sort: " + elapsedTime);
	        
			startTime = System.currentTimeMillis();	    
	        heapSort(a);
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime-startTime;
	        System.out.println("heap sort: " + elapsedTime + "\n");
        
        }
	}
	
	// insertion sort method implementation
	public static void insertionSort(int[] items) {
		int n = items.length;
		for (int k = 1; k < n; k++) {
			int cur = items[k];
			int j = k;
			while (j > 0 && items [j-1] > cur) {
				items[j] = items [j-1];
				j--;
			}
			items[j] = cur;
		}
	}

	// comparison implementation
	private static int comparisons[] = {0, 0, 0, 0};

	// merge sort method implementation
	public static void mergeSort(int[] items) {
		int n = items.length;
		int[] temp1 = new int[n / 2];
		int[] temp2 = new int[n - temp1.length];
		if(n > 1){
			System.arraycopy(items, 0, temp1, 0, n / 2);
	        System.arraycopy(items, n / 2, temp2, 0, temp2.length);
	        mergeSort(temp1);
	        mergeSort(temp2);
	        merge(temp1, temp2, items);}}

	// merge method implementation
	private static void merge(int[] temp1, int[] temp2, int[] items) {
		int p = temp1.length;
	    int q = temp2.length;
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    while(i < p && j < q){
	    	comparisons[2] = comparisons[2] + 1;
	    	if(temp1[i] <= temp2[j]){
	    		items[k] = temp1[i];
	    		i = i + 1;}
	    	else{
	    		items[k] = temp2[j];
	    		j = j + 1;}
	    	k = k + 1;}
	    if(i == p)
	    	System.arraycopy(temp2, j, items, k, q - j);
	    else
	    	System.arraycopy(temp1, i, items, k, p - i);}
	
	// quick sort method implementation
	public static void quickSort(int[] items) {
		quickSort(items, 0, items.length - 1);}

	// quick sort method implementation
	private static void quickSort(int[] items, int l, int r) {
		int s = partition(items, l, r);
		if(l < s - 1)
			quickSort(items, l, s - 1);
		if(s < r)
			quickSort(items, s, r);}

	// partition method implementation
	private static int partition(int[] items, int l, int r) {
		int p = l;
		int q = r;
		int temp;
		int pivot;
		pivot = items[(l + r) / 2];
		while(p <= q){
			comparisons[3] = comparisons[3] + 1;
			while(items[p] < pivot)
				p++;
			comparisons[3] = comparisons[3] + 1;
			while(items[q] > pivot)
				q--;
			if(p <= q){
				temp = items[p];
	            items[p] = items[q];
	            items[q] = temp;
	            p++;
	            q--;}}
		return p;}

	// heap sort method implementation
    public static void heapSort(int[] items) { 
    	//https://www.geeksforgeeks.org/heap-sort
        int n = items.length; 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(items, n, i); 
        for (int i=n-1; i>=0; i--) { 
            int temp = items[0]; 
            items[0] = items[i]; 
            items[i] = temp; 
            heapify(items, i, 0);}}
    
    // heapify method implementation
    private static void heapify(int items[], int n, int i) { 
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n && items[l] > items[largest]) 
            largest = l; 
        if (r < n && items[r] > items[largest]) 
            largest = r; 
        if (largest != i) { 
            int swap = items[i]; 
            items[i] = items[largest]; 
            items[largest] = swap; 
            heapify(items, n, largest);} }

}
