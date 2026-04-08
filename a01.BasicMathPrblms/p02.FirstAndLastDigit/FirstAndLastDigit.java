package p02.FirstAndLastDigit;

public class FirstAndLastDigit {

    // ─────────────────────────────────────────────
    // Finding Last Digit
    // Logic: n % 10
    // ─────────────────────────────────────────────
    public static int getLastDigit(int n) {
        return Math.abs(n) % 10;
    }

    // ─────────────────────────────────────────────
    // Approach 1: Iterative (Looping)
    // Repeatedly divide by 10 until n < 10.
    // T(n) = O(log10 n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int getFirstDigitIterative(int n) {
        n = Math.abs(n);
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Logarithmic (Efficient)
    // Formula: n / 10^(digits-1)
    // T(n) = O(1) or O(math call), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int getFirstDigitLog(int n) {
        if (n == 0) return 0;
        n = Math.abs(n);
        int totalDigitsMinusOne = (int) Math.log10(n);
        return (int) (n / Math.pow(10, totalDigitsMinusOne));
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("First: " + getFirstDigitLog(n)); // 1
        System.out.println("Last: " + getLastDigit(n));     // 5
    }
}