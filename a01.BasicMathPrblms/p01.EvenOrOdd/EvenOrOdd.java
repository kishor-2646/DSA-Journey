package a01_basicMath.p01.EvenOrOdd;

public class EvenOrOdd {

    // ─────────────────────────────────────────────
    // Approach 1: Modulo Operator
    // n % 2 == 0 → even, else → odd
    // Division and remainder check.
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Bitwise AND (Efficient)
    // Last bit of any odd number is always 1.
    // Last bit of any even number is always 0.
    // Performing AND with 1 isolates the last bit.
    // → If (n & 1) == 0 → even (last bit 0)
    // → If (n & 1) == 1 → odd  (last bit 1)
    // Bitwise ops are extremely fast (operate at binary level).
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isEvenBitwise(int n) {
        if ((n & 1) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isEven(15));         // false
        System.out.println(isEven(4));          // true
        System.out.println(isEvenBitwise(15));  // false
        System.out.println(isEvenBitwise(4));   // true
    }
}