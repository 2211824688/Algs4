import java.util.Scanner;

/**
 * 1.2.16
 */
public class Rational {
    private final int numerator, denominator;

    public Rational(int numerator, int denominator) {
        assert (denominator != 0) : "denominator must not be zero";
        if (numerator*denominator > 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (numerator*denominator < 0) {
            numerator = -Math.abs(numerator);
            denominator= Math.abs(denominator);
        }
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
        System.out.println("请输入第一个数的分子和分母:");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        Rational a = new Rational(num1, num2);
        System.out.println("第一个数是: " + a);

        System.out.println("请输入第二个数的分子和分母");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        Rational b = new Rational(num1, num2);
        System.out.println("第二个数是: " + b);

        System.out.println("--------运算结果-------");
        System.out.println("plus: " + a.plus(b));
        System.out.println("minus: " + a.minus(b));
        System.out.println("times: " + a.times(b));
        System.out.println("divides: " + a.divides(b));
        System.out.println("a equals b? " + a.equals(b));
    }
}
