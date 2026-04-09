package arrays.hard.p35.ReversePairs;

public class ReversePairs {

    // ─────────────────────────────────────────────
    // Given an integer array nums, return the number of
    // REVERSE PAIRS: pairs (i, j) where i < j and
    // nums[i] > 2 * nums[j].
    //
    // Optimal: Modified Merge Sort
    // During merge step, count pairs before merging.
    // For each i in left half, find count of j in right half
    // where nums[i] > 2*nums[j]. Use two pointers since both halves sorted.
    //
    // T(n) = O(n log n), S(n) = O(n)
    // ─────────────────────────────────────────────
    private static int count = 0;

    public static int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
    }

    private static void countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else                   temp[k++] = arr[j++];
        }

        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) arr[low + l] = temp[l];
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1})); // 2
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1})); // 3
    }
}
