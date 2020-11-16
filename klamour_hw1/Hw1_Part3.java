package _requirements.part3;
import _requirements.part2.Employee;
import java.io.*; 
import java.nio.*; 
import java.util.*;

public class Hw1_Part3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		String[] line = new String[] {};
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		Scanner textScanner = new Scanner (new File(
				"src/_requirements/part3/employee_info.txt"));
		
		while (textScanner.hasNext()){	
	        line = textScanner.nextLine().split("\\s+");
			empList.add(new Employee(
					line[0],
					Integer.parseInt(line[1]),
					Integer.parseInt(line[2]),
					line[3],
					Double.parseDouble(line[4])));
		}
       
		Hw1_Part3 example = new Hw1_Part3();
		example.print(empList);
		example.maxSalary(empList);
		example.minAge(empList);
		//print(empList);
        
	}
	
	public void print(ArrayList<Employee> empList) {

        // print full list of employees
        System.out.println("All employees in the ArrayList are:");
        for (var e: empList) {
        	System.out.println(e.toString2());
        }      		
	}
	
	
	public void maxSalary(ArrayList<Employee> empList) {
        
        double maxSalary = 0;
        Employee emp = new Employee();
        
        for (var e: empList) {
        	if (e.getSalary() > maxSalary) {
        		maxSalary = e.getSalary();
        		emp = e;
        	}
        }      		
        
        // print employee with the highest salary
        System.out.println("\nEmployee with the highest salary is:");
        System.out.println(emp.toString2());
	}

	
	public void minAge(ArrayList<Employee> empList) {
        
        double minAge = 500;
        Employee emp = new Employee();
        
        for (var e: empList) {
        	if (e.getAge() < minAge) {
        		minAge = e.getAge();
        		emp = e;
        	}
        }      		
        
        // print the youngest employee
        System.out.println("\nThe youngest employee is:");
        System.out.println(emp.toString2());
	}	
	
}