/**
 * 1.2.16
 */
public class Rational {
    private final int numerator, denominator;

    public Rational(int numerator, int denominator) {
        assert (denominator != 0) : "denominator must not be zero";
        int gcd = Utils.gcd(numerator, denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    Rational plus(Rational b) {
        int num = this.numerator*b.denominator + this.denominator*b.numerator;
        int den = this.denominator * b.denominator;
        return new Rational(num, den);
    }

    Rational minus(Rational b) {
        int num = this.numerator*b.denominator - this.denominator*b.numerator;
        int den = this.denominator * b.denominator;
        return new Rational(num, den);
    }

    Rational times(Rational b) {
        int num = this.numerator * b.numerator;
        int den = this.denominator * b.denominator;
        return new Rational(num, den);
    }

    Rational divides(Rational b) {
        int num = this.numerator * b.denominator;
        int den = this.denominator * b.numerator;
        return new Rational(num, den);
    }

    public boolean equals(Rational that) {
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    @Override
    public String toString() {
        if (numerator == 0) {
            return "0";
        } else if (denominator == 1) {
            return String.valueOf(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 2);
        System.out.println("plus: " + a.plus(b));
        System.out.println("minus: " + a.minus(b));
        System.out.println("times: " + a.times(b));
        System.out.println("divides: " + a.divides(b));
        System.out.println("a equals b? " + a.equals(b));
    }
}
