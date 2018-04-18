/**
 * represents a complex number and offers methods to calculate with complex
 * numbers.
 * 
 * @author lukas
 * 
 */
public class ComplexNumber {
	private double re;
	private double im;

	/**
	 * initializes the real and imaginary parts with {@code 0}.
	 */
	public ComplexNumber() {
		re = 0.0;
		im = 0.0;
	}

	/**
	 * initializes the real and imaginary part with the given values.
	 * 
	 * @param real
	 *            real part the complex number will be initialized with.
	 * @param imaginary
	 *            imaginary part the complex number will be initialized with.
	 */
	public ComplexNumber(double real, double imaginary) {
		this.re = real;
		this.im = imaginary;
	}

	/**
	 * initializes the real and imaginary parts with the values from the given
	 * complex number.
	 * 
	 * @param cn
	 *            the complex number the new one will be initialized with.
	 */
	public ComplexNumber(ComplexNumber cn) {
		re = cn.re;
		im = cn.im;
	}

	/**
	 * returns the real part of the complex number.
	 * 
	 * @return the real part of the complex number.
	 */
	public double getReal() {
		return this.re;
	}

	/**
	 * returns the imaginary part of the complex number.
	 * 
	 * @return the imaginary part of the complex number.
	 */
	public double getImaginary() {
		return this.im;
	}

	/**
	 * conjugates a complex number.
	 * 
	 * @return a new complex number which is the conjugate of the one the methods
	 *         was called on.
	 */
	public ComplexNumber conjugate() {
		return new ComplexNumber(this.re, this.im * -1.0);
	}

	/**
	 * adds two complex numbers.
	 * 
	 * @param other
	 *            complex number to add to the one the methods was called on.
	 * @return a new complex number which is the sum of the two.
	 */
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(this.re + other.re, this.im + other.im);
	}

	/**
	 * subtracts two complex numbers.
	 * 
	 * @param other
	 *            complex number to subtract from the one the methods was called on.
	 * @return a new complex number which is the result of subtracting other from
	 *         the current complex number.
	 */
	public ComplexNumber subtract(ComplexNumber other) {
		return new ComplexNumber(this.re - other.re, this.im - other.im);
	}

	/**
	 * multiplies two complex numbers.
	 * 
	 * @param other
	 *            complex number the one the methods was called on is multiplied by.
	 * @return a new complex number which is the product of the two.
	 */
	public ComplexNumber multiply(ComplexNumber other) {
		return new ComplexNumber(this.re * other.re - this.im * other.im, this.im * other.re + this.re * other.im);

	}

	/**
	 * divide two complex numbers.
	 * 
	 * @param other
	 *            complex number the one the method was called on is divided by.
	 * @return {@code null} if the real and imaginary part of other is {@code 0}.
	 *         Otherwise, it returns a new complex number which is the result of
	 *         dividing the current complex number by the other one.
	 */
	public ComplexNumber divide(ComplexNumber other) {
		if (other.re == 0.0 && other.im == 0.0) {
			return null;
		}
		double nominator = Math.pow(other.re, 2) + Math.pow(other.im, 2);
		return new ComplexNumber((this.re * other.re + this.im * other.im) / nominator,
				(this.im * other.re - this.re * other.im) / nominator);

	}

	/**
	 * calculate the absolute value of a complex number.
	 * 
	 * @return the absolute value of the complex number.
	 */
	public double abs() {
		return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));

	}

	/**
	 * complex number as string.
	 * 
	 * @return string representation of the complex number.
	 */
	public String toString() {
		return re + " + " + im + "i";
	}
}
