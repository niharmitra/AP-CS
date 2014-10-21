package thinkAPJava.chp15;

public class Complex {
	private int real;
	private int imag;

	public Complex(int r, int i) {
		real = r;
		imag = i;
	}

	public static double abs(Complex c) {
		return Math.sqrt(c.real * c.real + c.imag * c.imag);
	}

	public double abs() {
		return Math.sqrt(real * real + imag * imag);
	}

	public boolean equals(Complex b) {
		return (real == b.real && imag == b.imag);
	}

	public static boolean equals(Complex a, Complex b) {
		return (a.real == b.real && a.imag == b.imag);
	}
}
