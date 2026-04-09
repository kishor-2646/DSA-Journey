# p30. Majority Element II

> **Platform:** [LeetCode 229](https://leetcode.com/problems/majority-element-ii/) | [GeeksForGeeks](https://www.geeksforgeeks.org/problems/majority-vote/1) |  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `Sorting` `Counting`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums`, return all elements that appear **more than ⌊n/3⌋ times**.

**Example:**
```
Input:  nums = [3, 2, 3]   →  Output: [3]
Input:  nums = [1, 2]      →  Output: [1, 2]
Input:  nums = [1,1,1,3,3,2,2,2] → Output: [1, 2]
```

---

## 💡 Intuition

> **Key observation:** There can be **at most 2** elements that appear more than `n/3` times.  
> (If 3 elements each appeared > n/3 times, total count would exceed n — impossible.)
>
> **Extended Boyer-Moore Voting (Optimal):**  
> Maintain 2 candidates and 2 counters.  
> - If num matches a candidate → increment its count  
> - If a counter is 0 → set new candidate  
> - Otherwise → decrement both counters (cancel out with a third group)  
> Then verify both candidates with a second pass.

---

## 🔄 Approaches

### 🐌 Brute Force — Nested Loops
**Time:** O(n²) | **Space:** O(1)
```java
// Count each element with inner loop, check if > n/3
```

### 🧠 Better — HashMap Frequency Count
**Time:** O(n) | **Space:** O(n)
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            if (e.getValue() > n / 3) result.add(e.getKey());
        return result;
    }
}
```

### ⚡ Optimal — Extended Boyer-Moore Voting
**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cand1 = Integer.MIN_VALUE, cnt1 = 0;
        int cand2 = Integer.MIN_VALUE, cnt2 = 0;

        // Phase 1: Find candidates
        for (int num : nums) {
            if      (num == cand1)  cnt1++;
            else if (num == cand2)  cnt2++;
            else if (cnt1 == 0)   { cand1 = num; cnt1 = 1; }
            else if (cnt2 == 0)   { cand2 = num; cnt2 = 1; }
            else                  { cnt1--; cnt2--; }
        }

        // Phase 2: Verify
        cnt1 = 0; cnt2 = 0;
        for (int num : nums) {
            if      (num == cand1) cnt1++;
            else if (num == cand2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > n / 3) result.add(cand1);
        if (cnt2 > n / 3) result.add(cand2);
        return result;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute (Nested Loops) | O(n²) | O(1) |
| Better (HashMap) | O(n) | O(n) |
| Optimal (Boyer-Moore) | O(n) | O(1) |

---

## 🗒 Personal Notes

> - 🔥 Best approach = Extended Boyer-Moore Voting (2 candidates instead of 1)
> - At most 2 elements can be majority (> n/3). At most 1 can be majority (> n/2)
> - Phase 2 verification is mandatory — candidates from Phase 1 are not guaranteed
> - The `else { cnt1--; cnt2-- }` block "cancels" 3 different elements
> - Pattern: Boyer-Moore generalized for n/3 threshold

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p30_MajorityElement2/page1.png)

---
