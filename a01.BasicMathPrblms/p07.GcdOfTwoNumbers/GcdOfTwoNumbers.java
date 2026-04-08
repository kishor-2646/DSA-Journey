package a01.BasicMathPrblms.p07.GcdOfTwoNumbers;

public class GcdOfTwoNumbers {

    // ─────────────────────────────────────────────
    // Approach 1: Euclidean Algorithm (Subtraction)
    // gcd(a, b) = gcd(a-b, b)
    // T(n) = O(max(a,b)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int gcdSubtraction(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        return (a == 0) ? b : a;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimized Euclidean (Modulo)
    // gcd(a, b) = gcd(a % b, b)
    // T(n) = O(log(min(a,b))), S(n) = O(log(min(a,b))) for recursion
    // ─────────────────────────────────────────────
    public static int gcdModulo(int a, int b) {
        if (b == 0) return a;
        return gcdModulo(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("GCD(20, 28): " + gcdModulo(20, 28)); // 4
        System.out.println("GCD(52, 10): " + gcdModulo(52, 10)); // 2
    }
}