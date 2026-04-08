package a1_easy.p03.MissingInArray;

public class MissingInArray {

    // ─────────────────────────────────────────────
    // Approach 1: Naive / Brute Force
    // For each number from 1 to n, linearly search
    // if it exists in the array. If not found → missing.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int missingNaive(int[] arr) {
        int n = arr.length;

        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;

            for (int j = 0; j < n - 1; j++) {
                if (i == arr[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }

        return -1;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Hashing
    // Create a hash array of size n+1.
    // Mark each element's presence: hash[arr[i]]++
    // Then scan hash from index 1 to n.
    // First index with hash[i] == 0 is missing.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int missingHashing(int[] arr) {
        int n = arr.length + 1; // n = arr.length + 1 because array has n-1 elements

        int[] hash = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Better 2 – Sum Formula (Optimal)
    // Expected sum of 1..n = n*(n+1)/2
    // Actual sum of array elements = sum
    // Missing = expectedSum - actualSum
    // Use long to avoid integer overflow.
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int missingSum(int[] arr) {
        long n = arr.length + 1; // n = size of complete range

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        long expSum = n * (n + 1) / 2; // use long to avoid overflow

        return (int)(expSum - sum);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        System.out.println(missingSum(arr1)); // Output: 4

        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingSum(arr2)); // Output: 6

        int[] arr3 = {1};
        System.out.println(missingSum(arr3)); // Output: 2
    }
}
