# 10. Palindrome Number

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/check-if-a-number-is-palindrome/) | [LeetCode](https://leetcode.com/problems/palindrome-number/)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Math` `String`  
> **Date Solved:** 8-4-2026

---

## 📝 Problem Statement

> Given an integer `n`, return `true` if it is a **palindrome**, and `false` otherwise.
> A number is a palindrome if it reads the same forwards and backwards, with **no leading zeroes** in the reversed number.

**Examples:**
```
Input:  n = 555   →  Output: true
Input:  n = 123   →  Output: false
Input:  n = 800   →  Output: false  (reverse = 008 = 8 ≠ 800)
```

---

## 💡 Intuition

> **Reverse & Compare:** Reverse the digits of the number mathematically and check if the reversed value equals the original.  
> Simple and optimal — no extra space needed (except for the reversed variable).
>
> **String Approach:** Convert number to a string and compare characters from both ends (index `i` and `len-i-1`) until the middle.  
> Easier to reason about but uses O(digits) space for the string.

---

## 🔄 Approaches

### ⚡ Approach 1: Reverse & Compare
**Idea:** Extract digits one by one using `% 10`, build the reversed number, then compare.  
Use `Math.abs(n)` to handle negative numbers.  
**Time:** O(digits) | **Space:** O(1)

```java
class Solution {
    public static boolean isPalindrome(int n) {
        int temp = Math.abs(n);
        int reverse = 0;

        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }

        return reverse == Math.abs(n);
    }
}
```

---

### 🧠 Approach 2: String Conversion
**Idea:**
- Convert number to string using `Integer.toString(Math.abs(n))`
- Loop from `i = 0` to `len / 2`
- At each step, compare `s.charAt(i)` with `s.charAt(len - i - 1)`
- If any mismatch → return `false`
- If loop completes → return `true`

**Time:** O(digits) | **Space:** O(digits) – for the string

```java
class Solution {
    public static boolean isPalindromeString(int n) {
        String s = Integer.toString(Math.abs(n));
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }

        return true;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Reverse & Compare | O(digits) | O(1) |
| String Conversion | O(digits) | O(digits) |

---

## 🗒 Personal Notes

> - **Approach 1** is preferred in interviews — no extra space, purely mathematical
> - Always handle **negative numbers** using `Math.abs(n)`
> - Watch out for numbers ending in `0` (like `800`) — reverse becomes `008 = 8`, which is not equal → correctly returns `false`
> - String approach is more readable and easier to implement quickly
> - Pattern: Reverse digits / Two-pointer on string

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/a01_basic_math/10_Palindrome/page1.png)