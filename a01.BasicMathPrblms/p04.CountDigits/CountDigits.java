package p04.CountDigits;

public class CountDigits {

    /**
     * Counts how many digits of n divide n evenly.
     * Ex: n = 12 -> 1 divides 12, 2 divides 12. Count = 2.
     */
    public static int countEvenlyDivides(int n) {
        int count = 0;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;

            // Ignore 0 to avoid division by zero error
            if (digit != 0 && n % digit == 0) {
                count++;
            }
            temp /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countEvenlyDivides(12));   // 2
        System.out.println(countEvenlyDivides(2446)); // 1 (Only 2 divides 2446)
    }
}