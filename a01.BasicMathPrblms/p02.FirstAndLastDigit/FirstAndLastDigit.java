package a01_basicMath.p02.FirstAndLastDigit;

public class FirstAndLastDigit {

    // ─────────────────────────────────────────────
    // Last Digit: Modulo by 10
    // n % 10 always gives the last (units) digit.
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int lastDigit(int n) {
        return n % 10;
    }

    // ─────────────────────────────────────────────
    // First Digit: Naive Approach (Loop)
    // Divide n by 10 repeatedly until n < 10.
    // The remaining value is the first digit.
    // T(n) = O(log10(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int firstDigitNaive(int n) {
        while (n > 10) {
            n /= 10;
        }
        return n;
    }

    // ─────────────────────────────────────────────
    // First Digit: Efficient (Logarithm)
    // log10(n) tells how many digits n has - 1.
    // e.g. n=98562 → log10(98562)=4.99 → (int)=4
    // 98562 / 10^4 = 9.8562 → (int) = 9 (first digit)
    // Formula: first = n / (int) Math.pow(10, digits)
    //          where digits = (int) Math.log10(n)
    // T(n) = O(log(log10(n))), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int firstDigitEfficient(int n) {
        int digits = (int) Math.log10(n);
        return n / (int) Math.pow(10, digits);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Last Digit: " + lastDigit(n));              // 5
        System.out.println("First Digit (Naive): " + firstDigitNaive(n));        // 1
        System.out.println("First Digit (Efficient): " + firstDigitEfficient(n)); // 1

        int m = 389;
        System.out.println("Last Digit of 389: " + lastDigit(m));       // 9
        System.out.println("First Digit of 389: " + firstDigitNaive(m));// 3
    }
}