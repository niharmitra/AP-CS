Nihar Mitra  
AP CS  
Kuszmaul 6  
February 19, 2015  
AP Test Questions #2,3,4
======
## Question 1  
### Original:  
Consider the following two classes.  
```Java
public class Dog {
	public void act() {
		System.out.print("run ");
		eat();
	}
	public void eat() { 
		System.out.print("eat "); 
	}
}
public class UnderDog extends Dog {
	public void act() { 
		super.act();
		System.out.print("sleep ");
	}
	public void eat() { 
		super.eat(); 
		System.out.print("bark "); 
	} 
}
```
Assume that the following declaration appears in a class other than Dog.  
```Java
Dog fido = new UnderDog();
```  
What is printed as a result of the call fido.act()?  
(a) run eat  
(b) run eat sleep  
(c) run eat sleep bark  
(d) run eat bark sleep  
(e) Nothing is printed due to infinite recursion.  

### New version
Consider the following two classes.  
```Java
public class Dog {
	public void act() {
		System.out.print("run ");
		eat();
	}
	public void eat() {
		act();
		System.out.print("eat "); 
	}
}
public class OverDog extends Dog {
	public void act() {
		super.act();
		System.out.print("eat ");
	}
}
public class UnderDog extends OverDog {
	public void act() { 
		super.act();
		System.out.print("sleep ");
	}
	public void eat() { 
		super.eat(); 
		System.out.print("bark "); 
	} 
}
```
Assume that the following declaration appears in a class other than Dog.  
```Java
Dog fido = new UnderDog();
```  
What is printed as a result of the call fido.act()?  
(a) eat sleep  
(b) "sleep eat " is printed, then "run eat " is printed infinitely  
(c) run eat sleep  
(d) Nothing is printed due to infinite recursion.  
(e) run is printed infinitely.  
