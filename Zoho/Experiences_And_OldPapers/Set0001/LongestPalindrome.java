package Experiences_And_OldPapers.Set0001;

/*
Find the Longest Palindromic Substring.
Ex:
Input : “Revives”
Output : “evive”

Similar LeetCode problem: 5. Longest Palindromic Substring
 */
public class LongestPalindrome {
    public static void main(String[] args) {

        String s1 = "Revives";
        System.out.println(findLongestPalindrome(s1));

    }

/*
Brute force
Time Complexity: O(N^3)
Space Complexity: O(1)
 */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        String longest = "";

        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // Check if substring from i to j is a palindrome
                if (isPalindrome(s, i, j)) {
                    // Update longest if current is larger
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    // Modular helper to check palindrome in-place using two pointers
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
    Optimal Solution : expand around centre method
    Time Complexity: O(N^2)
    Space Complexity: O(1)

     */
    static int maxStart = 0;
    static int maxLen = 0;
    public static String findLongestPalindrome(String str)
    {
        int n = str.length();
        int i = 0;


        while(i < n)
        {

            expand(str,i,i);
            expand(str,i,i + 1);

            i++;
        }

        return str.substring(maxStart,maxStart + maxLen);

    }

    public static void expand(String str, int i, int j)
    {
        while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j))
        {
            i--;
            j++;
        }

        int currLen = j - i - 1;
        if(maxLen < currLen)
        {
            maxLen = currLen;
            maxStart = i + 1;
        }
    }
}
