class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int index = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            if(isPalindrome(s,0,i))
            {
                index = i;
                break;
            }
        }

        String suffix = s.substring(index + 1);
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        return reversedSuffix + s;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}