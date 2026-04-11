package b5_1D_Arrays.p03.SearchInsertPosition;

public class SearchInsertPosition {

    // ─────────────────────────────────────────────
    // Problem: Given a sorted array of distinct
    // elements and a target.
    // → If target found, return its index.
    // → If target NOT found, return the index where
    //   it would be inserted in order.
    //
    // This is exactly the Lower Bound problem!
    // Find the first index where arr[index] >= target.
    //
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length; // default: insert at end

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;       // mid could be answer (found or insert position)
                high = mid - 1;  // search left for smaller valid index
            } else {
                low = mid + 1;   // nums[mid] < target, go right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // target found
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2

        // target NOT found — return insert position
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0)); // 0

        // Dry run: arr=[1,2,4,7], target=6
        // low=0,high=3 → mid=1 → arr[1]=2 < 6 → low=2
        // low=2,high=3 → mid=2 → arr[2]=4 < 6 → low=3
        // low=3,high=3 → mid=3 → arr[3]=7 >= 6 → ans=3, high=2
        // low > high → return 3
        System.out.println(searchInsert(new int[]{1, 2, 4, 7}, 6)); // 3
    }
}
