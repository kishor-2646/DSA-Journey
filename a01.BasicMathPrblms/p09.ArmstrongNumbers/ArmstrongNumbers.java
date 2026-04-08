package a01_basicMath.p09.ArmstrongNumbers;

public class ArmstrongNumbers {

    // ─────────────────────────────────────────────
    // Approach 1: Specific to 3-Digit Numbers
    // Extract ones, tens, hundreds digits.
    // Check if sum of their cubes == n.
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isArmstrong3Digit(int n) {
        int ones = n % 10;
        int tens = (n / 10) % 10;
        int hundreds = n / 100;

        int sum = ones * ones * ones
                + tens * tens * tens
                + hundreds * hundreds * hundreds;

        return sum == n;
    }

    // ─────────────────────────────────────────────
    // Approach 2: General – Works for Any Number of Digits
    // Armstrong condition: sum of (each digit ^ total_digits) == n
    // 1. Find total number of digits using log10.
    // 2. Extract each digit, add digit^digits to sum.
    // 3. Compare sum with original n.
    // T(n) = O(number of digits), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isArmstrong(int n) {
        int temp = n;
        int digits = (int) Math.log10(n) + 1;  // total digits
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {
        // 3-digit specific
        System.out.println(isArmstrong3Digit(153)); // true  → 1^3 + 5^3 + 3^3 = 153
        System.out.println(isArmstrong3Digit(372)); // false → 3^3 + 7^3 + 2^3 = 378 ≠ 372

        // General
        System.out.println(isArmstrong(153));       // true
        System.out.println(isArmstrong(372));       // false
        System.out.println(isArmstrong(9474));      // true  → 4-digit Armstrong
    }
}