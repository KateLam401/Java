package _requirements.part1;

import java.util.Arrays;

public class Hw1_part1 {

	// method to calculate the sum of squares of odds
	public static int sumOfSquaresOfOdds(int n) {
		int sum = 0; 
		for (int i = 1; i <=  n; i += 2)
			sum += i*i;
	    return sum; }

	// a method to find the min, max and avg of an array
	public static double[] statistics(double[] n) {
		
		// declare variables
		double [] stats = new double[3];
		double min = n[0];
	    double max = n[0];
	    double total = 0.0; 
	    double num;
	    
	    // find max, min and total
	    for (int i = 0; i < n.length; i++){
	    	num = n[i];
	    	if (num > max) { max = num; }
	    	if (num < max) { min = num; }
	    	total = total + num; }
	    
	    // put stats into array
	    stats[0] = max;
	    stats[1] = min;
	    stats[2] = total / n.length;
	    return stats; }

//  test methods
	public static void main(String[] args) {

		System.out.println("===sumOfSquaresOfOdds test===");
		int a1 = sumOfSquaresOfOdds(10);
		int a2 = sumOfSquaresOfOdds(20);
		System.out.println("The result of input value 10: " + a1); 
		System.out.println("The result of input value 20: " + a2); 

		System.out.println();
		System.out.println("===statistics test===");
		double[] c1 = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10 };
		double[] c2 = new double[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		double[] c3 = statistics(c1);
		double[] c4 = statistics(c2);
		System.out.print("The result of input array c1: ");
		System.out.println(Arrays.toString(c3));
		System.out.print("The result of input array c2: ");
		System.out.println(Arrays.toString(c4));
		System.out.println(); }

}