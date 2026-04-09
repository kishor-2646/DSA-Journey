# p32. Four Sum

> **Platform:** [LeetCode 18](https://leetcode.com/problems/4sum/) |  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `Two Pointers` `Sorting`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums` and an integer `target`, return all unique quadruplets `[a, b, c, d]` such that `a + b + c + d == target`.

**Example:**
```
Input:  nums = [1, 0, -1, 0, -2, 2], target = 0
Output: [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]
```

---

## 💡 Intuition

> **Direct extension of ThreeSum:** Fix two outer pointers `i` and `j`, use two pointers `left` and `right` for the remaining two elements.  
> Sort first to enable two-pointer technique and easy duplicate skipping.  
> Use `long` for sum to handle integer overflow.

---

## 🔄 Approach

### ⚡ Optimal — Sort + Two Outer Loops + Two Pointers
**Time:** O(n³) | **Space:** O(1)

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip dup i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip dup j

                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if      (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < right && nums[left]  == nums[left  - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute (4 loops) | O(n⁴) | O(n) |
| Optimal (Sort + 2ptr) | O(n³) | O(1) |

---

## 🗒 Personal Notes

> - 🔥 Pattern: Generalization of ThreeSum — fix more pointers, use 2-pointer for last 2
> - Use `long sum` to avoid integer overflow (nums[i] can be 10⁹)
> - Skip duplicate rules: same as ThreeSum but for 4 pointers (i, j, left, right)
> - k-Sum pattern: `O(n^(k-1))` time — each additional fixed pointer adds one dimension

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p32_FourSum/page1.png)

---
