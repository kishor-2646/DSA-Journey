package easy.p06.RotateArray;

import java.util.Arrays;

public class RotateArrayLeft {

    // ─────────────────────────────────────────────
    // Approach 1: Naive – Using Recursion (rotate one step at a time)
    // Each recursive call: store last element, shift all right, place last at front.
    // Repeat k times.
    // T(n) = O(n * k), S(n) = O(k) — recursion stack
    // ─────────────────────────────────────────────
    public static void rotateClockwiseRecursive(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return;

        int n = arr.length;
        int lastElement = arr[n - 1];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
        rotateClockwiseRecursive(arr, k - 1);
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Temp Array
    // Place last k elements at beginning of result array.
    // Then place first n-k elements after them.
    // Copy result back to original array.
    // T(n) = O(n), S(n) = O(n)
    //
    // Note: This rotates LEFT (counterclockwise) by k steps.
    // "Rotate left by k" = first k elements go to the end.
    // ─────────────────────────────────────────────
    public static void rotateLeftTempArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < k) {
                res[i] = arr[i + n - k]; // last k elements come first
            } else {
                res[i] = arr[i - k];      // then first n-k elements
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal – Reversal Algorithm
    // To rotate LEFT by k:
    //   Step 1: Reverse last k elements
    //   Step 2: Reverse first n-k elements
    //   Step 3: Reverse entire array
    //
    // Example: [1,2,3,4,5,6], k=2
    //   Reverse last k=2:    [1,2,3,4,6,5]
    //   Reverse first n-k=4: [4,3,2,1,6,5]
    //   Reverse entire:      [5,6,1,2,3,4] ✅
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // Reverse last k elements
        reverse(arr, n - k, n - 1);
        // Reverse first n-k elements
        reverse(arr, 0, n - k - 1);
        // Reverse entire array
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        rotateLeft(arr1, 2);
        System.out.println(Arrays.toString(arr1)); // [3, 4, 5, 6, 1, 2]

        int[] arr2 = {7, 5, 2, 11, 2, 43, 11};
        rotateLeft(arr2, 2);
        System.out.println(Arrays.toString(arr2)); // [2, 11, 2, 43, 11, 7, 5]
    }
}
