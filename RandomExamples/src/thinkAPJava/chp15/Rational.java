package thinkAPJava.chp15;

public class Rational {
	private int num;
	private int denum;
	
	public static void main(String[] args) {
		Rational number = new Rational(6,10);
		number.print();
		number.negate();
		number.print();
	}
	//Construct
	public Rational() {
		num=0;
		denum=1;
	}
	public Rational(int num, int denum) {
		this.num = num;
		this.denum = denum;
	}
	//Print
	public void print() {
		System.out.println(num+"/"+denum);
	}
	//Negate
	public void negate() {
		this.num *= -1;
	}
	
	public void invert() {
		int numer = num;
		num = denum;
		denum = numer;
	}
	
	//Get and set
	public int getNumerator() {
		return num;
	}
	public void setNumerator(int num) {
		this.num = num;
	}
	public int getDenominator() {
		return denum;
	}
	public void setDenominator(int denum) {
		this.denum = denum;
	}
}