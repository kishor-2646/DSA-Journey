package arrays.hard.p30.MajorityElement2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {

    // ─────────────────────────────────────────────
    // Find all elements that appear MORE THAN n/3 times.
    // At most 2 such elements can exist in any array.
    //
    // Example:
    //   nums = [3,2,3] → [3]
    //   nums = [1,2]   → [1,2]
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force
    // Count frequency of each element using nested loop.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static List<Integer> majorityElementBrute(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || result.get(0) != nums[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) cnt++;
                }
                if (cnt > n / 3) result.add(nums[i]);
            }
            if (result.size() == 2) break;
        }

        return result;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better — HashMap
    // Count all frequencies, then filter > n/3.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static List<Integer> majorityElementHashMap(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal — Extended Boyer-Moore Voting
    // Since at most 2 elements can appear > n/3 times,
    // maintain 2 candidates and 2 counters.
    //
    // Phase 1 — Find candidates:
    //   If num == cand1 → cnt1++
    //   Else if num == cand2 → cnt2++
    //   Else if cnt1 == 0 → cand1 = num, cnt1 = 1
    //   Else if cnt2 == 0 → cand2 = num, cnt2 = 1
    //   Else → cnt1--, cnt2-- (cancel out)
    //
    // Phase 2 — Verify candidates:
    //   Count actual frequency of cand1 and cand2.
    //   Return those with count > n/3.
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cand1 = Integer.MIN_VALUE, cnt1 = 0;
        int cand2 = Integer.MIN_VALUE, cnt2 = 0;

        // Phase 1: Find candidates
        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                cand2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Phase 2: Verify
        cnt1 = 0; cnt2 = 0;
        for (int num : nums) {
            if (num == cand1) cnt1++;
            else if (num == cand2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > n / 3) result.add(cand1);
        if (cnt2 > n / 3) result.add(cand2);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));    // [3]
        System.out.println(majorityElement(new int[]{1, 2}));        // [1, 2]
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2})); // [1, 2]
    }
}
