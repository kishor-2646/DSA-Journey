# [2]. Find Second Smallest and Second Largest Element in an array

> **Difficulty:** 🟢 easy 
> **Topic Tags:** `Array`  


---

## 📝 Problem Statement

> Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

**Example:**
```
Input: 
[1, 2, 4, 7, 7, 5]  

Output: 
Second Smallest : 2  
Second Largest : 5 

Explanation: 
The elements are sorted as 1, 2, 4, 5, 7, 7.  
Hence, the second smallest element is 2, and the second largest element is 5.
```

---

## 💡 Intuition

>Traverse the array once while maintaining smallest, second smallest, largest, and second largest values.
Update them dynamically by comparing each element and ensuring distinct values.
Avoid sorting to achieve optimal O(n) time complexity.

---

## 🔄 Approaches

### 🐌 Brute Force
**Idea:** Sort the array and pick second distinct smallest and largest elements.  
**Time:** O(n log n) | **Space:** O(1)

```cpp
// Brute force code here
import java.util.*;

class Solution {
    public static void findElements(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            System.out.println("-1 -1");
            return;
        }

        Arrays.sort(arr);

        int smallest = arr[0];
        int largest = arr[n - 1];

        int secondSmallest = -1;
        int secondLargest = -1;

        // Find second smallest
        for (int i = 1; i < n; i++) {
            if (arr[i] != smallest) {
                secondSmallest = arr[i];
                break;
            }
        }

        // Find second largest
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }

        System.out.println("Second Smallest : " + secondSmallest);
        System.out.println("Second Largest : " + secondLargest);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        findElements(arr);
    }
}
```

---

### ⚡ Optimal
**Idea:** Traverse once and maintain four variables to track smallest, second smallest, largest, and second largest. 
**Time:** O(n) | **Space:** O(1)

```cpp
// Optimal code here
class Solution {
    public static void findElements(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            System.out.println("-1 -1");
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int x : arr) {

            // smallest logic
            if (x < smallest) {
                secondSmallest = smallest;
                smallest = x;
            } else if (x > smallest && x < secondSmallest) {
                secondSmallest = x;
            }

            // largest logic
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x < largest && x > secondLargest) {
                secondLargest = x;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) secondSmallest = -1;
        if (secondLargest == Integer.MIN_VALUE) secondLargest = -1;

        System.out.println("Second Smallest : " + secondSmallest);
        System.out.println("Second Largest : " + secondLargest);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        findElements(arr);
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(n log n) | O(1) |
| Optimal | O(n) | O(1) |

---

## 🗒 Personal Notes

> - "Always look for second distinct values, not second index"
> - "Handle edge cases like single element or all elements equal"
> - "Similar problems: Find kth smallest/largest, Top 2 elements in array"

---

## 🖊 Handwritten Notes

<!-- Add your handwritten notes image here -->
<!-- ![Notes](../../assets/topic_problem-name_notes.jpg) -->

*Handwritten notes: see `/assets/` folder*

---
