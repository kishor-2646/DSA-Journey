package binarysearch.p01.BinarySearch;

public class BinarySearch {

    // ─────────────────────────────────────────────
    // APPROACH 1: Iterative Binary Search
    // Compare mid with target; shrink search space.
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int searchIterative(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    // ─────────────────────────────────────────────
    // APPROACH 2: Recursive Binary Search
    // T(n) = O(log n), S(n) = O(log n) — call stack
    // ─────────────────────────────────────────────
    public static int searchRecursive(int[] a, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (target == a[mid]) return mid;
        else if (target > a[mid]) return searchRecursive(a, target, mid + 1, high);
        else return searchRecursive(a, target, low, mid - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(searchIterative(nums, 9));   // 4
        System.out.println(searchIterative(nums, 2));   // -1

        System.out.println(searchRecursive(nums, 9, 0, nums.length - 1));  // 4
        System.out.println(searchRecursive(nums, 2, 0, nums.length - 1));  // -1
    }
}