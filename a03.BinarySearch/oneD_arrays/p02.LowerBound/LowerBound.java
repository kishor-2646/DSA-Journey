package b5_1D_Arrays.p02.LowerBound;

public class LowerBound {

    // ─────────────────────────────────────────────
    // Lower Bound Definition:
    // The 1st smallest index in a sorted array where
    // value at that index >= given key x.
    // i.e., arr[index] >= x
    //
    // If no such index found → return n (size of array)
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Linear Scan
    // Traverse from beginning.
    // Return first index where arr[index] >= x.
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int lowerBoundBrute(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) return i;
        }
        return n; // no such index
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – Binary Search
    // Array is sorted → use Binary Search.
    //
    // Declare 2 pointers and 'ans' variable.
    //   low = 0, high = n - 1
    //   ans = n  // if we don't find any index,
    //             // we return n as answer
    //
    // At each mid:
    //   1) If arr[mid] >= x:
    //      mid can be ans. So "ans = mid" and
    //      search in the left half — there may be
    //      a smaller index that still satisfies.
    //   2) If arr[mid] < x:
    //      mid cannot be answer. Need bigger element.
    //      Search in right half: low = mid + 1
    //
    // T(n) = O(log₂ n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // default: no lower bound found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;       // mid could be answer
                high = mid - 1;  // search left for smaller index
            } else {
                low = mid + 1;   // arr[mid] too small, go right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;

        System.out.println("Brute:   " + lowerBoundBrute(arr, x)); // 3
        System.out.println("Optimal: " + lowerBound(arr, x));      // 3

        // x = 5 (exact match)
        System.out.println("x=5: " + lowerBound(arr, 5)); // 1

        // x = 20 (beyond all elements)
        System.out.println("x=20: " + lowerBound(arr, 20)); // 5 (= n, not found)
    }
}
