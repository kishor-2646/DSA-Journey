package a1_easy.p12.UnionOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {

    // Optimal: Two Pointer Approach
    // Traverse both sorted arrays simultaneously.
    // Compare current elements: pick smaller one (or equal) and add to union if not duplicate.
    // Handle remaining elements of either array.
    // T(n) = O(m + n), S(n) = O(m + n)
    public static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                // Add arr1[i] only if union is empty or last element is different
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            } else {
                // arr1[i] == arr2[j]
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        // Handle remaining elements of arr1
        while (i < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Handle remaining elements of arr2
        while (j < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};
        int n = arr1.length, m = arr2.length;

        List<Integer> result = findUnion(arr1, arr2, n, m);

        System.out.println(result);
        // Output: [1, 2, 3, 4, 5]
    }
}
