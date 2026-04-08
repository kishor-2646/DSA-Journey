package a1_easy.p01.MinMaxInArray;

public class FindMinMax {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Single Linear Scan
    // Initialize min and max with first element.
    // Traverse and update min/max on each element.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int[] getMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int i = 0;

        while (arr[i] != '\0' && i < arr.length) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
            i++;
        }

        return new int[]{min, max};
    }

    // Same using for-each (cleaner Java style):
    public static int[] getMinMaxForEach(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return new int[]{min, max};
    }

    // ─────────────────────────────────────────────
    // Approach 2: Divide & Conquer (Better)
    // Split array into 2 halves recursively.
    // Get (min, max) of left half and right half.
    // Combine: final min = min(left.min, right.min)
    //          final max = max(left.max, right.max)
    // T(n) = O(n), S(n) = O(log n) – recursion stack
    // ─────────────────────────────────────────────
    public static int[] getMinMaxDnC(int[] arr, int low, int high) {
        // Single element
        if (low == high) {
            return new int[]{arr[low], arr[low]};
        }

        // Two elements
        if (low + 1 == high) {
            if (arr[low] < arr[high]) {
                return new int[]{arr[low], arr[high]};
            } else {
                return new int[]{arr[high], arr[low]};
            }
        }

        int mid = (low + high) / 2;

        int[] left  = getMinMaxDnC(arr, low, mid);
        int[] right = getMinMaxDnC(arr, mid + 1, high);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};

        int[] result1 = getMinMaxForEach(arr);
        System.out.println("Min: " + result1[0] + ", Max: " + result1[1]); // Min: 1, Max: 9

        int[] result2 = getMinMaxDnC(arr, 0, arr.length - 1);
        System.out.println("Min: " + result2[0] + ", Max: " + result2[1]); // Min: 1, Max: 9
    }
}
