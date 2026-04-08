package a1_easy.p17.TwoSum;

public class TwoSum {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Nested Loop
    // For every pair (i, j) where j > i, check if
    // nums[i] + nums[j] == target.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j, j - i};
                }
            }
        }
        return null;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – HashMap (Two-Pass)
    // Pass 1: Store all (value -> index) in map.
    // Pass 2: For each nums[i], check if
    //         complement = target - nums[i] exists
    //         in map and is not the same index.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        // Pass 1: populate map
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        // Pass 2: find complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] r1 = twoSumBrute(nums, target);
        System.out.println("Brute: [" + r1[0] + ", " + r1[1] + "]"); // [0, 1]

        int[] r2 = twoSumOptimal(nums, target);
        System.out.println("Optimal: [" + r2[0] + ", " + r2[1] + "]"); // [0, 1]
    }
}
