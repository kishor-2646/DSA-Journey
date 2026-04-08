package a01_basicMath.p03.LastDigitOfApowB;

public class LastDigitOfApowB {

    // ─────────────────────────────────────────────
    // Key Insight:
    // last digit of a^b = (last digit of a)^b % 10
    // We only need the last digit of 'a' raised to 'b'.
    //
    // Last digits repeat in a cycle pattern:
    //   0 → cycle 1 : {0}
    //   1 → cycle 1 : {1}
    //   2 → cycle 4 : {2, 4, 8, 6}
    //   3 → cycle 4 : {3, 9, 7, 1}
    //   4 → cycle 2 : {4, 6}
    //   5 → cycle 1 : {5}
    //   6 → cycle 1 : {6}
    //   7 → cycle 4 : {7, 9, 3, 1}
    //   8 → cycle 4 : {8, 4, 2, 6}
    //   9 → cycle 2 : {9, 1}
    //
    // So: find which position in the cycle b falls into (b % cycle).
    // Since b can be very large (given as String), compute b % cycle
    // digit by digit.
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach: Pattern Cycle + Digit-by-Digit Exponent Modulo
    // T(n) = O(len(b)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int getLastDigit(String a, String b) {
        // Extract last digit of a
        int lastDigit = a.charAt(a.length() - 1) - '0';

        // Special case: anything^0 = 1
        if (b.equals("0")) return 1;

        // Pattern lengths for last digits 0–9
        int[] patternLen = {1, 1, 4, 4, 2, 1, 1, 4, 4, 2};
        int cycle = patternLen[lastDigit];

        // Compute b % cycle digit by digit (b can be huge, out of int range)
        int expMod = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod = (expMod * 10 + (b.charAt(i) - '0')) % cycle;
        }

        // If expMod == 0, it means b is a multiple of cycle
        // → we use the last element of cycle (= cycle itself)
        if (expMod == 0) expMod = cycle;

        // Result: (lastDigit ^ expMod) % 10
        return (int) Math.pow(lastDigit, expMod) % 10;
    }

    public static void main(String[] args) {
        // 3^10 = 59049 → last digit = 9
        System.out.println(getLastDigit("3", "10")); // 9

        // 2^345: cycle of 2 is 4, 345 % 4 = 1, 2^1 = 2
        System.out.println(getLastDigit("2", "345")); // 2

        // 345^6: last digit of 345 = 5, cycle of 5 is 1, 5^1 = 5
        System.out.println(getLastDigit("345", "6")); // 5
    }
}