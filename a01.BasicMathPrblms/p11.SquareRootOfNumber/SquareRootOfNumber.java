package p11.SquareRootOfNumber;

public class SquareRootOfNumber {

    // ─────────────────────────────────────────────
    // Approach 1: Binary Search (Optimal)
    // Range: [1, n]. Find mid^2 <= n.
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static long floorSqrtBinarySearch(long n) {
        if (n == 0 || n == 1) return n;

        long low = 1, high = n, ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Using Exponential/Log Formula
    // sqrt(n) = e^(0.5 * log(n))
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int floorSqrtFormula(int n) {
        if (n == 0) return 0;
        int res = (int) Math.exp(0.5 * Math.log(n));

        // Correct for floating point precision
        if ((long)(res + 1) * (res + 1) <= n) return res + 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrtBinarySearch(11)); // 3
        System.out.println(floorSqrtBinarySearch(16)); // 4
    }
}