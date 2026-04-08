package a1_easy.p10.Palindrome;

public class Palindrome {

    // ─────────────────────────────────────────────
    // Approach 1: Reverse & Compare
    // Reverse the number and compare with original.
    // If reverse == original → Palindrome.
    // T(n) = O(digits), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isPalindrome(int n) {
        int temp = Math.abs(n); // handle negative numbers
        int reverse = 0;

        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }

        return reverse == Math.abs(n);
    }

    // ─────────────────────────────────────────────
    // Approach 2: String Conversion
    // Convert number to String, compare chars from
    // both ends towards the middle.
    // T(n) = O(digits), S(n) = O(digits) – for string
    // ─────────────────────────────────────────────
    public static boolean isPalindromeString(int n) {
        String s = Integer.toString(Math.abs(n));
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(555));    // true
        System.out.println(isPalindrome(123));    // false
        System.out.println(isPalindrome(800));    // false (reverse = 008 = 8)
        System.out.println(isPalindrome(121));    // true

        System.out.println(isPalindromeString(555)); // true
        System.out.println(isPalindromeString(123)); // false
    }
}