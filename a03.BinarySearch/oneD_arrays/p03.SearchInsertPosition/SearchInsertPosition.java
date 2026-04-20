package binarysearch.p03.SearchInsertPosition;

public class SearchInsertPosition {

    // ─────────────────────────────────────────────
    // APPROACH 1: Brute Force — Linear Scan
    // Return first index where nums[i] >= target.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int searchInsertBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    // ─────────────────────────────────────────────
    // APPROACH 2: Optimal — Binary Search (Lower Bound)
    // Equivalent to finding lower bound of target.
    // ans = N by default (insert at end if target > all elements).
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;       // mid is a valid insert/found position
                high = mid - 1;  // look for smaller valid index on left
            } else {
                low = mid + 1;   // target must be further right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};

        System.out.println(searchInsert(nums1, 5));  // 2 (found)
        System.out.println(searchInsert(nums1, 2));  // 1 (insert between 1 and 3)
        System.out.println(searchInsert(nums1, 7));  // 4 (insert at end)
        System.out.println(searchInsert(nums1, 0));  // 0 (insert at start)

        int[] nums2 = {1, 3, 5, 6};
        System.out.println(searchInsertBrute(nums2, 2)); // 1
    }
}