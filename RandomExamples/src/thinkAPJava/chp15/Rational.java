package thinkAPJava.chp15;

/*
 * #3
 * The object methods are typically more concise, unless the method is a pure function
 * that doesn't modify the original object
 * 
 * Operations are more naturally static, as you typically think of arguments to an operation,
 * rather than an operation and an argument passed to an existing value
 * 
 * Modifiers are easier to understand as object methods since they act on an object and change
 * the object
 */
public class Rational {
	private int num;
	private int denum;

	public static void main(String[] args) {
		Rational number = new Rational(6, 10);

		number.reduce().print();
		number.print();
		number.add(new Rational(4, 10)).print();
		number.print();
	}

	// Construct
	public Rational() {
		num = 0;
		denum = 1;
	}

	public Rational(int num, int denum) {
		this.num = num;
		this.denum = denum;
	}

	// Print
	public void print() {
		System.out.println(num + "/" + denum);
	}

	// Negate
	public void negate() {
		this.num *= -1;
	}

	// Invert while keeping negative sign in numerator
	public void invert() {
		int numer = num;
		if (numer < 0) {
			num = -denum;
		} else {
			num = denum;
		}
		denum = (int) Math.abs(numer);
	}

	public double toDouble() {
		return num / denum;
	}

	public Rational reduce() {
		Rational result = new Rational(num, denum);
		result.reduceThis();
		return result;
	}

	// Modifies the current rational
	private void reduceThis() {
		int gcd = gcd(num, denum);
		num /= gcd;
		denum /= gcd;
	}

	public Rational add(Rational a) {
		Rational result = new Rational(num, denum);
		result.setNumerator(result.getNumerator() + a.getNumerator());
		result.setDenominator(result.getDenominator() + a.getDenominator());
		result.reduceThis();

		return result;
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	// Get and set
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