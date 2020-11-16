

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

// import Employee class
// or make it accessible 
// Example: import O2Fall2019.hw1.Employee;

public class Hw3_Part1 {

	
	public static void sortBySalary(LinkedList<Employee> empList) {
			
		// implement this method
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// create a linked list	
		// read employees from input file and store them in the linked list
		
		// create an iterator
		Iterator<Employee> empIterator = empLinkedList.iterator();
		
		// find and print youngest employee and the highest earning employee
				
		System.out.println("\n\nAll employees before sorting: " );
		// print all employees before sorting
		
		// sort the linked list
		sortBySalary(empLinkedList);
				
		System.out.println("\n\nAll employees after sorting: " );
		// print all employees after sorting
		
	}

}
