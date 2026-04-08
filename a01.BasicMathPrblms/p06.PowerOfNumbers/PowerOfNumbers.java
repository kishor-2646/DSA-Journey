package a01_basicMath.p06.PowerOfNumbers;

public class PowerOfNumbers {

    // ─────────────────────────────────────────────
    // Problem: Given number n (1 ≤ n ≤ 10),
    // find n raised to the power of its own reverse.
    // Constraint note: n=10 → reverse = 01 = 1 → 10^1 = 10
    // For single-digit n: reverse = n itself → n^n
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Constraint-based (Specific to 1 ≤ n ≤ 10)
    // If n != 10: single digit, reverse = n → return n^n
    // If n == 10: reverse = 01 = 1 → return 10^1 = 10
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int reverseExponentiation(int n) {
        if (n != 10) {
            return (int) Math.pow(n, n);
        } else {
            return (int) Math.pow(n, 1);
        }
    }

    // ─────────────────────────────────────────────
    // Approach 2: General – Compute Reverse, then Power
    // Reverse the digits of n, then return n^reverse.
    // Handles any n value correctly.
    // T(n) = O(log10(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static long reverseExponentiationGeneral(int n) {
        int temp = n, rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return (long) Math.pow(n, rev);
    }

    public static void main(String[] args) {
        System.out.println(reverseExponentiation(10));          // 10  (10^1)
        System.out.println(reverseExponentiation(9));           // 387420489 (9^9)
        System.out.println(reverseExponentiationGeneral(10));   // 10
        System.out.println(reverseExponentiationGeneral(9));    // 387420489
    }
}