package vocab;
/*
 * Inheritance
 * Delegation
 * Polymorphism
 * Overloading
 */
public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name);
	}
	
	public void printUppercase() {
		//Delegates the to uppercase method to the String
		System.out.println(name.toUpperCase());
	}
}
