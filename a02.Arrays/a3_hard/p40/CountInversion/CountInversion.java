package a3_arrays.p40.CountInversion;

public class CountInversion {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Nested Loop
    // For each pair (i, j) where i < j,
    // check if arr[i] > arr[j] → count inversion.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int countInversionsBrute(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) cnt++;
            }
        }

        return cnt;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – Merge Sort
    // During merge: if arr[left] > arr[right],
    // all elements from arr[left..mid] form inversions
    // with arr[right] → add (mid - left + 1) to count.
    // Total = inversions in left + right + across merge.
    // T(n) = O(n log n), S(n) = O(n) – temp array
    // ─────────────────────────────────────────────
    public static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1); // all remaining left elements form inversions
            }
        }

        while (left <= mid)  temp[k++] = arr[left++];
        while (right <= high) temp[k++] = arr[right++];

        for (int i = low; i <= high; i++) arr[i] = temp[i - low];

        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;
        int cnt = 0;

        cnt += mergeSort(arr, low, mid);         // left half inversions
        cnt += mergeSort(arr, mid + 1, high);    // right half inversions
        cnt += merge(arr, low, mid, high);       // cross inversions during merge

        return cnt;
    }

    public static int countInversionsOptimal(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 2, 1};

        // Make a copy for brute force (merge sort modifies the array)
        int[] arr2 = arr1.clone();

        System.out.println("Brute Force  → Inversions: " + countInversionsBrute(arr1)); // 10
        System.out.println("Merge Sort   → Inversions: " + countInversionsOptimal(arr2)); // 10

        int[] arr3 = {5, 3, 2, 1, 4};
        int[] arr4 = arr3.clone();

        System.out.println("Brute Force  → Inversions: " + countInversionsBrute(arr3)); // 7
        System.out.println("Merge Sort   → Inversions: " + countInversionsOptimal(arr4)); // 7
    }
}
