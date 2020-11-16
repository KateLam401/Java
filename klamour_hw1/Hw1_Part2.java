package _requirements.part2;

public class Hw1_Part2 {

	public static void main(String[] args) {
		
		// an employee object is created and the employee is printed
		Employee e1 = new Employee("John", 25, 1234, "Manager", 100000);
		System.out.println(e1);
		
		// segment that creates and prints another employee
		Employee e2 = new Employee("Katherine", 30, 1989, "Sr Manager", 150000);
		System.out.println(e2);

		// segment that creates and prints another employee
		Employee e3 = new Employee("Miachael", 38, 1981, "Director", 200000);
		System.out.println(e3);
	}

}
