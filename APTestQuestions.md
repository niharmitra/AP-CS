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

## Question 2  
### Original: 
For any object obj, a call ```obj.getClass().getName()``` returns the name of the obj's class.
Suppose
```Java
System.out.println(new A() + "+" + new B());
```
displays ```A+B ```
Which of the following implementations would produce that result?  
I. Class A has a method
```Java
public String toString() { return "A"; }
```
   and class B has a method
```Java
public String toString() { return "B"; }
```
II. Both class A and class B extend class X that has a method
```Java
public String toString() { return getClass().getname(); }
```
III. Both class A and class B extend an abstract class X that has methods
```Java
public abstract String getName();
public String toString() { return getname(); }
```
   Class A has a method
```Java
public String toString() { return "A"; }
```
   and class B has a method
```Java
public String toString() { return "B"; }
```
a) I only  
b) II only  
c) I and II  
d) II and III  
e) I, II, and III  
### New Version:
For any object obj, a call ```obj.getClass().getName()``` returns the name of the obj's class.
Suppose
```Java
System.out.println(new A() + "+" + new B());
```
displays ```A+B  ```
Which of the following implementations would produce that result?  
I. Class A has a method
```Java
public String toString() { return "A"; }
```
   and class B has a method
```Java
public String toString() { return "B"; }
```
II. Both class A and class B extend class X that has a method
```Java
public String toString() { return getClass().getname(); }
```
III. Both class A and class B extend an abstract class X that has methods
```Java
public abstract String getName();
public String toString() { return getname(); }
```
   Class A has a method
```Java
public String toString() { return "A"; }
```
   and class B has a method
```Java
public String toString() { return "B"; }
```
a) I only  
b) II only  
c) I and II  
d) II and III  
e) I, II, and III  

## Question 3
### Original Version
```Java	
int money;

     public Gambler(int m) { money = m; }

     public int currentMoney() { return money; }
     public void addMoney(int m) { money += m; }

     public void work() { money += 100; }
     public void play() { money /= 2; }
     public liveAnotherDay() { work(); play(); }

     public String toString() { return String.valueOf(money); }
}

public class CompulsiveGambler extends Gambler
{
     public CompulsiveGambler(int m)
     {
          < Missing statements >
     }

     public void work() { /* do nothing */ }

     public void play()
     {
          while (currentMoney() > 1)
          {
               super.play();
          }
     }
}
```
Given that
```System.out.println(new CompulsiveGambler(300));```
displays 300, which of the following could replace < Missing statements > in CompulsiveGambler's constructor?
I.    addMoney(m);  
II.    super(m);  
III.   super();  
     addMoney(m);  
a) I only  
b) II only  
c) I or II  
d) II or III  
e) I, II, or III  
