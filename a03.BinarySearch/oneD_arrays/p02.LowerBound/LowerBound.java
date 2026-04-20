package binarysearch.p02.LowerBound;

public class LowerBound {

    // ─────────────────────────────────────────────
    // APPROACH 1: Brute Force — Linear Scan
    // Traverse from beginning; return first index where arr[i] >= x.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int lowerBoundBrute(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) return i;
        }
        return arr.length;
    }

    // ─────────────────────────────────────────────
    // APPROACH 2: Optimal — Binary Search
    // ans = N by default (if no index satisfies condition).
    // If arr[mid] >= x → mid can be answer, search left for smaller index.
    // If arr[mid] < x  → need bigger element, search right.
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // default: no valid index found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;       // mid is a candidate
                high = mid - 1;  // search left for smaller valid index
            } else {
                low = mid + 1;   // arr[mid] too small, go right
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────
    // BONUS: Upper Bound — first index where arr[index] > x
    // Same logic but condition is arr[mid] > x (strict)
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};

        System.out.println(lowerBoundBrute(arr, 9));  // 3
        System.out.println(lowerBound(arr, 9));        // 3
        System.out.println(lowerBound(arr, 3));        // 0
        System.out.println(lowerBound(arr, 20));       // 5 (N, not found)

        System.out.println(upperBound(arr, 9));        // 3
        System.out.println(upperBound(arr, 8));        // 3
    }
}