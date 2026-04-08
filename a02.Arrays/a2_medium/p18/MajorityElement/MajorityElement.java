package a1_easy.p18.MajorityElement;

public class MajorityElement {

    // ─────────────────────────────────────────────
    // Approach 1: Naive – Nested Loop Count
    // For each element, count how many times it
    // appears. Return element if count > n/2.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int majorityElementNaive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) count++;
            }
            if (count > n / 2) return nums[i];
        }
        return -1;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – HashMap Frequency Count
    // Count frequency of each element using HashMap.
    // Return element whose frequency > n/2.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int majorityElementHashMap(int[] nums) {
        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : freq.keySet()) {
            if (freq.get(num) > n / 2) return num;
        }
        return -1;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal – Boyer-Moore Voting
    // Intuition: Imagine cancelling out different
    // elements. The majority element won't be fully
    // cancelled because it appears > n/2 times.
    //
    // Algorithm:
    //   count = 0, candidate = 0
    //   For each num:
    //     if count == 0 → candidate = num
    //     count += (num == candidate) ? 1 : -1
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Naive:       " + majorityElementNaive(nums));       // 2
        System.out.println("HashMap:     " + majorityElementHashMap(nums));     // 2
        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(nums)); // 2
    }
}
