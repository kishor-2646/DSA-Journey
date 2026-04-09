# 38. Count Subarrays with XOR Equal to K

> **Platform:** [TakeUForward](https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/) |  
> **Difficulty:** 🔴 Hard  
> **Topic Tags:** `Array` `Bit Manipulation` `Hashing` `Prefix XOR`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an array `arr[]` and an integer `k`, find the total number of **subarrays** whose XOR of all elements equals `k`.

**Example:**
```
Input:  arr[] = {4, 2, 2, 6, 4},  k = 6
Output: 4
Explanation: Subarrays → [4,2], [4,2,2,6,4], [2,2,6], [6]
```

---

## 💡 Intuition

> **Brute Force:** Generate all subarrays and compute their XOR. If XOR == k, increment count. Straightforward but O(n²).
>
> **Optimal (Prefix XOR + HashMap):** Analogous to the "Subarray Sum = K" trick.  
> Define `prefixXor[j]` = XOR of all elements from index 0 to j.  
> The XOR of subarray `[i+1 .. j]` = `prefixXor[j] ^ prefixXor[i]`.  
> For this to equal `k`: `prefixXor[i] = prefixXor[j] ^ k`.  
> So at each index j, we ask — *"Have we seen `(prefixXor ^ k)` before?"*  
> If yes, count += frequency of that value in the map.

---

## 🔄 Approaches

### ⚡ Approach 1: Brute Force – All Subarrays
**Idea:** For each starting index `i`, maintain a running XOR extending to each `j`. If XOR hits `k`, increment count.  
**Time:** O(n²) | **Space:** O(1)

```java
class Solution {
    public int subarraysWithXorBrute(int[] arr, int k) {
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
}
```

---

### 🧠 Approach 2: Optimal – Prefix XOR + HashMap
**Idea:**
- Maintain a running `prefixXor` as you traverse the array
- At each index, compute `target = prefixXor ^ k`
- If `target` exists in the map → those many subarrays ending here have XOR = k
- Store `prefixXor` frequency in the map
- Seed map with `{0: 1}` to handle subarrays starting from index 0

**Time:** O(n) | **Space:** O(n)

```java
class Solution {
    public int subarraysWithXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefix has XOR 0

        int prefixXor = 0, count = 0;

        for (int num : arr) {
            prefixXor ^= num;

            int target = prefixXor ^ k;
            count += map.getOrDefault(target, 0);

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Prefix XOR + HashMap | O(n) | O(n) |

---

## 🗒 Personal Notes

> - Core equation: `prefixXor[j] ^ prefixXor[i] = k` → `prefixXor[i] = prefixXor[j] ^ k`
> - Seeding `map.put(0, 1)` is critical — it handles subarrays that start from index 0 (entire prefix equals k)
> - Identical pattern to "Subarray Sum = K" — just swap addition with XOR
> - XOR is self-inverse: `a ^ a = 0`, `a ^ 0 = a` → key property that makes prefix XOR work
> - Pattern: Prefix XOR + HashMap — process element, query map, then update map (order matters)

---
