package arrays.hard.p34.MergeSortedArray;

public class MergeSortedArray {

    // ─────────────────────────────────────────────
    // Given two sorted arrays nums1 (size m+n) and nums2 (size n),
    // merge nums2 into nums1 in-place so result is sorted.
    // nums1 has extra space at end for nums2 elements.
    //
    // Optimal: Fill from the back
    // Compare from the ends of both arrays and place larger
    // element at the last position of nums1.
    // Avoids shifting elements.
    // T(n) = O(m+n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // pointer for nums1 last valid element
        int j = n - 1;       // pointer for nums2 last element
        int k = m + n - 1;   // pointer for nums1 last position

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 has remaining elements, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // No need to handle remaining nums1 elements — already in place
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);

        for (int num : nums1) System.out.print(num + " ");
        // 1 2 2 3 5 6

        System.out.println();

        int[] nums3 = {1};
        int[] nums4 = {};
        merge(nums3, 1, nums4, 0);
        for (int num : nums3) System.out.print(num + " ");
        // 1
    }
}
