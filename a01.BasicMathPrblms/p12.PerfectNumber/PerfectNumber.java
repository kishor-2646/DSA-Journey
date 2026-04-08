package a1_easy.p12.PerfectNumber;

public class PerfectNumber {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force
    // Iterate i from 1 to n-1, sum all divisors.
    // Check if sum == n.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isPerfect(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 is always a divisor (exclude n itself)

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum == n;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimised using sqrt (Better)
    // Divisors always come in pairs: if i divides n,
    // then n/i also divides n.
    // So only iterate up to sqrt(n).
    // Add both i and n/i in one shot.
    // Handle perfect squares separately (avoid double-count).
    // T(n) = O(sqrt(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isPerfectOptimised(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 is always a divisor

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i != n) {
                    sum += i + n / i; // add both divisor pair
                } else {
                    sum += i; // perfect square: add only once
                }
            }
        }

        return sum == n && n != 1;
    }

    public static void main(String[] args) {
        // Perfect numbers: 6, 28, 496, 8128
        System.out.println(isPerfect(6));   // true  → 1+2+3 = 6
        System.out.println(isPerfect(28));  // true  → 1+2+4+7+14 = 28
        System.out.println(isPerfect(10));  // false → 1+2+5 = 8 ≠ 10

        System.out.println(isPerfectOptimised(6));   // true
        System.out.println(isPerfectOptimised(28));  // true
        System.out.println(isPerfectOptimised(36));  // false
        System.out.println(isPerfectOptimised(496)); // true
    }
}