package a1_easy.p02.ThirdLargestElement;

public class ThirdLargestElement {

    // ─────────────────────────────────────────────
    // Optimal: Single Pass with Three Variables
    // Maintain first (largest), second, third largest.
    // Update them as you scan the array.
    // Return -1 if array has fewer than 3 elements.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int thirdLargest(int[] arr) {
        int first  = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third  = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third  = second;
                second = first;
                first  = arr[i];
            } else if (arr[i] > second) {
                third  = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third  = arr[i];
            }
        }

        if (arr.length < 3) {
            return -1;
        } else {
            return third;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 5};
        System.out.println(thirdLargest(arr1)); // Output: 3

        int[] arr2 = {10, 2};
        System.out.println(thirdLargest(arr2)); // Output: -1

        int[] arr3 = {5, 5, 8};
        System.out.println(thirdLargest(arr3)); // Output: 5
    }
}
