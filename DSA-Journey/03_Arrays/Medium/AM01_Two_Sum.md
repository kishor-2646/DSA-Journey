# AM01. Two Sum

> **Platform:** [LeetCode 1](https://leetcode.com/problems/two-sum/)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Hash Map`  
> **Date Solved:** <!-- YYYY-MM-DD -->

---

## 📝 Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers that add up to `target`.

**Example:**
```
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

---

## 💡 Intuition

For each element `nums[i]`, we need to find if `target - nums[i]` exists in the array. Instead of searching linearly, we store elements in a hash map as we go — so lookup is O(1).

---

## 🔄 Approaches

### 🐌 Brute Force
**Idea:** Check every pair (i, j) where i < j  
**Time:** O(n²) | **Space:** O(1)

```cpp
vector<int> twoSum(vector<int>& nums, int target) {
    int n = nums.size();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] + nums[j] == target)
                return {i, j};
        }
    }
    return {};
}
```

---

### ⚡ Optimal — Hash Map
**Idea:** Store `{value → index}` in a map. For each element, check if complement exists.  
**Time:** O(n) | **Space:** O(n)

```cpp
vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> mp; // {value -> index}
    for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i];
        if (mp.count(complement))
            return {mp[complement], i};
        mp[nums[i]] = i;
    }
    return {};
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(n²) | O(1) |
| Optimal (Hash Map) | O(n) | O(n) |

---

## 🗒 Personal Notes

> - Key insight: instead of finding the pair, find the **complement**
> - We process left to right — so when we find complement in map, it's already a valid earlier index
> - Edge case: what if same element appears twice? Map stores latest index, but we check before inserting ✅
> - **Two-pointer** also works IF array is sorted (but returns values, not indices)

---

## 🖊 Handwritten Notes

<!-- ![Notes](../../assets/arrays_two_sum_notes.jpg) -->
*Add your handwritten notes photo here*

---
