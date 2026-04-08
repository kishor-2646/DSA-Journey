package a01_basicMath.p08.PrimeNumbers;

public class PrimeNumbers {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Check 2 to n-1
    // If any i divides n, it's not prime.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isPrimeBrute(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – Check only up to sqrt(n)
    // Key insight: if n has a factor > sqrt(n),
    // then its corresponding pair factor < sqrt(n).
    // So all factors come in pairs — checking up to
    // sqrt(n) covers all of them.
    // T(n) = O(sqrt(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));  // true  (7 is prime)
        System.out.println(isPrime(10)); // false (10 = 2 × 5)
        System.out.println(isPrime(1));  // false
        System.out.println(isPrime(2));  // true
        System.out.println(isPrime(97)); // true
    }
}