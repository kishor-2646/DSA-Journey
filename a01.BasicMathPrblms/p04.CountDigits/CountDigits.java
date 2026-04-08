package a01_basicMath.p04.CountDigits;

public class CountDigits {

    // ─────────────────────────────────────────────
    // Approach: Extract each digit using modulo and division.
    // Skip digit 0 (division by 0 is undefined).
    // Check if n % digit == 0 → if yes, count it.
    // T(n) = O(digits of n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int evenlyDivides(int n) {
        int num = n;
        int cnt = 0;

        while (num > 0) {
            int digit = num % 10;  // extract last digit

            // digit != 0 → avoid division by zero
            // n % digit == 0 → digit divides n evenly
            if (digit != 0 && n % digit == 0) {
                cnt++;
            }

            num /= 10;  // remove last digit
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(evenlyDivides(12));    // 2 → digits 1 and 2 both divide 12
        System.out.println(evenlyDivides(2446));  // 1 → only digit 2 divides 2446 (4 and 6 don't)
        System.out.println(evenlyDivides(678));   // 1 → only 6 divides 678 (7 and 8 don't)
    }
}