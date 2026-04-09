package arrays.medium.p26.LeadersInArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

    // ─────────────────────────────────────────────
    // An element is a LEADER if it is greater than
    // all the elements to its RIGHT.
    // The rightmost element is always a leader.
    //
    // Example:
    //   arr = [4, 7, 1, 0]  → leaders: [7, 1, 0]
    //   arr = [10, 22, 12, 3, 0, 6] → leaders: [22, 12, 6]
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force — Nested Loops
    // Outer loop: pick each element.
    // Inner loop: check if any element to its right >= it.
    // If none found → it is a leader.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static List<Integer> leadersBrute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean leader = true;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal — Scan from Right
    // Start from the back, keep track of max seen so far.
    // Initially max = nums[n-1] (rightmost is always a leader).
    // If nums[i] > max → it's a leader, update max.
    // Reverse result list at end (since we collected right to left).
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return ans;

        int max = nums[n - 1];
        ans.add(nums[n - 1]); // rightmost is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(ans); // restore left-to-right order
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 0};
        System.out.println(leaders(arr1)); // [7, 1, 0]

        int[] arr2 = {10, 22, 12, 3, 0, 6};
        System.out.println(leaders(arr2)); // [22, 12, 6]
    }
}
