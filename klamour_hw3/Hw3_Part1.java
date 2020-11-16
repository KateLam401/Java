package _requirements.part1;

import java.io.*;
import java.util.*;

public class Hw3_Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// create a linked list	
		// read employees from input file and store them in the linked list
		String[] line = new String[] {};
		LinkedList<Employee> empLinkedList = new LinkedList<Employee>();
		
		Scanner textScanner = new Scanner (new File(
				"src/_requirements/part1/employee_info.txt"));

		while (textScanner.hasNext()){	
	        line = textScanner.nextLine().split("\\s+");
			empLinkedList.add(new Employee(
					line[0],
					Integer.parseInt(line[1]),
					Integer.parseInt(line[2]),
					line[3],
					Double.parseDouble(line[4])));
		}
		
		// find and print youngest employee and the highest earning employee
		minAge(empLinkedList);
		maxSalary(empLinkedList);
		
		// print all employees before sorting
        System.out.println("\nAll employees before sorting: ");
        for (var e: empLinkedList) {
        	System.out.println(e.toString());}   
		
        // sort by salary & print
        sortBySalary(empLinkedList);
        
	}

	public static void sortBySalary(LinkedList<Employee> empLinkedList) {	
		LinkedList<Employee> empSortedList = new LinkedList<Employee>();
		
		double maxSalary = 0;
        Employee emp = new Employee();

        while (empLinkedList.isEmpty() != true) {
        	Iterator<Employee> empIterator = empLinkedList.iterator();
	        while (empIterator.hasNext()) {
	        	Employee e = empIterator.next();
	        	if (e.getSalary() > maxSalary) {
	        		maxSalary = e.getSalary();
		        	emp = e;
		        }
	        }
		empSortedList.addFirst(emp);
		empLinkedList.remove(emp);
		maxSalary = 0;
        }    
	
        System.out.println("\nAll employees after sorting: ");
        for (var e: empSortedList) {
        	System.out.println(e.toString());}   
	}	
	
	public static void maxSalary(LinkedList<Employee> empLinkedList) {
		Iterator<Employee> empIterator = empLinkedList.iterator();
        
		double maxSalary = 0;
        Employee emp = new Employee();

        while (empIterator.hasNext()) {
        	Employee e = empIterator.next();
        	if (e.getSalary() > maxSalary) {
        		maxSalary = e.getSalary();
        		emp = e;
        		}      	
        } 		
        
        // print employee with the highest salary
        System.out.println("\nEmployee with the highest salary is:");
        System.out.println(emp.toString());
	}

	public static void minAge(LinkedList<Employee> empLinkedList) {
		Iterator<Employee> empIterator = empLinkedList.iterator();
                
        double minAge = 500;
        Employee emp = new Employee();
        
        while (empIterator.hasNext()) {
        	Employee e = empIterator.next();
        	if (e.getAge() < minAge) {
        		minAge = e.getAge();
        		emp = e;
        		}      	
        }     		
        
        // print the youngest employee
        System.out.println("\nThe youngest employee is:");
        System.out.println(emp.toString());
	}	
	
}
