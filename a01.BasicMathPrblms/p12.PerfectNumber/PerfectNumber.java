package p12.PerfectNumber;

public class PerfectNumber {

    /**
     * Check if sum of divisors (excluding itself) == n.
     * Efficiently find divisors in pairs up to sqrt(n).
     * T(n) = O(sqrt(n)), S(n) = O(1)
     */
    public static boolean isPerfect(long n) {
        if (n <= 1) return false;

        long sum = 1; // 1 is always a divisor
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i != n) {
                    // Add both divisors in the pair (e.g., 2 and n/2)
                    sum += i + (n / i);
                } else {
                    // Add only once if it's a perfect square
                    sum += i;
                }
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println("6 is perfect? " + isPerfect(6));   // true (1+2+3=6)
        System.out.println("28 is perfect? " + isPerfect(28)); // true (1+2+4+7+14=28)
        System.out.println("10 is perfect? " + isPerfect(10)); // false (1+2+5=8)
    }
}