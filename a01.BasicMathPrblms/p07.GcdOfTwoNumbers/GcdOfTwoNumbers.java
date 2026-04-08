package a01_basicMath.p07.GcdOfTwoNumbers;

public class GcdOfTwoNumbers {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Iterate 1 to min(a, b)
    // Track last i that divides both a and b → that's GCD.
    // T(n) = O(min(a, b)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int gcdBrute(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Iterate from min(a, b) down to 1
    // First i that divides both is the GCD → return immediately.
    // T(n) = O(min(a, b)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int gcdBetter(int a, int b) {
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Euclidean Algorithm (Iterative) ← Best
    // gcd(a, b) = gcd(a % b, b) where a > b
    // gcd(large, small) = gcd(large % small, small)
    // When one becomes 0, the other is the GCD.
    // Example: gcd(20,28) → gcd(28%20,20) → gcd(8,20)
    //          → gcd(20%8,8) → gcd(4,8) → gcd(8%4,4)
    //          → gcd(0,4) → 4
    // T(n) = O(log(min(a, b))), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int gcdEuclidean(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else       b = b % a;
        }
        return (a == 0) ? b : a;
    }

    // ─────────────────────────────────────────────
    // Approach 4: Euclidean Algorithm (Recursive)
    // Base case: gcd(a, 0) = a
    // Recursive: gcd(a, b) = gcd(b, a % b)
    // T(n) = O(log(min(a, b))), S(n) = O(log(min(a, b)))
    // ─────────────────────────────────────────────
    public static int gcdRecursive(int a, int b) {
        return (b == 0) ? a : gcdRecursive(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdBrute(20, 28));      // 4
        System.out.println(gcdBetter(20, 28));     // 4
        System.out.println(gcdEuclidean(20, 28));  // 4
        System.out.println(gcdRecursive(20, 28));  // 4
        System.out.println(gcdEuclidean(52, 10));  // 2
    }
}