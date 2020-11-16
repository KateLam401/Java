package _requirements.part2;

public class example extends Person {
	
	// define instance variables
	private int empId;
	private String position;
	private double salary;
	
	public Employee() {this("John", 25, 1234, "Manager", 100000);}
	public Employee(String name, int age, int empId, String position, double salary) {
	super(name,age);
		this.empId = empId;
		this.position = position;
		this.salary = salary;}

	// get methods
	public int getEmpId() {return empId;}
	public String getPosition() {return position;}
	public double getSalary() {return salary;}

	// set methods
	public void setEmpId(int i) {empId = i;}
	public void setPosition(String p) {position = p;}
	public void setSalary(double s) {salary = s;}	
	
	// print an employee
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nName = " + this.getName());
		sb.append("\nAge = " + this.getAge());
		sb.append("\nEmployee id = " + this.empId);
		sb.append("\nClassification = " + this.position);
		sb.append("\nSalary = " + this.salary);
		return sb.toString();}
	
	public String toString2() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName() +" "+ this.getAge() +" "+ this.empId +" "+ this.position +" "+ this.salary);
		return sb.toString();}
}
