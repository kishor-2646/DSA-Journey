package p01.EvenOrOdd;

/**
 * Problem: Check if a number is Even or Odd.
 * Input: n = 15 -> Output: false
 * Input: n = 4  -> Output: true
 */
public class EvenOrOdd {

    // ─────────────────────────────────────────────
    // Approach 1: Modulo Operator
    // Standard approach using remainder.
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isEvenModulo(int n) {
        return (n % 2 == 0);
    }

    // ─────────────────────────────────────────────
    // Approach 2: Bitwise AND (Efficient)
    // Odd numbers always have the last bit as 1.
    // (n & 1) returns 1 for odd, 0 for even.
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isEvenBitwise(int n) {
        // If (n & 1) is 0, it means the last bit is 0 (Even)
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(n + " is even? " + isEvenBitwise(n)); // false

        n = 4;
        System.out.println(n + " is even? " + isEvenBitwise(n)); // true
    }
}