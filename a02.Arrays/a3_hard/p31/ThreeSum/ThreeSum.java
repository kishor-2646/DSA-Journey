package arrays.hard.p31.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    // ─────────────────────────────────────────────
    // Given an integer array nums, return all triplets
    // [nums[i], nums[j], nums[k]] such that i ≠ j ≠ k
    // and nums[i] + nums[j] + nums[k] == 0.
    // No duplicate triplets in the result.
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force — 3 Nested Loops
    // Try all (i, j, k) combinations.
    // Use a Set of sorted triplets to avoid duplicates.
    // T(n) = O(n³ log n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null);
                        set.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better — HashSet for third element
    // Fix i and j, find -(nums[i]+nums[j]) in a HashSet.
    // T(n) = O(n²), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> resSet = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    triplet.sort(null);
                    resSet.add(triplet);
                }
                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(resSet);
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal — Sort + Two Pointers
    // Sort array. Fix i, then use two pointers (j, k)
    // starting at i+1 and n-1.
    //   sum < 0 → move j right (increase sum)
    //   sum > 0 → move k left (decrease sum)
    //   sum == 0 → add triplet, skip duplicates
    //
    // Skip duplicate values of i, j, k to avoid duplicate triplets.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Early exit: smallest triplet sum already positive
            if (nums[i] > 0) break;

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0, 1, 1}));   // []
        System.out.println(threeSum(new int[]{0, 0, 0}));   // [[0,0,0]]
    }
}
