package vocab;

public class Student extends Person {
	private String school;
	
	public Student(String name) {
		super(name);
	}
	
	//Overloads the other constructor
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
	
	public void printSchool() {
		System.out.println(school);
	}
}
