package oneD_arrays.p01.BinarySearch;

public class BinarySearch {

    // ─────────────────────────────────────────────
    // Approach 1: Iterative Binary Search
    // Maintain low and high pointers.
    // Calculate mid = low + (high - low) / 2
    //   (avoids integer overflow vs (low + high) / 2)
    // If nums[mid] == target → return mid
    // If nums[mid] > target  → search left half: high = mid - 1
    // If nums[mid] < target  → search right half: low = mid + 1
    //
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int searchIterative(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Recursive Binary Search
    // Same logic, but uses recursion stack.
    // Base case: if low > high → return -1
    //
    // T(n) = O(log n), S(n) = O(log n) – recursion stack
    // ─────────────────────────────────────────────
    public static int searchRecursive(int[] a, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (target == a[mid]) {
            return mid;
        } else if (target > a[mid]) {
            return searchRecursive(a, target, mid + 1, high);
        } else {
            return searchRecursive(a, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println("Iterative: " + searchIterative(nums, target));                   // 4
        System.out.println("Recursive: " + searchRecursive(nums, target, 0, nums.length - 1)); // 4

        System.out.println("Not found: " + searchIterative(nums, 2)); // -1
    }
}
