package vocab;
/*
 * Vocab #2
 * Inheritance
 * Delegation
 * Polymorphism
 * Overloading
 */
public class Person {
	public String name;
	
	public static void main(String[] args) {
		Person james = new Person("james");
		Student nihar = new Student("nihar", "paly");
		
		printName(james);
		//Polymorphs nihar into a Person for printName
		printName(nihar);
		nihar.printSchool();
		james.printUppercase();
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public static void printName(Person person) {
		System.out.println(person.name);
	}
	
	public void printUppercase() {
		//Delegates the to uppercase method to the String
		System.out.println(name.toUpperCase());
	}
}
