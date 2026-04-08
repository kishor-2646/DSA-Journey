package a1_easy.p21.RearrangeArrayBySign;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RearrangeArrayBySign {

    // ─────────────────────────────────────────────
    // Approach 1: Better – Separate Lists
    // 1. Traverse nums, put positives in "pos" list
    //    and negatives in "neg" list.
    // 2. Merge alternatively starting with positive,
    //    then negative — preserving relative order.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int[] rearrangeSeparateLists(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            result[2 * i]     = pos.get(i);
            result[2 * i + 1] = neg.get(i);
        }
        return result;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – Two Pointers (Cleaner)
    // Observation by looking at result:
    //   Even indices → positive numbers
    //   Odd  indices → negative numbers
    //
    // Maintain 2 pointers:
    //   posIndex = 0 (increments by 2)
    //   negIndex = 1 (increments by 2)
    //
    // Place directly in result array — one pass,
    // no extra lists, relative order maintained.
    // T(n) = O(n), S(n) = O(n)  [result array only]
    // ─────────────────────────────────────────────
    public static int[] rearrangeOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};

        System.out.println("Separate: " + Arrays.toString(rearrangeSeparateLists(nums)));
        // [3, -2, 1, -5, 2, -4]

        System.out.println("Optimal:  " + Arrays.toString(rearrangeOptimal(nums)));
        // [3, -2, 1, -5, 2, -4]
    }
}
