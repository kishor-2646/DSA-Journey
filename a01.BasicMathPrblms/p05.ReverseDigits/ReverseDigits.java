package p05.ReverseDigits;

public class ReverseDigits {

    // ─────────────────────────────────────────────
    // Approach: Extract last digit and build reversed number
    // num = (num * 10) + (n % 10) → shift left and add digit
    // n /= 10 → remove last digit from n
    // Leading zeros are automatically removed (e.g., 800 → 8)
    // T(n) = O(log10(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int reverseDigits(int n) {
        int num = 0;

        while (n != 0) {
            int digit = n % 10;          // extract last digit
            num = (num * 10) + digit;    // shift and append
            n /= 10;                     // remove last digit
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(122)); // 221
        System.out.println(reverseDigits(800)); // 8  → no leading zeros
        System.out.println(reverseDigits(12345)); // 54321
    }
}