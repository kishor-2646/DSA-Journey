package a1_easy.p04.Sort0s1sAnd2s;

import java.util.Arrays;

public class Sort012 {

    // ─────────────────────────────────────────────
    // Approach 1: Naive – Use inbuilt sort
    // Simply sort the array using Arrays.sort()
    // T(n) = O(n log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void sortNaive(int[] arr) {
        Arrays.sort(arr);
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Counting (Two Pass)
    // Count number of 0s, 1s, and 2s.
    // Overwrite array with those counts in order.
    // T(n) = O(2n) ≈ O(n), S(n) = O(1)
    // Note: Not stable, requires 2 traversals.
    // ─────────────────────────────────────────────
    public static void sortCounting(int[] arr) {
        int n = arr.length;
        int c0 = 0, c1 = 0, c2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)      c0++;
            else if (arr[i] == 1) c1++;
            else                  c2++;
        }

        int idx = 0;
        // Place all 0s
        for (int i = 0; i < c0; i++) arr[idx++] = 0;
        // Place all 1s
        for (int i = 0; i < c1; i++) arr[idx++] = 1;
        // Place all 2s
        for (int i = 0; i < c2; i++) arr[idx++] = 2;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal – Dutch National Flag Algorithm
    // Three pointers: low, mid, high
    // Invariants:
    //   arr[0..low-1]  = all 0s
    //   arr[low..mid-1] = all 1s
    //   arr[high+1..n-1] = all 2s
    //   arr[mid..high]  = unsorted (being processed)
    //
    // Rules while (mid <= high):
    //   arr[mid] == 0 → swap(arr, mid, low), low++, mid++
    //   arr[mid] == 1 → mid++ (already in place)
    //   arr[mid] == 2 → swap(arr, mid, high), high-- (don't increment mid)
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
                // Do NOT increment mid: swapped element from high is unprocessed
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 0, 1, 2};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1)); // [0, 0, 1, 1, 2, 2]

        int[] arr2 = {2, 0, 2, 1, 1, 0};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2)); // [0, 0, 1, 1, 2, 2]
    }
}
