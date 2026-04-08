package a1_easy.p33.NextPermutation;

import java.util.Arrays;

public class NextPermutation {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force
    // Generate all permutations, sort lexicographically,
    // find current and return next.
    // T(n) = O(n! × log(n!)), S(n) = O(n!)
    // Extremely slow — not practical for large n.
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – In-Place
    //
    // Key Observations:
    //   • We change the number from the "Right Side"
    //   • The right-most position that can be changed
    //     to get the next bigger number
    //
    // Algorithm:
    //   Step 1: Find Breakpoint
    //     Scan from right, find first index where
    //     nums[i] < nums[i+1]. This is the breakpoint.
    //     If no breakpoint → array is fully decreasing
    //     → just reverse entire array (smallest permutation).
    //
    //   Step 2: Find Next Greater
    //     From the right, find first element just
    //     greater than nums[breakpoint].
    //
    //   Step 3: Swap
    //     Swap nums[breakpoint] with that element.
    //
    //   Step 4: Reverse Right Part
    //     Reverse everything to the right of breakpoint.
    //     (The right part is strictly decreasing = largest
    //      arrangement. Reverse it to get smallest.)
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no breakpoint: reverse entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2 & 3: Find next greater than nums[index] and swap
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse right part
        reverse(nums, index + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        nextPermutation(a1);
        System.out.println(Arrays.toString(a1)); // [1, 3, 2]

        int[] a2 = {1, 5, 4, 3, 2};
        nextPermutation(a2);
        System.out.println(Arrays.toString(a2)); // [2, 1, 3, 4, 5]

        int[] a3 = {2, 3, 6, 5, 4, 1};
        nextPermutation(a3);
        System.out.println(Arrays.toString(a3)); // [2, 4, 1, 3, 5, 6]

        int[] a4 = {5, 4, 3, 2, 1}; // fully decreasing
        nextPermutation(a4);
        System.out.println(Arrays.toString(a4)); // [1, 2, 3, 4, 5]
    }
}
