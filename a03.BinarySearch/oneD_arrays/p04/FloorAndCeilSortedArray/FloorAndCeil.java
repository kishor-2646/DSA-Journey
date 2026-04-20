package binarysearch.p04.FloorAndCeil;

public class FloorAndCeil {

    // ─────────────────────────────────────────────
    // FLOOR: Largest element in array <= x
    // If arr[mid] <= x → mid is valid, try going right for larger floor.
    // If arr[mid] > x  → too big, go left.
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];  // mid is a valid floor candidate
                low = mid + 1;   // search right for a larger valid value
            } else {
                high = mid - 1;  // arr[mid] too large, go left
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────
    // CEIL: Smallest element in array >= x
    // If arr[mid] >= x → mid is valid, try going left for smaller ceil.
    // If arr[mid] < x  → too small, go right.
    // T(n) = O(log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = arr[mid];  // mid is a valid ceil candidate
                high = mid - 1;  // search left for a smaller valid value
            } else {
                low = mid + 1;   // arr[mid] too small, go right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 4, 7, 8, 10};

        System.out.println("Floor of 5: " + findFloor(arr1, 5));   // 4
        System.out.println("Ceil  of 5: " + findCeil(arr1, 5));    // 7

        System.out.println("Floor of 8: " + findFloor(arr1, 8));   // 8
        System.out.println("Ceil  of 8: " + findCeil(arr1, 8));    // 8

        System.out.println("Floor of 2: " + findFloor(arr1, 2));   // -1 (none ≤ 2)
        System.out.println("Ceil  of 11: " + findCeil(arr1, 11));  // -1 (none ≥ 11)
    }
}
