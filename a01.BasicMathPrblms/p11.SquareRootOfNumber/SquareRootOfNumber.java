package a1_easy.p11.SquareRoot;

public class SquareRootOfNumber {

    // ─────────────────────────────────────────────
    // Approach 1: Naive Linear Scan
    // Start res = 1, increment until res*res > n.
    // Return res - 1 (last valid value).
    // T(n) = O(sqrt(n)), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int floorSqrt(int n) {
        int res = 1;

        while (res * res <= n) {
            res++;
        }

        return res - 1;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Binary Search (Better)
    // Search space: 1 to n.
    // At each mid, check if mid*mid <= n.
    // If yes: record res = mid, move low = mid + 1
    // If no:  move high = mid - 1
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int floorSqrtBinarySearch(int n) {
        int low = 1, high = n;
        int res = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Using Math Formula (Most Efficient)
    // sqrt(n) = e^(0.5 * log(n))
    // Use Math.exp and Math.log, cast to int.
    // Handle edge case: (res+1)*(res+1) <= n → return res+1
    // T(n) = O(1), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int floorSqrtFormula(int n) {
        int res = (int) Math.exp(0.5 * Math.log(n));

        // Correct for floating point errors
        if ((long)(res + 1) * (res + 1) <= n) {
            return res + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));   // 2
        System.out.println(floorSqrt(11));  // 3

        System.out.println(floorSqrtBinarySearch(4));  // 2
        System.out.println(floorSqrtBinarySearch(11)); // 3
        System.out.println(floorSqrtBinarySearch(36)); // 6

        System.out.println(floorSqrtFormula(4));  // 2
        System.out.println(floorSqrtFormula(30)); // 5
        System.out.println(floorSqrtFormula(36)); // 6
    }
}