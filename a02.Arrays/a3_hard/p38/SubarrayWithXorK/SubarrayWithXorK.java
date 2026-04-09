package arrays.hard.p38.SubarrayWithXorK;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithXorK {

    // ─────────────────────────────────────────────
    // Given an array and an integer k, count the number
    // of subarrays having XOR of elements equal to k.
    //
    // KEY INSIGHT (analogous to Subarray Sum = K):
    //   prefixXor[j] ^ prefixXor[i] = k
    //   → prefixXor[i] = prefixXor[j] ^ k
    //
    // So at each index j, we ask:
    // "Have we seen (prefixXor ^ k) before?"
    // If yes → count += frequency of that value.
    //
    // Optimal: Prefix XOR + HashMap
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────

    // Brute: All subarrays
    // T(n) = O(n²), S(n) = O(1)
    public static int subarraysWithXorBrute(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) count++;
            }
        }
        return count;
    }

    // Optimal: Prefix XOR + HashMap
    public static int subarraysWithXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        int count = 0;

        map.put(0, 1); // empty subarray has XOR 0

        for (int num : arr) {
            prefixXor ^= num;

            int target = prefixXor ^ k; // we need this to have appeared before
            count += map.getOrDefault(target, 0);

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithXor(new int[]{4, 2, 2, 6, 4}, 6)); // 4
        System.out.println(subarraysWithXor(new int[]{5, 6, 7, 8, 9}, 5)); // 2
    }
}
