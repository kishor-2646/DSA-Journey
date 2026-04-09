# 26. Leaders in Array

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1) |  
> **LeetCode:** No direct equivalent |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an array `arr[]`, find all the **leaders** in the array.  
> An element is a leader if it is **strictly greater than all elements to its right**.  
> The **rightmost element** is always a leader.

**Example:**
```
Input:  arr[] = [4, 7, 1, 0]
Output: [7, 1, 0]
Explanation: 7 > {1,0}, 1 > {0}, 0 is rightmost → all leaders.

Input:  arr[] = [10, 22, 12, 3, 0, 6]
Output: [22, 12, 6]
Explanation: 22 > {12,3,0,6}, 12 > {3,0,6}, 6 is rightmost.
```

---

## 💡 Intuition

> **Brute Force:** For each element, scan everything to its right. If none is ≥ it → it's a leader.
>
> **Optimal (Scan from Right):**  
> The rightmost element is always a leader.  
> Traverse from right to left, keeping track of the **running max**.  
> If `nums[i] > max` → it's a leader (greater than everything already seen to its right).  
> Update `max = nums[i]`.  
> Reverse the result at the end to restore left-to-right order.

---

## 🔄 Approaches

### 🐌 Brute Force — Nested Loops
**Idea:** For each element, check all elements to its right. If all are smaller → leader.  
**Time:** O(n²) | **Space:** O(1)

```java
class Solution {
    public List<Integer> leaders(int[] nums) {
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

            if (leader) ans.add(nums[i]);
        }

        return ans;
    }
}
```

---

### ⚡ Optimal — Right to Left Scan
**Algorithm:**
1. Set `max = nums[n-1]`, add it to result (rightmost always a leader)
2. Traverse from `i = n-2` down to `0`
3. If `nums[i] > max` → add to result, update `max = nums[i]`
4. `Collections.reverse(ans)` to get left-to-right order

**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return ans;

        int max = nums[n - 1];
        ans.add(nums[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute (Nested Loops) | O(n²) | O(1) |
| Optimal (Right Scan) | O(n) | O(1) |

---

## 🗒 Personal Notes

> - 🔥 Best approach = Right to Left scan
> - Rightmost element is **always** a leader — initialize max with it
> - Traverse backwards, track running max → leaders are those strictly greater than max
> - `Collections.reverse()` restores natural order at the end
> - Pattern: Right-to-left traversal with running maximum

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p26_LeadersInArray/page1.png)
![Handwritten Notes](../../../assets/p26_LeadersInArray/page2.png)

---
